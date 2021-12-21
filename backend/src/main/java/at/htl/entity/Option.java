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

}
