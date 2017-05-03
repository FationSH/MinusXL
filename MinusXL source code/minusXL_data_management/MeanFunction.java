package minusXL_data_management;

public class MeanFunction extends StatisticalFunction {

	/*
	 * Constructor for class MeanFunction
	 */
	public MeanFunction(Object value) {
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
