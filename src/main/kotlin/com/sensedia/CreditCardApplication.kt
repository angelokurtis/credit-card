package com.sensedia

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class CreditCardApplication

fun main(args: Array<String>) {
  runApplication<CreditCardApplication>(*args)
}