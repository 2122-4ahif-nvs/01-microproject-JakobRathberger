package at.htl.boundary;

import at.htl.Control.PersonRepository;
import at.htl.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") String id) {
        Person person = personRepository.findById(Long.valueOf(id));
        return Response.ok(
                person
        ).build();
    }
}
