package minusXL_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import minusXL_data_management.Workbook;
import minusXL_data_management.Spreadsheet;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Color;

public class FunctionWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private String[] allFunctions = {
			"ABS", "COS", "SIN", "TAN", "POW", "SUM", "MULT", "LOG", "LOG10", "AND", "OR", "NOT", "XOR",
			"MAX", "MIN", "MEAN", "MEDIAN", "STDDEV", "CONCAT", "INCLUDES", "TRIM", "REMOVE"};
	private String[] mathTrigFunctions = {"ABS", "COS", "SIN", "TAN", "POW", "SUM", "MULT", "LOG", "LOG10"};
	private String[] logicalFunctions = {"AND", "OR", "NOT", "XOR"};
	private String[] statisticalFunctions = {"MAX", "MIN", "MEAN", "MEDIAN", "STDDEV"};
	private String[] textFunctions = {"CONCAT", "INCLUDES", "TRIM", "REMOVE"};

	/**
	 * Create the dialog.
	 */
	public FunctionWindow(Workbook myWorkbook) {
		//setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSelectCatergory = new JLabel("Select catergory:");
		lblSelectCatergory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelectCatergory.setBounds(10, 11, 414, 14);
		contentPanel.add(lblSelectCatergory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 402, 148);
		contentPanel.add(scrollPane);

		// create and set the model for the sheet list
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));

		scrollPane.setViewportView(list);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"All", "Math and Trig", "Logical", "Statistical", "Text"}));
		comboBox.setBounds(100, 8, 195, 20);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.removeAllElements();
				if (comboBox.getSelectedItem().equals("All")) {
					for (int i = 0; i < allFunctions.length; i++) {
						listModel.addElement(allFunctions[i]);
					}
				} else if (comboBox.getSelectedItem().equals("Math and Trig")) {
					for (int i = 0; i < mathTrigFunctions.length; i++) {
						listModel.addElement(mathTrigFunctions[i]);
					}
				} else if (comboBox.getSelectedItem().equals("Logical")) {
					for (int i = 0; i < logicalFunctions.length; i++) {
						listModel.addElement(logicalFunctions[i]);
					}
				} else if (comboBox.getSelectedItem().equals("Statistical")) {
					for (int i = 0; i < statisticalFunctions.length; i++) {
						listModel.addElement(statisticalFunctions[i]);
					}
				} else if (comboBox.getSelectedItem().equals("Text")) {
					for (int i = 0; i < textFunctions.length; i++) {
						listModel.addElement(textFunctions[i]);
					}
				}
				list.setSelectedIndex(0);
			}
		});
		contentPanel.add(comboBox);
		
		JLabel lblSelectAFunction = new JLabel("Select a function:");
		lblSelectAFunction.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelectAFunction.setBounds(10, 36, 414, 14);
		contentPanel.add(lblSelectAFunction);

		JSeparator separator = new JSeparator();
		separator.setBounds(8, 220, 410, 8);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String function = list.getModel().getElementAt(list.getSelectedIndex());
						int index = myWorkbook.getSelectedIndex();
						Spreadsheet currentSheet = myWorkbook.getSelectedSheet(index);
						currentSheet.setCurrentFunction(function);
						currentSheet.setFunctionEnabled(1);

						setVisible(false);
					}
				});
				okButton.setBackground(new Color(240, 240, 240));
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
