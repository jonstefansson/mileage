package net.jonstef.mileage.service;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import net.jonstef.mileage.MileageConfiguration;
import net.jonstef.mileage.jdbi.DateTimeArgumentFactory;
import net.jonstef.mileage.jdbi.FillupDAO;
import net.jonstef.mileage.jdbi.FillupMapper;
import net.jonstef.mileage.resources.FillupResource;
import net.jonstef.mileage.resources.VehiclesResource;
import net.jonstef.mileage.util.MpgCalculator;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class MileageService extends Service<MileageConfiguration> {

	private final Logger logger = LoggerFactory.getLogger(MileageService.class);

	public static void main(String[] args) throws Exception {
		new MileageService().run(args);
	}

	@Override
	public void initialize(Bootstrap<MileageConfiguration> bootstrap) {
		logger.debug("initialize: bootstrap.name={}", bootstrap.getName());
		bootstrap.setName("mileage");
		bootstrap.getObjectMapperFactory().setDateFormat(new ISO8601DateFormat());
	}

	@Override
	public void run(MileageConfiguration configuration, Environment environment) throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI dbi = factory.build(environment, configuration.getDatabaseConfiguration(), "h2");
		dbi.registerArgumentFactory(new DateTimeArgumentFactory());
		dbi.registerMapper(new FillupMapper());
		final FillupDAO dao = dbi.onDemand(FillupDAO.class);
		environment.addResource(new FillupResource(dao, new MpgCalculator()));
		environment.addResource(new VehiclesResource());
	}

}
