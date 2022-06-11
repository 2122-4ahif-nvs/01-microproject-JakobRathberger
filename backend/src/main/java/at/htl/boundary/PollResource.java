package at.htl.boundary;

import at.htl.Control.PollRepository;
import at.htl.dto.PollCreateDTO;
import at.htl.entity.Poll;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/poll")
public class PollResource {

    @Inject
    PollRepository pollRepository;

    @Path("/id/{id}")
    @GET
    @RolesAllowed({"admin","user"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        Poll poll = pollRepository.findById(Long.valueOf(id));
        return Response.ok(
                poll
        ).build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @RolesAllowed({"admin"})
    @Transactional
    public Response createPoll(PollCreateDTO poll){
        Poll p = new Poll(poll.name, poll.description);
        pollRepository.persist(p);
        return Response.created(URI.create("/poll/id/" + p.getId())).build();
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance poll(Poll poll);
    }

    @GET
    @Path("/page/id/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getPollPage(@PathParam("id") long id){
        return Templates.poll(pollRepository.findById(id));
    }
}
