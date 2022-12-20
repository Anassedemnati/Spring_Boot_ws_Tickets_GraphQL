package ma.emsi.matchtickets.services;

import ma.emsi.matchtickets.dto.MatchRequestDto;
import ma.emsi.matchtickets.entities.Match;

import java.util.List;

public interface IMatchService {
    public Match addMatch(MatchRequestDto matchRequestDto);
    public List<Match> getAllMatches();
    public Match getMatchById(Long id);
}
