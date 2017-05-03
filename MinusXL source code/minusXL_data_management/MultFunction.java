package minusXL_data_management;

public class MultFunction extends MathFunction {

	/*
	 * Constructor for class MultFunction
	 */
	public MultFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt(super.getValue() + "");
		return newValue;
	}

}
