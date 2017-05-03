package minusXL_data_management;

public abstract class StringFunction extends Function {

	/*
	 * Constructor for class StringFunction
	 */
	public StringFunction(Object value) {
		super(value);
	}

	/*
	 * @see minusXL_data_management.Function#calculateValue()
	 */
	public abstract Object calculateValue();

	/*
	 * This method checks if inputs are numbers to be used in math functions.
	 * @see minusXL_data_management.Function#checkValidity(java.lang.Object[])
	 */
	public boolean checkValidity(Object[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if (!(inputs[i] instanceof String)) {
				return false;
			}
		}
		return true;
	}

}
