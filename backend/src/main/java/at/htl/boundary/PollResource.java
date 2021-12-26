package at.htl.boundary;

import at.htl.Control.PollRepository;
import at.htl.entity.Poll;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@GraphQLApi
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

    @Query("getSinglePoll")
    @Description("returns a single poll with the given id")
    public Poll getSinglePoll(@Name("pollId") long id){
        return pollRepository.findById(id);
    }
}
