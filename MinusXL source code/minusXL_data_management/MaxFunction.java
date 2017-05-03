package minusXL_data_management;

public class MaxFunction extends StatisticalFunction  {

	/*
	 * Constructor for class AbsFunction
	 */
	public MaxFunction(Object value) {
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
