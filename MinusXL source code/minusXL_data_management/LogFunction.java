package minusXL_data_management;

import static java.lang.Math.log;

public class LogFunction extends MathFunction {

	/*
	 * Constructor for class LogFunction
	 */
	public LogFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		if (newValue > 0) {
			return log(newValue);
		}
		return "Log expects positive numbers";
	}

}
