package com.example.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	private String id;
	private String name;
	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}
}
