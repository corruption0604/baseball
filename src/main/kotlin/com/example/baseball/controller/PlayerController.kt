package com.example.baseball.controller

import com.example.baseball.domain.Player
import com.example.baseball.service.PlayerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/players") // ①
class PlayerController(private val playerService: PlayerService) {
    @GetMapping
    // ②
    fun index(model: Model): String {
        // ③
        model.addAttribute("players", playerService.findAll())
        // ④
        return "players/index"
    }

    @GetMapping("new")
    fun newPlayer(): String {
        return "players/new"
    }

    @GetMapping("{id}/edit")
    // ⑤
    fun edit(@PathVariable id: Long, model: Model): String {
        model.addAttribute("player", playerService.findOne(id));
        return "players/edit"
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long, model: Model): String {
        model.addAttribute("player", playerService.findOne(id));
        return "players/show"
    }

    @PostMapping
    // ⑥
    fun create(@ModelAttribute player: Player): String {
        playerService.save(player)
        // ⑦
        return "redirect:/players"
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @ModelAttribute player: Player): String {
        playerService.save(player.copy(id = id))
        return "redirect:/players"
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable id: Long): String {
        playerService.delete(id)
        return "redirect:/players"
    }
}
