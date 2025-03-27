package com.example.game.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.game.model.GameRoom;
import com.example.game.service.GameRoomService;

@Controller
public class GameRoomController {

    private final GameRoomService gameRoomService;

    public GameRoomController(GameRoomService gameRoomService) {
        this.gameRoomService = gameRoomService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rooms", gameRoomService.getAllRooms());
        return "index";
    }

    @PostMapping("/create-room")
    public String createRoom() {
        String roomId = gameRoomService.createRoom();
        return "redirect:/room/" + roomId; 
    }

    @GetMapping("/room/{roomId}")
    public String room(@PathVariable String roomId, Model model) {
        GameRoom room = gameRoomService.getRoom(roomId);
        if (room != null) {
            model.addAttribute("room", room);
            return "room";
        }
        return "redirect:/"; 
    }
    
    @PostMapping("/join-room")
    public String jointRoom(@RequestParam String roomId) {
    	return "redirect:/room/" + roomId;
    }


}