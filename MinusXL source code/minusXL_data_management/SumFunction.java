package minusXL_data_management;

public class SumFunction extends MathFunction {


	/*
	 * Constructor for class SumFunction
	 */
	public SumFunction(Object value) {
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
