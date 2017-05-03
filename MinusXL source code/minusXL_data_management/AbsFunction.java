package minusXL_data_management;

import static java.lang.Math.*;

public class AbsFunction extends MathFunction {

	/*
	 * Constructor for class AbsFunction
	 */
	public AbsFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		newValue = abs(newValue);
		return newValue;
	}

}
