package net.jonstef.mileage.jdbi;

import net.jonstef.mileage.api.Fillup;
import net.jonstef.mileage.api.Vehicle;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class FillupMapper implements ResultSetMapper<Fillup> {

	@Override
	public Fillup map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		Fillup fillup = new Fillup(
				resultSet.getLong("id"),
				resultSet.getInt("mileage"),
				resultSet.getBigDecimal("quantity"),
				new DateTime(resultSet.getDate("date")),
				resultSet.getString("vehicle")
		);
		return fillup;
	}

}
