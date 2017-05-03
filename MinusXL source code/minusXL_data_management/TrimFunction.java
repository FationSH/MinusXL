package minusXL_data_management;

public class TrimFunction extends StringFunction {

	/*
	 * Constructor for class ConcatFunction
	 */
	public TrimFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		String newValue = (String) super.getValue();
		return newValue.replaceAll("\\s",""); // removes all whitespaces and non visible characters such as tab, \n
	}

}
