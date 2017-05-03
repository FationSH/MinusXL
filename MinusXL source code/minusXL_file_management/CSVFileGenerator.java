package minusXL_file_management;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileGenerator {

	/*
	 * Constructor for class CSVFileGenerator.
	 */
	public CSVFileGenerator() {
	}

	/*
	 * This method creates a file.csv to disk.
	 */
	public void createCSVFile(FileWriter theFile, ArrayList<String> data, int dataPerLine) throws IOException {
		int count = 0;

		for (String item: data) {
			if (count == dataPerLine) {
				count = 0;
				theFile.write("\n");
			}
			count++;
			theFile.write(item + ";");
			theFile.flush();
		}
		theFile.close();
	}
}
