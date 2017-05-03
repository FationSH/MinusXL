package minusXL_data_management;

public class StringCell extends Cell {

	private String value;

	/*
	 * Constructor for class StringCell
	 */
	public StringCell(int x, int y, String value) {
		super(x, y, value);
	}

	/*
	 * @see minusXL_data_management.Cell#getCellValue()
	 */
	public Object getCellValue() {
		return this.value;
	}

	/*
	 * @see minusXL_data_management.Cell#setCellValue()
	 */
	public void setCellValue(Object value) {
		this.value = (String) value + "";
	}

}
