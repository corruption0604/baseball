package com.example.baseball

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller // ①
class HelloWorld {
    @GetMapping("/") // ②
    fun hello() = "hello" // ③
}