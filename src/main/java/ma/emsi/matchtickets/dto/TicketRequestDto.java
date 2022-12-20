package ma.emsi.matchtickets.dto;

public record TicketRequestDto(
        Double prix,
        Boolean achete,
        Boolean statut,
        Long matchId
) {
}
