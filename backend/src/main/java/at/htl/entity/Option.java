package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Poll poll;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Option() {
    }

    public Option(Poll poll, LocalDateTime startTime, LocalDateTime endTime) {
        this.poll = poll;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime from) {
        this.startTime = from;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime to) {
        this.endTime = to;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", poll=" + poll +
                ", from=" + startTime +
                ", to=" + endTime +
                '}';
    }
}
