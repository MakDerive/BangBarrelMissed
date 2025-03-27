package com.example.game.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameRoom {
    private String id;
    private Player admin;
    private Set<Player> players = new HashSet<>();

    public GameRoom(String id) {
        this.id = id;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    @JsonProperty("adminId")
    public String getAdminId() {
        return admin != null ? admin.getId() : null;
    }
    
    

    
}