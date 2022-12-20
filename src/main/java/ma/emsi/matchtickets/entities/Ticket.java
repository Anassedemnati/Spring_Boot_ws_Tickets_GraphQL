package ma.emsi.matchtickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 16)
    private String reference;
    @Column(nullable = false)
    private Double prix;
    private Boolean statut =true;
    private Boolean achete=false;
    @ManyToOne
    private Match match;
}
