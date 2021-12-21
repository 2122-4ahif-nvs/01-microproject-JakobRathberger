package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Poll poll;
    private LocalDateTime from;
    private LocalDateTime to;

    public Option() {
    }

    public Option(Poll poll, LocalDateTime from, LocalDateTime to) {
        this.poll = poll;
        this.from = from;
        this.to = to;
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

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", poll=" + poll +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
