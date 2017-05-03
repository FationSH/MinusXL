package minusXL_data_management;

public abstract class Cell {

	private int x;
	private int y;

	/*
	 * Constructor for class Cell.
	 */
	public Cell(int x, int y, Object value) {
		this.x = x;
		this.y = y;
	}

	/*
	 * Returns x value.
	 */
	public int getX() {
		return this.x;
	}

	/*
	 * Returns y value
	 */
	public int getY() {
		return this.y;
	}
	
	/*
	 * Returns the value of the cell.
	 */
	public abstract Object getCellValue();

	/*
	 * Sets the value of the cell.
	 */
	public abstract void setCellValue(Object value);

}
