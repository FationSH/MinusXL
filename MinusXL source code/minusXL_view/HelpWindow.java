package minusXL_view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HelpWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public HelpWindow() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setModal(true);
		setTitle("Help");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblSendEmailTo = new JLabel("Send an e-mail to MinusXL support.");
			lblSendEmailTo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblSendEmailTo.setBounds(10, 11, 414, 14);
			getContentPane().add(lblSendEmailTo);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 180);
		getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(editorPane);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		getContentPane().add(btnCancel);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSend.setBounds(236, 227, 89, 23);
		getContentPane().add(btnSend);
	}
}
