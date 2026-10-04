package com.Tic_Tac_Toe.Game.Contoller;


import com.Tic_Tac_Toe.Game.ObjectClasses.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicTacToeController {

    private final Game game;

    public TicTacToeController(Game game) {
        this.game = game;
    }

    @GetMapping("/")
    public String showGame(Model model) {
        model.addAttribute("game", game);
        return "index";
    }

    @PostMapping("/move")
    public String handleMove(@RequestParam("x") int x, @RequestParam("y") int y) {
        game.makeMove(x, y);
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String handleReset() {
        game.reset();
        return "redirect:/";
    }
}