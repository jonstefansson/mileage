package net.jonstef.mileage.resources;

import net.jonstef.mileage.api.Fillup;
import net.jonstef.mileage.api.Vehicle;
import net.jonstef.mileage.jdbi.FillupDAO;
import net.jonstef.mileage.util.MpgCalculator;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 *
 */
@Path("/fillup")
@Produces(MediaType.APPLICATION_JSON)
public class FillupResource {

	private final FillupDAO fillupDAO;
	private final MpgCalculator mpgCalculator = new MpgCalculator();

	@Context
	private UriInfo context;

	public FillupResource(FillupDAO fillupDAO) {
		this.fillupDAO = fillupDAO;
	}

	@GET
	@Path("vehicle/{vehicle}")
	public List<Fillup> getFillups(@PathParam("vehicle") String vehicle, @QueryParam("limit") @DefaultValue("10") Integer limit) {
		Vehicle veh = Vehicle.valueOf(vehicle);
		List<Fillup> fillups = fillupDAO.getFillups(veh.name(), limit);
		mpgCalculator.calculate(fillups.iterator());
		return fillups;
	}

	@GET
	@Path("id/{id}")
	public Fillup getFillupById(@PathParam("id") Long id) {
		return fillupDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertFillup(Fillup fillup) {
		fillupDAO.insert(fillup);
		UriBuilder ub = context.getAbsolutePathBuilder();
		URI location = ub.path(fillup.getId().toString()).build();
		return Response.created(location).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteFillup(@PathParam("id") Long id) {
		fillupDAO.deleteById(id);
		return Response.noContent().build();
	}

}
