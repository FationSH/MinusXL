package minusXL_file_management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

	/*
	 * Constructor for class CSVFileReader.
	 */
	public CSVFileReader() {
	}

	/*
	 * This method reads a .csv file to the application.
	 */
	public ArrayList<String> readCSVFile(Scanner inputStream) throws IOException {
		ArrayList<String> returnData = new ArrayList<String>();
		String fileLine;
		String theData = "";
		int numberOfLines = 0;
		int numberOfColumns = 0;

		while (inputStream.hasNextLine()) {
			numberOfLines++;
			fileLine = inputStream.nextLine();
			numberOfColumns = 0;
			theData = "";
			char[] lineChars = new char[fileLine.length()];
			for(int i = 0; i < fileLine.length(); i++) {
				lineChars[i] = fileLine.charAt(i);
				if (lineChars[i] == ';') {
					theData += "";
					numberOfColumns++;
				} else {
					theData += fileLine.charAt(i);
				}
			}
			returnData.add(theData);
		}
		
		returnData.add(numberOfLines + "");
		returnData.add(numberOfColumns + "");
		inputStream.close();
		return returnData;
	}
}
