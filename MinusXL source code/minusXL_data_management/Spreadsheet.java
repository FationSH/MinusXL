package minusXL_data_management;

import minusXL_file_management.CSVFileGenerator;
import minusXL_file_management.CSVFileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Spreadsheet {

	private String name;
	private int x;
	private int y;
	private String functionType;
	private int isFunction;
	private Cell[][] cellObejct;

	/*
	 * Constructor for class Spreadsheet.
	 */
	public Spreadsheet(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.cellObejct = new Cell[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				this.cellObejct[i][j] = new StringCell(i, j, null);
				this.cellObejct[i][j].setCellValue("");
			}
		}
	}

	/*
	 * Returns spreadsheet's name.
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Returns spreadsheet's x size.
	 */
	public int getX() {
		return this.x;
	}

	/*
	 * Returns spreadsheet's y size.
	 */
	public int getY() {
		return this.y;
	}

	/*
	 * Sets the x size of the spreadsheet.
	 */
	public void setX(int otherX) {
		this.x = otherX;
	}
	
	/*
	 * Sets the y size of the spreadsheet
	 */
	public void setY(int otherY) {
		this.y = otherY;
	}
	
	/*
	 * This method sets the function we want to use on the current spreadsheet.
	 * If it is equals to None then no function is used.
	 */
	public void setCurrentFunction(String function) {
		this.functionType = function;
	}

	/*
	 * This method gets the function we want to use on the current spreadsheet.
	 */
	public String getCurrentFunction() {
		return this.functionType;
	}

	/*
	 * This method tells the program that we currently have a function to process.
	 */
	public void setFunctionEnabled(int value) {
		this.isFunction = value;
	}

	/*
	 * This method tells us weather we have a function to process or not.
	 */
	public int getFunctionEnabled() {
		return this.isFunction;
	}

	/*
	 * This method populates cells accordingly.
	 */
	public void populateCell(int i, int j, Object value) {
		if (this.isFunction == 1) {
			cellObejct[i][j] = new FunctionCell(i, j, value, this.functionType);
			cellObejct[i][j].setCellValue(value);
		} else {
			if (value instanceof String) { // if its a string
				cellObejct[i][j] = new StringCell(i, j, (String) value);
				cellObejct[i][j].setCellValue(value);
			} else if (value instanceof Integer) { // if it is a number
				cellObejct[i][j] = new NumberCell(i, j, (int) value);
				cellObejct[i][j].setCellValue(value);
			} else if (value instanceof Boolean) { // if it is true or false
				cellObejct[i][j] = new BooleanCell(i, j, (boolean) value);
				cellObejct[i][j].setCellValue(value);
			}
		}
	}

	/*
	 * This method sets the cell value at given coordinations.
	 */
	public void setCellValue(int otherX, int otherY, Object otherValue) {
		this.cellObejct[otherX][otherY].setCellValue(otherValue);
	}
	
	/*
	 * This method returns spreadhsheet's value at given coordinations.
	 */
	public String getCellValue(int otherX, int otherY) {
		return this.cellObejct[otherX][otherY].getCellValue().toString();
	}
	
	/*
	 * This method sends spreadsheet's data to the CSV file generator.
	 */
	public void saveCSVFile(FileWriter theFile) throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		int dataPerLine = this.x;

		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				data.add(this.cellObejct[i][j].getCellValue() + "");
			}
		}
		CSVFileGenerator csvRequset = new CSVFileGenerator();
		csvRequset.createCSVFile(theFile, data, dataPerLine);
	}

	/*
	 * This method gets the spreadsheet's data in the application.
	 */
	public void readCSVFile(Scanner inputStream, Workbook theWorkbook) throws IOException {
		ArrayList<String> readData = new ArrayList<String>();
		CSVFileReader readCSV = new CSVFileReader();
		int newX;
		int newY;

		readData = readCSV.readCSVFile(inputStream);
		newX = Integer.parseInt(readData.get(readData.size()-2));
		newY = Integer.parseInt(readData.get(readData.size()-1));
		
		this.x = newX;
		this.y = newY;
		
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				this.cellObejct[i][j] = new StringCell(i, j, null);
				this.cellObejct[i][j].setCellValue("");
			}
		}
		
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				//System.out.println(i*this.x+j);
				//this.cellObejct[i][j].setCellValue(readData.get(i*this.x+j)); // 2d to 1d array index conversion
			}
		}
		
		theWorkbook.addSheet(this.name, this.x, this.y);
	}
	
	/*
	 * This method prints the spreadsheet's data for testing purposes.
	 */
	public void printCells() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(cellObejct[i][j].getCellValue() + " ");
			}
			System.out.println();
		}
	}

}
