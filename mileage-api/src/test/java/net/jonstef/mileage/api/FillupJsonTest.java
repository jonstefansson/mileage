package net.jonstef.mileage.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.yammer.dropwizard.json.ObjectMapperFactory;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

import static org.fest.assertions.api.Assertions.*;
import static com.yammer.dropwizard.testing.FixtureHelpers.*;

/**
 *
 */
public class FillupJsonTest {

	final ObjectMapper mapper;

	public FillupJsonTest() {
		ObjectMapperFactory factory = new ObjectMapperFactory();
		factory.setDateFormat(new ISO8601DateFormat());
		mapper = factory.build();
	}

	@Test
	public void testJSONSerialization() throws Exception {
		DateTime date = DateTime.parse("2013-04-07T21:51:21.260-07:00");
		Fillup fillup = new Fillup(1l, 100000, new BigDecimal("14.7"), date, Vehicle.ACURA.name());
		System.out.println(asJson(fillup));
		System.out.println(jsonFixture("fixtures/fillup.json"));
		assertThat(asJson(fillup)).isEqualTo(jsonFixture("fixtures/fillup.json"));
	}

	private String asJson(Object obj) throws Exception {
		return mapper.writeValueAsString(obj);
	}

	private String jsonFixture(String resource) throws Exception {
		return mapper.writeValueAsString(mapper.readValue(fixture(resource), JsonNode.class));
	}


}
