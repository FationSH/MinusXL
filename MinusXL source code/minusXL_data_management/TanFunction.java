package minusXL_data_management;

import static java.lang.Math.tan;

public class TanFunction extends MathFunction {

	/*
	 * Constructor for class TanFunction
	 */
	public TanFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		if (newValue >= 0 && newValue <= 360) {
			return tan(newValue);
		}
		return "Expected 0-360 input";
	}

}
