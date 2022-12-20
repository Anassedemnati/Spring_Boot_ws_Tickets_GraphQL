package ma.emsi.matchtickets.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.matchtickets.dto.TicketRequestDto;
import ma.emsi.matchtickets.entities.Match;
import ma.emsi.matchtickets.entities.Ticket;
import ma.emsi.matchtickets.repository.MatchRepository;
import ma.emsi.matchtickets.repository.TicketRepository;
import ma.emsi.matchtickets.shared.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class TicketService implements ITicketService {
    private TicketRepository ticketRepository;
    private MatchRepository matchRepository;


    @Override
    public Ticket addTicket(TicketRequestDto ticketRequest) {
       Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);
        Integer totalticketByMatch  = ticketRepository.countTicketByMatch_Id(match.getId());
        if( totalticketByMatch > 10) {
            throw new RuntimeException("Ticket are not available !");
        }
        Random random = new Random();
        Ticket ticket = new Ticket();
        ticket.setId(random.nextLong());
        ticket.setAchete(false);
        ticket.setReference(Helper.generateStringId(16));
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(true);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s not found",id))
        );
    }

    @Override
    public Ticket updateTicket(Long id, TicketRequestDto ticketRequest) {
        Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s Not founf",id))
        );


        ticket.setId(id);
        ticket.setAchete(ticketRequest.achete());
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(ticketRequest.statut());
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}