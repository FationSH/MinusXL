package minusXL_charts_management;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import minusXL_data_management.Spreadsheet;

public class ChartsManager extends JFrame {

	private static final long serialVersionUID = 1L;

	private Spreadsheet theSheet;
	
	/*
	 * Constructor for class ChartsManager.
	 */
	public ChartsManager(Spreadsheet theSheet, String title, String type, String xTitle, String yTitle, String[] range) {
		super(title);
		this.theSheet = theSheet;
		
		if (type.equals("Line graph")) {
			JPanel chartPanel = createLineChart(title, xTitle, yTitle, range);
			add(chartPanel, BorderLayout.CENTER);
		} else if (type.equals("Bar graph")) {
			JPanel chartPanel = createBarChart(title, xTitle, yTitle, range);
			add(chartPanel, BorderLayout.CENTER);
		}
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/*
	 * This method creates a line chart.
	 */
	public ChartPanel createLineChart(String title, String xTitle, String yTitle, String[] range) {        
		XYDataset dataset = createXYDataset(range);
		 
	    JFreeChart lineChart = ChartFactory.createXYLineChart(title, xTitle, yTitle, dataset);
		customizeChart(lineChart);
		return new ChartPanel(lineChart);
	}
	
	/*
	 * This method creates a bar chart.
	 */
	public ChartPanel createBarChart(String title, String xTitle, String yTitle, String[] range) {
		DefaultCategoryDataset dataset = createBarDataset(xTitle, yTitle, range);

	    JFreeChart barChart = ChartFactory.createBarChart(title, xTitle, yTitle, dataset);
		return new ChartPanel(barChart);
	}
	
	/*
	 * This method creates the data set to use for the line chart.
	 */
	private XYDataset createXYDataset(String[] range) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Object 1");
		
		for (int i = Integer.parseInt(range[0]); i < Integer.parseInt(range[2]); i++) {
			for (int j = Integer.parseInt(range[1]); j < Integer.parseInt(range[3]); j++) {
				int number1 = Integer.parseInt(theSheet.getCellValue(i, j));
				int number2 = j;
				series1.add(number1, number2);
			}
		}
		dataset.addSeries(series1);
		
		return dataset;
	}
	
	/*
	 * This method creates the data set to use for the bar chart.
	 */
	private DefaultCategoryDataset createBarDataset(String xTitle, String yTitle, String[] range) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = Integer.parseInt(range[0]); i < Integer.parseInt(range[2]); i++) {
			for (int j = Integer.parseInt(range[1]); j < Integer.parseInt(range[3]); j++) {
				int number1 = Integer.parseInt(theSheet.getCellValue(i, j));
				dataset.setValue(number1, Integer.valueOf(i), Integer.valueOf(j));
			}
		}
		
		return dataset;
	}
	
	/*
	 * This method customizes the chart.
	 */
	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.YELLOW);

		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
	
}
