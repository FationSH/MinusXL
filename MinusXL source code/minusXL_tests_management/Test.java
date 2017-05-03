package minusXL_tests_management;

import minusXL_data_management.AbsFunction;
import minusXL_data_management.CosFunction;
import minusXL_data_management.Log10Function;
import minusXL_data_management.LogFunction;
import minusXL_data_management.NotFunction;
import minusXL_data_management.PowFunction;
import minusXL_data_management.SinFunction;
import minusXL_data_management.TanFunction;
import minusXL_data_management.TrimFunction;

public class Test {

	/*
	 * Constructor for class Test @Default.
	 */
	public Test() {
		
	}
	
	/*
	 * This method tests the application's functions.
	 */
	public void makeTests() {
		
		// math and trig functions test
		int tests[] = {-500, -10, 0, 10, 90, 360, 500};
		for (int i=0; i < tests.length; i++) {
			System.out.println("Test with: " + tests[i]);
			AbsFunction absFunction = new AbsFunction(tests[i]);
			absFunction.calculateValue();
			
			CosFunction cosFunction = new CosFunction(tests[i]);
			cosFunction.calculateValue();
			
			SinFunction sinFunction = new SinFunction(tests[i]);
			sinFunction.calculateValue();
			
			TanFunction tanFunction = new TanFunction(tests[i]);
			tanFunction.calculateValue();
			
			Log10Function log10Function = new Log10Function(tests[i]);
			log10Function.calculateValue();
			
			LogFunction logFunction = new LogFunction(tests[i]);
			logFunction.calculateValue();
			
			PowFunction powFunction = new PowFunction(tests[i]);
			powFunction.calculateValue();
		}
		
		// boolean functions test
		boolean booleanValue = false;
		NotFunction notFunction = new NotFunction(booleanValue);
		notFunction.calculateValue();
		
		// String functions test
		TrimFunction trimFunction = new TrimFunction("Testing from Test class");
		trimFunction.calculateValue();
	}

}
