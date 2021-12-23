package at.htl.Control;

import at.htl.entity.Option;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OptionRepository implements PanacheRepository<Option> {

}
