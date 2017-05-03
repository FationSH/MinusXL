package minusXL_view;

import minusXL_data_management.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class NewWorkbookWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField nameTextField;

	/**
	 * Create the dialog.
	 */
	public NewWorkbookWindow() {
		createWorkbookDialogWindow();
	}

	public void createWorkbookDialogWindow() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("New workbook");
		setBounds(100, 100, 440, 120);
		getContentPane().setLayout(null);

		JLabel lblWorkbookName = new JLabel("Workbook name:");
		lblWorkbookName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWorkbookName.setBounds(10, 11, 404, 14);
		getContentPane().add(lblWorkbookName);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(325, 47, 89, 23);
		getContentPane().add(btnCancel);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTextFieldValue = nameTextField.getText();
				if (nameTextFieldValue.isEmpty()) {
					nameTextFieldValue = "MinusXL Workbook"; // default name if the user does not give input
				}
				setVisible(false);
				Workbook myNewWorkbook = new Workbook(nameTextFieldValue);
				NewWorkbook myWorkbook = new NewWorkbook();
				myWorkbook.createWorkbookWindow(myNewWorkbook); // Workbook
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(226, 47, 89, 23);
		getContentPane().add(btnCreate);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameTextField.setBounds(98, 8, 316, 20);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);	
	}

}
