package minusXL_view;

import minusXL_data_management.*;

public class MainWindow {

	/**
	 * This method is the main method that launches the application.
	 */
	public static void main(String[] args) {
		new MainWindow().initialize();
	}

	/**
	 * This method does the initializations needed for the main application window and creates it using Workbook object.
	 */
	public void initialize() {
		Workbook myWorkbook = new Workbook("MinusXL Workbook");
		NewWorkbook mainWindow = new NewWorkbook();
		mainWindow.createWorkbookWindow(myWorkbook);
	}

}
