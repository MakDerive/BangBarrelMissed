package com.example.game.service;

import com.example.game.model.GameRoom;
import com.example.game.model.JoinRequest;
import com.example.game.model.Player;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameRoomService {
    private Map<String, GameRoom> rooms = new HashMap<>();
    private Random random = new Random();

    public String createRoom() {
        String id = generateRoomId();
        rooms.put(id, new GameRoom(id)); 
        return id;
    }


    public GameRoom getRoom(String id) {
        return rooms.get(id);
    }

    
    public Map<String, GameRoom> getAllRooms() {
        return rooms;
    }

    public GameRoom joinRoom(JoinRequest request) {
    	String roomId = request.getRoomId();
        String playerId = request.getPlayerId();
        String playerName = request.getPlayerName();
        GameRoom room = rooms.get(roomId);
        boolean playerExists = room.getPlayers().stream()
                .anyMatch(p -> p.getId().equals(request.getPlayerId()));
        if (room != null && !playerExists) {
        	boolean isAdmin = room.getPlayers().isEmpty();
            Player player = new Player(playerId, playerName, isAdmin);
            
            room.addPlayer(player);
            if (isAdmin) {
                room.setAdmin(player);
                System.out.println("Назначен админ: " + playerName);
            }
        }
        return room;
    }

    private String generateRoomId() {
        return String.format("%04x", random.nextInt(0xFFFF + 1));
    }
}
