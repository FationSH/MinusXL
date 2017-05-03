package minusXL_data_management;

public class XorFunction extends LogicalFunction{

	/*
	 * Constructor for class XorFunction
	 */
	public XorFunction(Object value) {
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
