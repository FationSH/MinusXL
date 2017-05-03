package minusXL_data_management;

public abstract class MathFunction extends Function {

	/*
	 * Constructor for class MathFunction
	 */
	public MathFunction(Object value) {
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
			try {
				Integer.parseInt((String) inputs[i]);
		    } catch (Exception e) {
		    	return false;
		    }
		}
		return true;
	}

}
