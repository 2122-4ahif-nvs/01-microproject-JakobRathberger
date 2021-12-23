package at.htl.Control;

import at.htl.entity.Option;
import at.htl.entity.Person;
import at.htl.entity.Poll;
import at.htl.entity.Vote;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.UserTransaction;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VoteRepositoryTest {
    @Inject
    UserTransaction tx;

    @Inject
    VoteRepository voteRepository;

    @Test
    @Order(1000)
    void createVote() throws Exception{
        tx.begin();
        Poll poll1 = new Poll("Poll111", "desc111");
        LocalDateTime d1 = LocalDateTime.of(2022, Month.JANUARY, 30,  12, 0);
        LocalDateTime d2 = LocalDateTime.of(2022, Month.JANUARY, 30,  14, 0);
        LocalDateTime d3 = LocalDateTime.of(2022, Month.APRIL, 1,  10, 15);
        LocalDateTime d4 = LocalDateTime.of(2022, Month.APRIL, 1,  20, 30);
        Option option1 = new Option(poll1, d1, d2);
        Option option2 = new Option(poll1, d3, d4);
        Person person1 = new Person("Person11");
        Person person2 = new Person("Person22");

        Vote vote1 = new Vote(person1, option1);
        Vote vote2 = new Vote(person1, option2);
        Vote vote3 = new Vote(person2, option2);

        voteRepository.persist(vote1);
        voteRepository.persist(vote2);
        voteRepository.persist(vote3);
        tx.commit();

        Vote v1 = voteRepository.findById(vote1.getId());
        Vote v2 = voteRepository.findById(vote2.getId());
        Vote v3 = voteRepository.findById(vote3.getId());

        assertThat(v1.getOption().getId()).isEqualTo(option1.getId());
        assertThat(v2.getOption().getId()).isEqualTo(option2.getId());
        assertThat(v3.getOption().getId()).isEqualTo(option2.getId());

        assertThat(v1.getPerson().getName()).isEqualTo(person1.getName());
        assertThat(v2.getPerson().getName()).isEqualTo(person1.getName());
        assertThat(v3.getPerson().getName()).isEqualTo(person2.getName());

    }
}