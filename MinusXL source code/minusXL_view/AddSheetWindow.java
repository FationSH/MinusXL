package minusXL_view;

import minusXL_data_management.Workbook;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddSheetWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField xTextField;
	private JTextField yTextField;

	/**
	 * Create the dialog.
	 */
	public AddSheetWindow(Workbook myWorkbook) {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Add");
		setModal(true);
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 110);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblName.setBounds(10, 13, 414, 14);
			contentPanel.add(lblName);
		}
		{
			nameTextField = new JTextField();
			nameTextField.setBounds(96, 10, 328, 20);
			contentPanel.add(nameTextField);
			nameTextField.setColumns(33);
		}

		JLabel lblDimensions = new JLabel("Dimensions:");
		lblDimensions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDimensions.setBounds(10, 38, 414, 14);
		contentPanel.add(lblDimensions);

		xTextField = new JTextField();
		xTextField.setBounds(96, 35, 60, 20);
		contentPanel.add(xTextField);
		xTextField.setColumns(10);

		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblX.setBounds(163, 38, 18, 14);
		contentPanel.add(lblX);

		yTextField = new JTextField();
		yTextField.setBounds(176, 35, 60, 20);
		contentPanel.add(yTextField);
		yTextField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(335, 76, 89, 23);
		contentPanel.add(btnCancel);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			// create a new spreadsheet
			public void actionPerformed(ActionEvent arg0) {
				String nameTextFieldValue = nameTextField.getText();
				if (nameTextFieldValue.isEmpty()) {
					nameTextFieldValue = "DefaultSheet"; // default name if the user does not give input
				}
				try { // only accept numbers as dimension input from user
			        int x = Integer.parseInt(xTextField.getText());
			        int y = Integer.parseInt(yTextField.getText());
					myWorkbook.addSheet(nameTextFieldValue, x, y);
					setVisible(false);
			    } catch (NumberFormatException nfe) {
			    	xTextField.setText("");
			    	yTextField.setText("");
			    }
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(236, 76, 89, 23);
		contentPanel.add(btnCreate);
	}
}
