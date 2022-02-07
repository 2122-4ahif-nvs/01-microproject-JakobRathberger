package at.htl;

import at.htl.boundary.RestClientService;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    @RestClient
    RestClientService restClientService;

    public void init(@Observes StartupEvent startup){
        var r = restClientService.get20ß();
        System.out.println("Resp Status Code: " + r.getStatus());
        System.out.println("Resp Media Type: " + r.getMediaType());
    }
}
