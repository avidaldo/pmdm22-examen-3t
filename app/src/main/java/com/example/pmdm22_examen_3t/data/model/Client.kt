package com.example.pmdm22_examen_3t.data.model

data class Client(
    val username: String,
    val email: String,
    val password: String,
    val checked: Boolean = false, // (1)
)

fun getFakeClients() =
    List(5) { i -> Client("Cliente ${i + 1}", "usuario${i + 1}@iesteis.es", "cambiame") }