package minusXL_data_management;

public class RemoveFunction extends StringFunction {

	/*
	 * Constructor for class RemoveFunction
	 */
	public RemoveFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		String newValue = (String) super.getValue();
		return newValue;
	}

}
