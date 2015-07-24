package com.javierseixas.catan.domain.match;

import java.util.List;
import java.util.UUID;

public interface MatchRepository {

    public Match create(UUID id, String name);

    public List<Match> findActiveMatches();
}
