package minusXL_data_management;

public class ConcatFunction extends StringFunction {

	/*
	 * Constructor for class ConcatFunction
	 */
	public ConcatFunction(Object value) {
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
