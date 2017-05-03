package minusXL_data_management;

public class OrFunction extends LogicalFunction {

	/*
	 * Constructor for class OrFunction
	 */
	public OrFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		boolean newValue = Boolean.valueOf((String) super.getValue());
		return newValue;
	}

}
