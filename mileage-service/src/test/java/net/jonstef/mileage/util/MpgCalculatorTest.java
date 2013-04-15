package net.jonstef.mileage.util;

import com.google.common.collect.ImmutableList;
import net.jonstef.mileage.api.Fillup;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class MpgCalculatorTest {

	@Test
	public void calculateTest() {
		MpgCalculator mpgCalculator = new MpgCalculator();
		List<Fillup> fillupList = ImmutableList.of(
			new Fillup(null, 101200, new BigDecimal("12.99"), null, null),
			new Fillup(null, 100900, new BigDecimal("11.54"), null, null),
			new Fillup(null, 100600, new BigDecimal("12.75"), null, null),
			new Fillup(null, 100300, new BigDecimal("11.8"), null, null),
			new Fillup(null, 100000, new BigDecimal("12.4"), null, null)
		);
		mpgCalculator.calculate(fillupList.iterator());
		for (Fillup fillup : fillupList) {
			System.out.printf("%d - %s%n", fillup.getMileage(), fillup.getMpg());
		}
	}
}
