package es.aeat.mio.big;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ConBigDecimal {

	public static void main(String[] args) {
		// No usar esto
		BigDecimal x = new BigDecimal(0.1);
		System.out.println("x=" + x);  // Da lo siguiente 0.1000000000000000055511151231257827021181583404541015625
		// Usar String
		// the String constructor is perfectly predictable and produces a BigDecimal that is exactly equal to 0.1, as expected.
		
		BigDecimal y = new BigDecimal("0.1");
		System.out.println("y=" + y);
// ------------------------------------------------------------------		
		// You should use the String constructor in preference to the double constructor.
		
		//Using the static BigDecimal.valueOf(double) method to create a BigDecimal, be aware of its limited precision.
		// a double has a precision of only 15–17 digits (a float has a precision of only 6–9 digits), 
		// while a BigDecimal is of arbitrary precision (limited only by memory).
		BigDecimal xo = BigDecimal.valueOf(1.01234567890123456789);
		BigDecimal yo = new BigDecimal("1.01234567890123456789");
		System.out.println("xo=" + xo);   // 1.0123456789012346
		System.out.println("yo=" + yo);   // 1.01234567890123456789
		
		// The equals(bigDecimal) method
		BigDecimal x2 = new BigDecimal("1");
		BigDecimal y2 = new BigDecimal("1.0");
		System.out.println(x2.equals(y2));   // Da false , Compara valor y escala.
//	    x has an unscaled value of 1 and a scale of 0.
//	    y has an unscaled value of 10 and a scale of 1.
//	    Por lo que,  x is not equal to y.
//
//	     For this reason, two instances of BigDecimal shouldn’t be compared using the equals() method, 
//		but instead the compareTo() method should be used, because it compares the numerical values (x = 1; y = 1.0)
//		represented by the two instances of BigDecimal.
		// true
		System.out.println(x2.compareTo(y) == 0); // Compara únicamente valores numéricos
		
		
		// The round(mathContext) method
//		Some developers might be tempted to use the round(new MathContext(precision, roundingMode)) method 
//		to round a BigDecimal to (let’s say) two decimal places. That’s not a good idea.

		BigDecimal x3 = new BigDecimal("12345.6789");
		x3 = x3.round(new MathContext(2, RoundingMode.HALF_UP));
		System.out.println("x3=" + x3.toPlainString());
		System.out.println("scale=" + x3.scale());

		//The code above produces the following console output,
//		so x is not the expected value of 12345.68 and the scale is not the expected value of 2:
//
//		x=12000 
//		scale=-3
		
//		To get the expected result of 12345.68, try the setScale(scale, roundingMode) method, for example:

			BigDecimal x4 = new BigDecimal("12345.6789");
			x4 = x4.setScale(2, RoundingMode.HALF_UP);
			System.out.println("x4=" + x4);
						
			
	}

}
