package ma.emsi.matchtickets.services;

import ma.emsi.matchtickets.dto.TicketRequestDto;
import ma.emsi.matchtickets.entities.Ticket;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

public interface ITicketService {
    public Ticket addTicket(TicketRequestDto ticketRequestDto);
    public List<Ticket> getAllTickets();
    public Ticket getTicketById(Long id);
    public Ticket updateTicket( Long id, TicketRequestDto ticketRequest);
    public void deleteTicket(Long id);
}