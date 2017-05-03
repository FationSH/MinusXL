package minusXL_data_management;

public class FunctionCell extends Cell {

	private Object value;
	private String functionToUse;
	private Function theFunction; // one FunctionCell has one Function

	/*
	 * Constructor for class FunctionCell.
	 */
	public FunctionCell(int x, int y, Object value, String functionToUse) {
		super(x, y, value);
		this.functionToUse = functionToUse;
	}

	/*
	 * Sets the current function.
	 */
	public void setFunction(String other) {
		this.functionToUse = other;
	}

	/*
	 * @see minusXL_data_management.Cell#getCellValue()
	 */
	public Object getCellValue() {
		return this.value;
	}

	/*
	 * @see minusXL_data_management.Cell#setCellValue()
	 */
	public void setCellValue(Object other) {
		if (this.functionToUse.equals("ABS")) { // math-trig functions
			this.theFunction = new AbsFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("COS")) {
			this.theFunction = new CosFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("SIN")) {
			this.theFunction = new SinFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("TAN")) {
			this.theFunction = new TanFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("POW")) {
			this.theFunction = new PowFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("SUM")) {
			this.theFunction = new SumFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("MULT")) {
			this.theFunction = new MultFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("LOG")) {
			this.theFunction = new LogFunction(other);
			this.value = theFunction.calculateValue();
		}  else if (this.functionToUse.equals("LOG10")) {
			this.theFunction = new Log10Function(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("AND")) { // logical Functions
			
		} else if (this.functionToUse.equals("OR")) {
			
		} else if (this.functionToUse.equals("NOT")) {
			this.theFunction = new NotFunction(other);
			this.value = theFunction.calculateValue();
		} else if (this.functionToUse.equals("XOR")) {
			
		} else if (this.functionToUse.equals("MAX")) { // statistical functions
			
		} else if (this.functionToUse.equals("MIN")) {
					
		} else if (this.functionToUse.equals("MEAN")) {
		
		} else if (this.functionToUse.equals("MEDIAN")) {
			
		} else if (this.functionToUse.equals("STDDEV")) {
			
		} else if (this.functionToUse.equals("CONCAT")) { // string functions
			
		} else if (this.functionToUse.equals("INCLUDES")) {
			
		} else if (this.functionToUse.equals("REMOVE")) {
			
		} else if (this.functionToUse.equals("TRIM")) {
			this.theFunction = new TrimFunction(other);
			this.value = theFunction.calculateValue();
		}
	}

}
