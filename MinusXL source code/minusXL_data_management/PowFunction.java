package minusXL_data_management;

public class PowFunction extends MathFunction {

	/*
	 * Constructor for class PowFunction
	 */
	public PowFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		return newValue*newValue;
	}

}
