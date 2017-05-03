package minusXL_data_management;

public class AndFunction extends LogicalFunction {

	/*
	 * Constructor for class AndFunction
	 */
	public AndFunction(Object value) {
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
