package net.jonstef.mileage.util;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import net.jonstef.mileage.api.Fillup;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;

/**
 *
 */
public class MpgCalculator {

	public void calculate(Iterator<Fillup> fillups) {
		PeekingIterator<Fillup> peekingIterator = Iterators.peekingIterator(fillups);
		while (peekingIterator.hasNext()) {
			Fillup fillup = peekingIterator.next();
			if (peekingIterator.hasNext()) {
				Fillup fillup2 = peekingIterator.peek();
				fillup.setMpg(new BigDecimal(fillup.getMileage() - fillup2.getMileage()).divide(fillup.getQuantity(), MathContext.DECIMAL32));
			}
		}
	}
}
