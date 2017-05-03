package minusXL_view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

import minusXL_charts_management.ChartsManager;
import minusXL_data_management.Spreadsheet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateGraphWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField nameTextField;
	private JTextField xTextField;
	private JTextField yTextField;
	private JTextField dataRangeTextField;

	/**
	 * Create the dialog.
	 */
	public CreateGraphWindow(Spreadsheet theSheet) {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setTitle("Create graph");
		setModal(true);
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(null);
		
		JLabel graphLabel = new JLabel("Graph name:");
		graphLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		graphLabel.setBounds(10, 11, 414, 14);
		getContentPane().add(graphLabel);
		
		JLabel xLabel = new JLabel("x axis:");
		xLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		xLabel.setBounds(285, 45, 46, 14);
		getContentPane().add(xLabel);
		
		JLabel yLabel = new JLabel("y axis:");
		yLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		yLabel.setBounds(285, 75, 46, 14);
		getContentPane().add(yLabel);
		
		JLabel lblChartDataRange = new JLabel("Chart data range:");
		lblChartDataRange.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChartDataRange.setBounds(230, 103, 89, 14);
		getContentPane().add(lblChartDataRange);
		
		xTextField = new JTextField();
		xTextField.setBounds(324, 42, 100, 20);
		getContentPane().add(xTextField);
		xTextField.setColumns(10);
		
		yTextField = new JTextField();
		yTextField.setColumns(10);
		yTextField.setBounds(324, 73, 100, 20);
		getContentPane().add(yTextField);
		
		dataRangeTextField = new JTextField(); // range text field appropriate format: x1,y1:x2,y2
		dataRangeTextField.setBounds(324, 101, 100, 20);
		getContentPane().add(dataRangeTextField);
		dataRangeTextField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(335, 167, 89, 23);
		getContentPane().add(btnCancel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(76, 11, 348, 20);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 167, 146);
		getContentPane().add(scrollPane);

		DefaultListModel<String> graphListModel = new DefaultListModel<String>();
		graphListModel.addElement("Line graph");
		graphListModel.addElement("Bar graph");
		JList<String> graphList = new JList<String>(graphListModel);
		graphList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		graphList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		graphList.setSelectedIndex(0);
		scrollPane.setViewportView(graphList);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = nameTextField.getText();
				String type = graphList.getSelectedValue();
				String xTitle = xTextField.getText();
				String yTitle = yTextField.getText();
				String range = dataRangeTextField.getText();
				
				String[] coords = range.split(":");
				String x1y1 = coords[0];
				String x2y2 = coords[1];
				String[] coords2 = x1y1.split(",");
				String x1 = coords2[0];
				String y1 = coords2[1];
				String[] coords3 = x2y2.split(",");
				String x2 = coords3[0];
				String y2 = coords3[1];
				String[] returnString = {x1, y1, x2, y2};
				
				try { // checks if input is a number
					Integer.parseInt(x1);
					Integer.parseInt(y1);
					Integer.parseInt(x2);
					Integer.parseInt(y2);
			    } catch (Exception e) {
			    	JPanel panel = new JPanel();
					JOptionPane.showMessageDialog(panel, "Wrong range input!", "Warning", JOptionPane.WARNING_MESSAGE);
			    }
				
				ChartsManager chartRequest = new ChartsManager(theSheet, title, type, xTitle, yTitle, returnString);
				setVisible(false); // hide the create graph dialog
				chartRequest.setVisible(true); // show the chart frame
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(242, 167, 89, 23);
		getContentPane().add(btnCreate);
	}
}
