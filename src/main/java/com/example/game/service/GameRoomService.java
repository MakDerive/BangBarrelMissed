package com.example.game.service;

import com.example.game.model.GameRoom;
import com.example.game.model.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GameRoomService {
    private Map<String, GameRoom> rooms = new HashMap<>();
    private Random random = new Random();

    public String createRoom(String adminName) {
        String id = generateRoomId();
        Player admin = new Player(adminName, true);
        rooms.put(id, new GameRoom(id, admin)); 
        return id;
    }


    public GameRoom getRoom(String id) {
        return rooms.get(id);
    }

    
    public Map<String, GameRoom> getAllRooms() {
        return rooms;
    }

    public void joinRoom(String roomId, String playerName) {
        GameRoom room = rooms.get(roomId);
        if (room != null) {
            room.addPlayer(new Player(playerName, false)); 
        }
    }

    private String generateRoomId() {
        return String.format("%04x", random.nextInt(0xFFFF + 1));
    }
}
