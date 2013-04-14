package net.jonstef.mileage.jdbi;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 */
public class DateTimeArgumentFactory implements ArgumentFactory<DateTime> {

	private Logger logger = LoggerFactory.getLogger(DateTimeArgumentFactory.class);

	@Override
	public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
		if (value == null) {
			return false;
		}
		return DateTime.class.isAssignableFrom(value.getClass());
	}

	@Override
	public Argument build(Class<?> expectedType, final DateTime value, StatementContext ctx) {
		return new Argument() {
			@Override
			public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
				statement.setTimestamp(position, new Timestamp(value.getMillis()));
			}
		};
	}
}
