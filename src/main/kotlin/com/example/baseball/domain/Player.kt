package com.example.baseball.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity // ①
data class Player(
    @Id // ②
    @GeneratedValue // ③
    val id: Long? = null, // ④
    val name: String? = null, // ④
    val age: Int? = null, // ④
    val team: String? = null, // ④
    val position: String? = null // ④
)