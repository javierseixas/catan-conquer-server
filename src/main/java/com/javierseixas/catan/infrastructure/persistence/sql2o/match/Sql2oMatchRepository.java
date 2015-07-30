package com.javierseixas.catan.infrastructure.persistence.sql2o.match;

import com.javierseixas.catan.domain.match.*;
import com.javierseixas.catan.domain.match.Match;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;

public class Sql2oMatchRepository implements MatchRepository {

    private Sql2o sql2o;

    public Sql2oMatchRepository(Sql2o sql2o) {
        this.sql2o = sql2o;

    }

    @Override
    public Match create(UUID id, String name) {
        try (Connection conn = sql2o.beginTransaction()) {
            id = UUID.randomUUID();
            conn.createQuery("insert into matches(id, name) VALUES (:id, :name)")
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .executeUpdate();
            conn.commit();

            return new Match(id, name);
        }
    }

    @Override
    public List<Match> findActiveMatches() {
        try (Connection conn = sql2o.open()) {
            List<Match> matches = conn.createQuery("select * from matches")
                    .executeAndFetch(Match.class);
            return matches;
        }
    }
}
