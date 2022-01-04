package at.htl.boundary;

import at.htl.Control.VoteRepository;
import at.htl.entity.Vote;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vote")
public class VoteResource {

    @Inject
    VoteRepository voteRepository;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        Vote vote = voteRepository.findById(Long.valueOf(id));
        return Response.ok(
                vote
        ).build();
    }
}
