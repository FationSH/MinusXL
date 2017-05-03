package minusXL_data_management;

import java.util.ArrayList;

public class Workbook {

	private String name;
	private int index;
	private ArrayList<Spreadsheet> sheetList = new ArrayList<Spreadsheet>();

	/*
	 * Constructor for class Workbook.
	 */
	public Workbook(String name) {
		this.name = name;
		this.index = 0;
	}

	/*
	 * Returns workbook's name.
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Returns current selected sheet.
	 */
	public Spreadsheet getSelectedSheet(int index) {
		return sheetList.get(index);
	}

	/*
	 * Gets the selected index.
	 */
	public int getSelectedIndex() {
		return this.index;
	}
	
	/*
	 * Sets the current selected sheet.
	 */
	public void setSelectedIndex(int index) {
		this.index = index;
	}

	/*
	 * This method is called when we add a new Spreadsheet
	 */
	public void addSheet(String name, int x, int y) {
		Spreadsheet newSheet = new Spreadsheet(name, x, y);
		sheetList.add(newSheet);
	}

	/*
	 * This method adds an already created sheet object.
	 */
	public void addSheet(Spreadsheet theSheet) {
		sheetList.add(theSheet);
	}
	
	/*
	 * This method is called when we remove Spreadsheet
	 */
	public void removeSheet(Spreadsheet sheet) {
		sheetList.remove(sheet);
	}

}
