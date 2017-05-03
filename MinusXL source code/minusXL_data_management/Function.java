package minusXL_data_management;

public abstract class Function {

	private Object value;

	/*
	 * Constructor for class Function.
	 */
	public Function(Object value) {
		this.value = value;
	}

	/*
	 * Returns the value variable.
	 */
	public Object getValue() {
		return this.value;
	}

	/*
	 * Sets the value variable.
	 */
	public void setValue(Object other) {
		this.value = other;
	}

	/*
	 * Returns the value of the function.
	 */
	public abstract Object calculateValue();

	/*
	 * Checks the validity of the function inputs.
	 */
	public abstract boolean checkValidity(Object[] inputs);

}
