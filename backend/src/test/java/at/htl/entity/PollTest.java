package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PollTest {

    @Inject
    EntityManager em;

    @Test
    void createPoll(){
        Poll poll1 = new Poll("Poll1" , "desc1");
        Poll poll2 = new Poll("Poll2" , "desc2");
        assertThat(poll1.getName()).isEqualTo("Poll1");
        assertThat(poll2.getName()).isEqualTo("Poll2");
    }
}