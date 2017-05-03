package minusXL_view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AboutWindow() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("About");
		setModal(true);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		{
			JLabel label = new JLabel("version 1.0");
			label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			label.setBounds(362, 136, 62, 14);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("MinusXL\u00AE 2015 FSpy Corporation. All rights reserved.");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(10, 11, 414, 14);
			getContentPane().add(label);
		}
		{
			JButton button = new JButton("Release highlights");
			button.setFont(new Font("Tahoma", Font.PLAIN, 11));
			button.setBounds(10, 30, 155, 23);
			getContentPane().add(button);
		}
		{
			JButton button = new JButton("View license agreement");
			button.setFont(new Font("Tahoma", Font.PLAIN, 11));
			button.setBounds(10, 90, 155, 23);
			getContentPane().add(button);
		}
		{
			JButton button = new JButton("FAQ");
			button.setFont(new Font("Tahoma", Font.PLAIN, 11));
			button.setBounds(10, 60, 155, 23);
			getContentPane().add(button);
		}
		{
			JButton button = new JButton("Close");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 11));
			button.setBounds(10, 120, 155, 23);
			getContentPane().add(button);
		}
	}

}
