package com.javierseixas.catan;

import com.google.gson.Gson;
import com.javierseixas.catan.domain.match.Match;
import com.javierseixas.catan.domain.match.MatchRepository;
import com.javierseixas.catan.infrastructure.postgres.PostgresConnection;
import com.javierseixas.catan.infrastructure.sql2o.match.Sql2oMatchRepository;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        Sql2o sql2o = new Sql2o("jdbc:postgresql://192.168.59.103:5432/postgres", "postgres", "pass");

        MatchRepository matchRepository = new Sql2oMatchRepository(sql2o);


        get("/hello", (req, res) -> "Hello World");


        get("/postgres", (req, res) -> {
            PostgresConnection postgresConnection = new PostgresConnection();
            String result = "";

            try{
                Connection conn = postgresConnection.connect();

                PreparedStatement st = conn.prepareStatement("SELECT * FROM cities");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    result = rs.getString(1);
                }
                rs.close();
                st.close();

            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return result + "end\n";
        });

        get("/matches", (req, res) -> {
            Gson gson = new Gson();
            List<Match> matches = matchRepository.findActiveMatches();

            String json = gson.toJson(matches);

            res.type("application/json;charset=utf-8");
            res.status(200);

            return json;

        });

        post("/matches", (req, res) -> {
            Gson gson = new Gson();

            Match match = gson.fromJson(req.body(), Match.class);

            Match matchSaved = matchRepository.create(UUID.randomUUID(), match.name());

            res.type("application/json;charset=utf-8");
            res.status(200);
            return "{ \"id\": \"" + matchSaved.id().toString() + "\" }";
        });
    }
}

