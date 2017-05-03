package minusXL_view;

import minusXL_data_management.Spreadsheet;
import minusXL_data_management.Workbook;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class NewWorkbook {

	private static int workbookCount = 0; // need static variable to be the same for every newWorkbook instance

	private JFrame frmMinusxl;
	private JLabel FSpyLabel;
	private JScrollPane mainTableScrollPane;
	private JTable mainTable;
	private JTextField textCellField;
	private JMenuBar mainMenuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JMenuItem mntmDelete;
	private JMenuItem mntmAdd;
	private JMenuItem mntmOpen;
	private JMenu mnGraphs;
	private JMenuItem mntmCreateGraph;
	private JMenu mnHelp;
	private JMenuItem mntmTools;
	private JMenuItem mntmOnline;
	private JMenuItem mntmAbout;
	private JButton btnFx;
	private JList<String> sheetList;
	private JScrollPane scrollPane;

	/*
	 * Creates a new frame window with all the workbook properties.
	 */
	public void createWorkbookWindow(Workbook myWorkbook) {
		workbookCount++; // counter for every time a new workbook is created
		// create the main frame window
		frmMinusxl = new JFrame();
		// if the user closes the program show save window
		frmMinusxl.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				JLabel exitSavePaneLabel = new JLabel("Do you want to save the changes you made to " + sheetList.getSelectedValue() + "?");
				exitSavePaneLabel.setFont(new Font("Arial", Font.PLAIN, 11));
				String dialogButtons[] = {"Save", "Don't Save", "Cancel"};
				int promptResult = JOptionPane.showOptionDialog(null, exitSavePaneLabel, "MinusXL", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, dialogButtons, dialogButtons[2]);
				if (promptResult == 0) { // if the user pressed save
					JFileChooser fileChooser = new JFileChooser();
					int index = sheetList.getSelectedIndex();
					Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
					int userSelection = fileChooser.showSaveDialog(null);
					if (userSelection == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						FileWriter theFile;
						try {
							theFile = new FileWriter(file + ".csv");
							currentSheet.saveCSVFile(theFile);
						} catch (IOException e) {
							e.printStackTrace();
						}
						frmMinusxl.setVisible(false);
						workbookCount--;
						if (workbookCount == 0) {
							System.exit(0);
						}
					}
				} else if (promptResult == 1) { // if the user pressed do not save
					frmMinusxl.setVisible(false);
					workbookCount--;
					if (workbookCount == 0) {
						System.exit(0);
					}
				} // else if cancel hide the dialog window
			}
		});
		frmMinusxl.setTitle(myWorkbook.getName());
		frmMinusxl.setBounds(100, 100, 567, 485); // 567, 487
		frmMinusxl.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMinusxl.getContentPane().setLayout(null);
		frmMinusxl.setLocationRelativeTo(null);

		// create the company logo
		FSpyLabel = new JLabel("FSpy");
		FSpyLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		FSpyLabel.setForeground(Color.BLUE);
		FSpyLabel.setBounds(502, 0, 53, 23);
		frmMinusxl.getContentPane().add(FSpyLabel);

		// create the pane for the main table
		mainTableScrollPane = new JScrollPane();
		mainTableScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainTableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainTableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainTableScrollPane.setBounds(10, 65, 533, 333);
		frmMinusxl.getContentPane().add(mainTableScrollPane);

		// create the table with cells
		mainTable = new JTable();
		mainTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mainTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainTableScrollPane.setViewportView(mainTable);
		mainTable.setBackground(Color.WHITE);
		mainTable.setForeground(new Color(0, 0, 0));
		mainTable.setColumnSelectionAllowed(true);
		mainTable.setCellSelectionEnabled(true);
		mainTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		mainTable.setToolTipText("");
		mainTable.setRowHeight(30);

		// this is used so that the user can not rearrange the columns on the table
		mainTable.getTableHeader().setReorderingAllowed(false);
		// select first row and first column of the table by default
		//mainTable.setRowSelectionInterval(0, 0);
		//mainTable.setColumnSelectionInterval(1, 1);

		// create the f(x) text field
		textCellField = new JTextField();
		textCellField.setBounds(67, 34, 474, 20);
		frmMinusxl.getContentPane().add(textCellField);
		textCellField.setColumns(10);
		
		// transfer the text data a cell contains to the text field
		mainTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = mainTable.getSelectedRow();
				int column = mainTable.getSelectedColumn();
				textCellField.setText((String)mainTable.getModel().getValueAt(row, column));
				int index = sheetList.getSelectedIndex();
				Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
				int x = mainTable.getSelectedRow();
				int y = mainTable.getSelectedColumn();
				String value = textCellField.getText();
				String function = currentSheet.getCurrentFunction();
				
				int[] selectedRows = mainTable.getSelectedRows();
				int[] selectedColumns = mainTable.getSelectedColumns();

				// function checks
				if (currentSheet.getFunctionEnabled() == 1) {
					//currentSheet.setFunctionEnabled(0);
					if (function.equals("SUM")) {
						int sum = 0;
						for (int i = selectedRows[0]; i < selectedRows[0]+selectedRows.length; i++) {
							for (int j = selectedColumns[0]; j < selectedColumns[0]+selectedColumns.length; j++) {
								sum += Integer.parseInt((String) mainTable.getModel().getValueAt(i, j));
							}
						}
						currentSheet.populateCell(x, y, sum);
					} else if (function.equals("MULT")) {
						int mult = 1;
						for (int i = selectedRows[0]; i < selectedRows[0]+selectedRows.length; i++) {
							for (int j = selectedColumns[0]; j < selectedColumns[0]+selectedColumns.length; j++) {
								mult *= Integer.parseInt((String) mainTable.getModel().getValueAt(i, j));
							}
						}
						currentSheet.populateCell(x, y, mult);
					} else { // some other function
						currentSheet.populateCell(x, y, value);
					}
				} else { // else it is just normal data cell edit
					boolean checkNum = true;
					try { // checks if input is a number
				        Integer.parseInt(value);
				    } catch (Exception e) {
				    	checkNum = false;
				    }
					if (checkNum == true) { // if it is a number
						int integerValue = Integer.parseInt(value);
						currentSheet.populateCell(x, y, integerValue);
					} else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) { // if it is boolean
						boolean booleanValue = Boolean.valueOf(value);
						currentSheet.populateCell(x, y, booleanValue);
						mainTable.getModel().setValueAt(value, x, y);
					} else { // if it is string
						currentSheet.populateCell(x, y, textCellField.getText());
					}
				}
				// reset functions after they have been used
				currentSheet.setFunctionEnabled(0);
				mainTable.getModel().setValueAt(currentSheet.getCellValue(x, y), x, y);
			}
		});
		// transfer the text from the text field to selected table cell
		textCellField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				int row = mainTable.getSelectedRow();
				int column = mainTable.getSelectedColumn();
				mainTable.getModel().setValueAt(textCellField.getText(), row, column);
			}
		});

		// create and set the model for the sheet list
		DefaultListModel<String> sheetListModel = new DefaultListModel<String>();
		sheetListModel.addElement("sheet1");

		myWorkbook.addSheet("sheet1", 20, 20);

		// the sheet list which let us choose spreadsheets in the current workbook
		sheetList = new JList<String>(sheetListModel);
		sheetList.setBounds(10, 409, 533, 15);
		frmMinusxl.getContentPane().add(sheetList);
		sheetList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		sheetList.setVisibleRowCount(1);
		sheetList.setSelectedIndex(0);
		sheetList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		sheetList.setFont(new Font("Tahoma", Font.PLAIN, 10));

		// create the menu bar at the top of the main window
		mainMenuBar = new JMenuBar();
		mainMenuBar.setToolTipText("");
		mainMenuBar.setBounds(0, 0, 555, 29);
		frmMinusxl.getContentPane().add(mainMenuBar);

		mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnFile.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenuBar.add(mnFile);

		// this button is used to create a new workbook
		mntmNew = new JMenuItem("New");
		mntmNew.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewWorkbookWindow newWindow = new NewWorkbookWindow();
				newWindow.setVisible(true);
			}
		});
		mnFile.add(mntmNew);

		// this button is used to save current working spreadsheet
		JMenuItem mntmSaveAs = new JMenuItem("Save as");
		mntmSaveAs.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		// handle save as button press request
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int index = sheetList.getSelectedIndex();
				Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
				int userSelection = fileChooser.showSaveDialog(null);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					FileWriter theFile;
					try {
						theFile = new FileWriter(file + ".csv");
						currentSheet.saveCSVFile(theFile);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		mnFile.add(mntmSaveAs);

		// this button is used to delete current working spreadsheet
		mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnFile.add(mntmDelete);

		// this button is used to add a new spreadsheet
		mntmAdd = new JMenuItem("Add");
		mntmAdd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSheetWindow frame = new AddSheetWindow(myWorkbook);
				frame.setVisible(true);
				int index = sheetList.getSelectedIndex();
				Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index+1);
				sheetListModel.addElement(currentSheet.getName());
			}
		});
		mnFile.add(mntmAdd);

		// this button is used to open a spreadsheet from a file in the current workbook
		mntmOpen = new JMenuItem("Open");
		mntmOpen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		// If the user clicks open button a new window opens
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int userSelection = fileChooser.showOpenDialog(null);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile(); // the file to open
					String fileName = file.getName();
					String[] fileNameParts = fileName.split("\\."); // split filename at period
					String sheetName = fileNameParts[0]; // keep filename without .csv extension
					Scanner inputStream;
					try {
						inputStream = new Scanner(new FileInputStream(file));
						sheetListModel.addElement(sheetName);
						Spreadsheet openedSheet = new Spreadsheet(sheetName, 0, 0);
						openedSheet.readCSVFile(inputStream, myWorkbook);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		mnFile.add(mntmOpen);

		// this is used to open the create graph window
		mnGraphs = new JMenu("Graphs");
		mnGraphs.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mainMenuBar.add(mnGraphs);

		mntmCreateGraph = new JMenuItem("Create");
		mntmCreateGraph.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmCreateGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = myWorkbook.getSelectedIndex();
				Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
				CreateGraphWindow frame = new CreateGraphWindow(currentSheet);
				frame.setVisible(true);
			}
		});
		mnGraphs.add(mntmCreateGraph);

		// TODO: help button with more options(optional)
		mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mainMenuBar.add(mnHelp);

		// TODO: tools button with more options(optional)
		mntmTools = new JMenuItem("Tools");
		mntmTools.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnHelp.add(mntmTools);

		// TODO: tools button with more options(optional)
		mntmOnline = new JMenuItem("Online");
		mntmOnline.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpWindow frame = new HelpWindow();
				frame.setVisible(true);
			}
		});
		mnHelp.add(mntmOnline);

		// This shows some general info about MinusXL application
		mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutWindow frame = new AboutWindow();
				frame.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);

		// create functions button
		btnFx = new JButton("Fx");
		btnFx.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionWindow frame = new FunctionWindow(myWorkbook);
				frame.setVisible(true);
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 422, 533, 15);
		frmMinusxl.getContentPane().add(scrollPane);

		btnFx.setBackground(Color.LIGHT_GRAY);
		btnFx.setBounds(10, 34, 47, 20);
		frmMinusxl.getContentPane().add(btnFx);

		// this listener is used so that it updates the spreadsheets when user clicks on the list
		sheetList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				int index = sheetList.getSelectedIndex();
				myWorkbook.setSelectedIndex(index);
				Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
				int x = currentSheet.getX();
				int y = currentSheet.getY();
				Object[][] tableModelData = new Object[x][y];
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						tableModelData[i][j] = currentSheet.getCellValue(i, j);
					}
				}
				String[] columnNames = new String[y];
				for (int i = 0; i < y; i++) {
					columnNames[i] = Integer.toString(i+1);
				}
				DefaultTableModel cellTableModel = new DefaultTableModel(tableModelData, columnNames);
				mainTable.setModel(cellTableModel);
			}
		});

		// this listener is used to delete all the selected spreadsheets from a list
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel deleteConfrimationLabel = new JLabel("Data may exist in the sheet(s) selected for deletion. To permanently delete the data, press Delete.");
				deleteConfrimationLabel.setFont(new Font("Arial", Font.PLAIN, 11));
				String dialogButtons[] = {"Delete", "Cancel"};
				int promptResult = JOptionPane.showOptionDialog(null, deleteConfrimationLabel, "MinusXL", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, dialogButtons, dialogButtons[1]);
				if (promptResult == 0) { // if the user pressed delete
					// remove the sheet from spreadsheet list
				    int[] selectedIndices = sheetList.getSelectedIndices();
			    	for (int i = selectedIndices.length-1; i >= 0; i--) {
				    	sheetListModel.remove(selectedIndices[i]);
						Spreadsheet currentSheet = myWorkbook.getSelectedSheet(selectedIndices[i]);
				    	myWorkbook.removeSheet(currentSheet);
				    	((DefaultTableModel) mainTable.getModel()).setRowCount(0);
				    }
				}
			}
		});

		// finally show the frame that contains the workbook
		frmMinusxl.setVisible(true);
	}
}
