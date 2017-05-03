package minusXL_data_management;

public class StddevFunction extends StatisticalFunction {

	/*
	 * Constructor for class StddevFunction
	 */
	public StddevFunction(Object value) {
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
