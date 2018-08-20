package com.sensedia.creditcard.domain.handler

import com.sensedia.creditcard.domain.CreditCard
import com.sensedia.creditcard.domain.repository.CreditCardRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class CreditCardHandler(private val repository: CreditCardRepository) {

    fun all(req: ServerRequest) = ServerResponse.ok().body(this.repository.findAll())

    fun create(req: ServerRequest) = ServerResponse.ok().body(req.bodyToMono<CreditCard>())

    fun findById(req: ServerRequest) =
            ServerResponse.ok().body(
                    Mono.just(req.pathVariable("creditCardId")).flatMap { repository.findById(it) })
}
