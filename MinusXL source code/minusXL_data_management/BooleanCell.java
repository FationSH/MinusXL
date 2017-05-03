package minusXL_data_management;

public class BooleanCell extends Cell{

	private boolean value;

	/*
	 * Constructor for class BooleanCell.
	 */
	public BooleanCell(int x, int y, boolean value) {
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
		this.value = (boolean) value;
	}

}
