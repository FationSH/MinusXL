package minusXL_data_management;

public class MinFunction extends StatisticalFunction {

	/*
	 * Constructor for class AbsFunction
	 */
	public MinFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public Object calculateValue() {
		int newValue = Integer.parseInt((String) super.getValue());
		return newValue;
	}

}
