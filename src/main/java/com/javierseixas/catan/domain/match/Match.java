package com.javierseixas.catan.domain.match;

import java.util.UUID;

public class Match {
    protected UUID id;
    protected String name;

    public Match(String name) {
        this.id = null;
        this.name = name;
    }

    public Match(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }


}
