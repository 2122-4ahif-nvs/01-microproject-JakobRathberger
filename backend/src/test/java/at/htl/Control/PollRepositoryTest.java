package at.htl.Control;

import at.htl.entity.Poll;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PollRepositoryTest {

    @Inject
    PollRepository pollRepository;

    @Test
    void createPoll(){
        Poll poll1 = new Poll("Poll1" , "desc1");
        Poll poll2 = new Poll("Poll2" , "desc2");
        Poll p1 = pollRepository.save(poll1);
        Poll p2 = pollRepository.save(poll2);
        assertThat(p1.getName()).isEqualTo(poll1.getName());
        assertThat(p2.getName()).isEqualTo(poll2.getName());
    }

}