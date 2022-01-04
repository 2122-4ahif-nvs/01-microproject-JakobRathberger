package at.htl.boundary;

import at.htl.Control.OptionRepository;
import at.htl.entity.Option;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/option")
public class OptionResource {

    @Inject
    OptionRepository optionRepository;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        Option option = optionRepository.findById(Long.valueOf(id));
        return Response.ok(
                option
        ).build();
    }
}
