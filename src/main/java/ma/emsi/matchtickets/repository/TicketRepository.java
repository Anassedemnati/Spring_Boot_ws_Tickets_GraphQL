package ma.emsi.matchtickets.repository;

import ma.emsi.matchtickets.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    public Integer countTicketByMatch_Id(Long Id);
}
