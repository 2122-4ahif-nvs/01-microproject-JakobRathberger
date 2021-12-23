package at.htl.Control;

import at.htl.entity.Vote;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class VoteRepository implements PanacheRepository<Vote> {

}
