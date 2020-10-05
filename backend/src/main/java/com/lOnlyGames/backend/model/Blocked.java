package com.lOnlyGames.backend.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Blocked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User blocker;

    @ManyToOne
    private User blockee;

    public Integer getId() {
        return id;
    }

    public User getBlocker() {
        return blocker;
    }

    public User getBlockee() {
        return blockee;
    }
}