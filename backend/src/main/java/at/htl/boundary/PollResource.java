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
    EntityManager em;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        TypedQuery<Poll> query = em.createQuery("select p from Poll p where p.id = " + id, Poll.class);
        Poll poll = query.getSingleResult();

        return Response.ok(
                poll
        ).build();
    }
}
