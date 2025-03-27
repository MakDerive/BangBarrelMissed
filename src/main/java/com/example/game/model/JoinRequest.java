package com.example.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {
	private String roomId;
    private String playerId;
    private String playerName;
}
