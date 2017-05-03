package minusXL_data_management;

public class NumberCell extends Cell{

	private int value;

	/*
	 * Constructor for class NumberCell
	 */
	public NumberCell(int x, int y, int value) {
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
		this.value = (int) value;
	}

}
