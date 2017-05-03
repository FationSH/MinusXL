package minusXL_data_management;

public class NotFunction extends LogicalFunction {

	/*
	 * Constructor for class NotFunction
	 */
	public NotFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		boolean newValue = Boolean.valueOf((String) super.getValue());
		return newValue ^= true;
	}

}
