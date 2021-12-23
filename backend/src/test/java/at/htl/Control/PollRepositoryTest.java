package at.htl.Control;

import at.htl.entity.Poll;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.transaction.*;
import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.db.output.Outputs.output;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PollRepositoryTest {

    @Inject
    PollRepository pollRepository;

    @Inject
    UserTransaction tx;

    @Order(1000)
    @Test
    void persistPoll() throws Exception {
        tx.begin();
        Poll poll1 = new Poll("Poll1" , "desc1");
        Poll poll2 = new Poll("Poll2" , "desc2");
        pollRepository.persist(poll1);
        pollRepository.persist(poll2);
        tx.commit();

        Poll p1 = pollRepository.findById(poll1.getId());
        Poll p2 = pollRepository.findById(poll2.getId());

        assertThat(p1.getName()).isEqualTo(poll1.getName());
        assertThat(p2.getName()).isEqualTo(poll2.getName());
    }


}