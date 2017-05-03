package minusXL_data_management;

import static java.lang.Math.cos;

public class CosFunction extends MathFunction {

	/*
	 * Constructor for class CosFunction
	 */
	public CosFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		if (newValue >= 0 && newValue <= 360) {
			return cos(newValue);
		}
		return "Expected 0-360 input";
	}

}
