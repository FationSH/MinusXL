package minusXL_data_management;

import static java.lang.Math.sin;

public class SinFunction extends MathFunction {

	/*
	 * Constructor for class SinFunction
	 */
	public SinFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		if (newValue >= 0 && newValue <= 360) {
			return sin(newValue);
		}
		return "Expected 0-360 input";
	}

}
