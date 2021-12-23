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

import static org.assertj.db.api.Assertions.assertThat;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PollRepositoryTest {

    @Inject
    PollRepository pollRepository;

    @Inject
    UserTransaction tx;

    @Inject
    AgroalDataSource ds;

    @Order(1000)
    @Test
    void persistPool() throws Exception {
        Table pollTable = new Table(ds, "Poll");

        tx.begin();
        Poll poll1 = new Poll("Poll1" , "desc1");
        Poll poll2 = new Poll("Poll2" , "desc2");
        pollRepository.persist(poll1);
        pollRepository.persist(poll2);
        tx.commit();

        pollTable = new Table(ds, "Poll");
        assertThat(pollTable)
                .hasNumberOfRows(2)
                .row(0)
                .column("Name").value().isEqualTo("Poll1")
                .row(1)
                .column("Name").value().isEqualTo("Poll2");
    }


}