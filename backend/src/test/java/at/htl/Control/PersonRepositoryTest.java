package at.htl.Control;

import at.htl.entity.Person;
import at.htl.entity.Poll;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTest {

    @Inject
    UserTransaction tx;

    @Inject
    PersonRepository personRepository;

    @Test
    @Order(1000)
    void persistPerson() throws Exception {
        tx.begin();
        Person person1 = new Person("p1");
        Person person2 = new Person("p2");
        personRepository.persist(person1);
        personRepository.persist(person2);
        tx.commit();

        Person p1 = personRepository.findById(person1.getId());
        Person p2 = personRepository.findById(person2.getId());

        assertThat(p1.getName()).isEqualTo(person1.getName());
        assertThat(p2.getName()).isEqualTo(person2.getName());
    }
}