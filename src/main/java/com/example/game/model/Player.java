package com.example.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
	private String name;
	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}
}
