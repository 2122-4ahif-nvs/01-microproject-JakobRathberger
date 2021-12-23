package at.htl.Control;

import at.htl.entity.Person;
import at.htl.entity.Poll;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    UserTransaction tx;

    @Inject
    PersonRepository personRepository;

    @Inject
    AgroalDataSource ds;

    @Test
    void persistPerson() throws Exception {
        Table pollTable = new Table(ds, "Person");

        tx.begin();
        Person person1 = new Person("p1");
        Person person2 = new Person("p2");
        personRepository.persist(person1);
        personRepository.persist(person2);
        tx.commit();

        pollTable = new Table(ds, "Person");
        assertThat(pollTable)
                .hasNumberOfRows(2)
                .row(0)
                .column("Name").value().isEqualTo("p1")
                .row(1)
                .column("Name").value().isEqualTo("p2");
    }
}