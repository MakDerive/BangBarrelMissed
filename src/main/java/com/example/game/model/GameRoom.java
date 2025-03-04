package com.example.game.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameRoom {
    private String id;
    private Player admin;
    private Set<Player> players = new HashSet<>();

    public GameRoom(String id,Player admin) {
        this.id = id;
        this.admin = admin;
        this.players.add(admin);
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    

    
}