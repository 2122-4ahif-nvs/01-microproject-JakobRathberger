package at.htl.boundary;

import at.htl.Control.PollRepository;
import at.htl.entity.Poll;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/poll")
public class PollResource {

    @Inject
    PollRepository pollRepository;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        Poll poll = pollRepository.findById(Long.valueOf(id));
        return Response.ok(
                poll
        ).build();
    }
}
