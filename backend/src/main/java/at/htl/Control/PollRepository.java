package at.htl.Control;

import at.htl.entity.Poll;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PollRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Poll save(Poll poll){
        return em.merge(poll);
    }
}
