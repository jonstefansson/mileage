package net.jonstef.mileage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 */
public class MileageConfiguration extends Configuration {

	@NotEmpty
	@JsonProperty
	private String defaultName = "mileage";

	@Valid
	@NotNull
	@JsonProperty("database")
	private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

	public String getDefaultName() {
		return defaultName;
	}

	public DatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

}
