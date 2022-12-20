package ma.emsi.matchtickets.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.matchtickets.dto.MatchRequestDto;
import ma.emsi.matchtickets.entities.Match;
import ma.emsi.matchtickets.repository.MatchRepository;
import ma.emsi.matchtickets.shared.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@Transactional
@AllArgsConstructor
public class MatchService implements IMatchService{
    private MatchRepository matchRepository;
    @Override
    public Match addMatch(MatchRequestDto matchRequest) {
        Random random = new Random();
        Match match = new Match();
        match.setId(random.nextLong());
        match.setLieu(matchRequest.lieu());
        match.setMatchDate(matchRequest.matchDate());
        match.setEquipe1(matchRequest.equipe1());
        match.setEquipe2(matchRequest.equipe2());

        match.setReference(Helper.generateStringId(16));
        return matchRepository.save(match);
    }
    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
        .orElseThrow(() ->
         new RuntimeException("Match not found")
         );
    }
}
