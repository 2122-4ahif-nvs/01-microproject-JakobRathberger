package at.htl.Control;

import at.htl.entity.Poll;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PollRepository implements PanacheRepository<Poll> {

    @Inject
    EntityManager em;

}
