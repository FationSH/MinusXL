package minusXL_data_management;

import static java.lang.Math.log;

public class Log10Function extends MathFunction{
	
	/*
	 * Constructor for class Log10Function
	 */
	public Log10Function(Object value) {
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
		return "Log with base 10 expects positive numbers";
	}

}
