package minusXL_data_management;

public class IncludesFunction extends StringFunction {

	/*
	 * Constructor for class IncludesFunction
	 */
	public IncludesFunction(Object value) {
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
