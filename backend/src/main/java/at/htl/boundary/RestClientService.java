package at.htl.boundary;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RegisterRestClient(configKey="rest-api")
public interface RestClientService {

    @GET
    @Path("200")
    Response get20ß();
}
