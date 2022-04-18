package at.htl.boundary;

import at.htl.Control.PollRepository;
import at.htl.entity.Poll;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
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
