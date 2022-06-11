package at.htl.boundary;

import at.htl.Control.OptionRepository;
import at.htl.Control.PollRepository;
import at.htl.entity.Option;
import at.htl.entity.Poll;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("/option")
public class OptionResource {

    @Inject
    OptionRepository optionRepository;

    @Inject
    PollRepository pollRepository;

    @Path("/id/{id}")
    @GET
    @RolesAllowed({"admin", "user"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoll(@PathParam("id") String id) {
        Option option = optionRepository.findById(Long.valueOf(id));
        return Response.ok(
                option
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Option addOption(@QueryParam("poll_id") Long poll_id,
                            @QueryParam("start_time") String startTimeStr,
                            @QueryParam("end_time") String endTimeStr)
    {
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr);
        Poll p = pollRepository.findById(poll_id);
        Option o = new Option(p, startTime, endTime);
        optionRepository.persist(o);
        return o;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response deletePerson(@QueryParam("option_id") Long id){
        optionRepository.deleteById(id);
        return Response.status(200).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    public Option updatePerson(@QueryParam("poll_id") Long poll_id,
                               @QueryParam("start_time") String startTimeStr,
                               @QueryParam("end_time") String endTimeStr,
                               @QueryParam("option_id") Long id){
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr);
        Poll p = pollRepository.findById(poll_id);
        Option o = optionRepository.findById(id);
        o.setStartTime(startTime);
        o.setEndTime(endTime);
        o.setPoll(p);
        return o;
    }
}
