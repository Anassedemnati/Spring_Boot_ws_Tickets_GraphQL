package ma.emsi.matchtickets.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Match {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 16,name = "[reference]")
    private String reference;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false,name = "[matchDate]")
    private Date matchDate;
    @Column(nullable = false,name = "[lieu]")
    private String lieu;
    @Column(nullable = false,name = "[equipe1]")
    private String equipe1;
    @Column(nullable = false,name = "[equipe2]")
    private String equipe2;
    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets;

}
