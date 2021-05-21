package es.aeat.mio.big;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class Regular {

	public static void main(String[] args) {
		BigDecimal principal = new BigDecimal("12345.67");
		BigDecimal rate = new BigDecimal("0.0456");
		int compounds = 12;
		int years = 7;

		BigDecimal uno = BigDecimal.ONE.add(rate.divide(new BigDecimal(compounds)));

		int cal = compounds * years;
		BigDecimal dos = uno.pow(cal);
		
		BigDecimal amount = principal.multiply(dos ).setScale(2, RoundingMode.HALF_UP);

		assertTrue(amount.compareTo(new BigDecimal("16977.7")) == 0);

		DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance(new Locale("es", "ES"));
		formatter.applyPattern("#,##0.00");

		System.out.println("amount=" + formatter.format(amount));
		
		formatter = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
		formatter.applyPattern("#,##0.00");

		System.out.println("amount=" + formatter.format(amount));
		
	}

}
