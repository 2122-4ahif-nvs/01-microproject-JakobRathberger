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
    @Transactional
    void createPoll(){
        Poll poll1 = new Poll("Poll1" , "desc1");
        Poll poll2 = new Poll("Poll2" , "desc2");
        Poll p1 = em.merge(poll1);
        Poll p2 = em.merge(poll2);
        assertThat(p1.getName()).isEqualTo(poll1.getName());
        assertThat(p2.getName()).isEqualTo(poll2.getName());
    }
}