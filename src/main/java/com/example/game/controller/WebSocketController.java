package com.example.game.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.game.model.GameRoom;
import com.example.game.service.GameRoomService;

@Controller
public class WebSocketController {

    @Autowired
    private GameRoomService gameRoomService;

    @MessageMapping("/refreshRooms")
    @SendTo("/topic/rooms")
    public Map<String, GameRoom> refreshRooms() {
        return gameRoomService.getAllRooms();
    }

    @MessageMapping("/refreshPlayers")
    @SendTo("/topic/room")
    public GameRoom refreshPlayers(String roomId) {
        return gameRoomService.getRoom(roomId);
    }
}
