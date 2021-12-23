package at.htl.Control;

import at.htl.entity.Option;
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
import javax.transaction.UserTransaction;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OptionRepositoryTest {

    @Inject
    UserTransaction tx;

    @Inject
    OptionRepository optionRepository;

    @Inject
    AgroalDataSource ds;

    @Test
    @Order(1000)
    void createOption() throws Exception {
        Table optionTable = new Table(ds, "Option");

        tx.begin();
        Poll poll1 = new Poll("Poll11", "desc11");
        LocalDateTime d1 = LocalDateTime.of(2022, Month.JANUARY, 30,  12, 0);
        LocalDateTime d2 = LocalDateTime.of(2022, Month.JANUARY, 30,  14, 0);
        LocalDateTime d3 = LocalDateTime.of(2022, Month.APRIL, 1,  10, 15);
        LocalDateTime d4 = LocalDateTime.of(2022, Month.APRIL, 1,  20, 30);
        Option option1 = new Option(poll1, d1, d2);
        Option option2 = new Option(poll1, d3, d4);
        optionRepository.persist(option1);
        optionRepository.persist(option2);
        tx.commit();

        optionTable = new Table(ds, "Option");
        assertThat(optionTable)
                .hasNumberOfRows(2)
                .row(0)
                .column("startTime").value().isEqualTo(d1)
                .column("endTime").value().isEqualTo(d2)
                .row(1)
                .column("startTime").value().isEqualTo(d3)
                .column("endTime").value().isEqualTo(d4);
    }
}