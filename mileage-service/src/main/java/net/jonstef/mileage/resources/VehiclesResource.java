package net.jonstef.mileage.resources;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import net.jonstef.mileage.api.Vehicle;

import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehiclesResource {

	@GET
	public List<String> getVehicleList() {
		Vehicle[] vehicles = Vehicle.values();
		return Lists.transform(Arrays.asList(vehicles), new Function<Vehicle, String>() {
			@Nullable
			@Override
			public String apply(@Nullable Vehicle vehicle) {
				return vehicle.name();
			}
		});
	}
}
