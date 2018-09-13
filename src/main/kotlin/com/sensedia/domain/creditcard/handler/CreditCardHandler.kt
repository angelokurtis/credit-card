package com.sensedia.domain.creditcard.handler

import com.sensedia.domain.creditcard.CreditCard
import com.sensedia.domain.creditcard.service.CreditCardService
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.util.UriComponentsBuilder.fromPath
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CreditCardHandler(private val service: CreditCardService) {

    fun all(request: ServerRequest): Mono<ServerResponse> {
        val cards = this.service.fetchAll()
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body<CreditCard, Flux<CreditCard>>(cards, CreditCard::class.java)
    }

    fun create(request: ServerRequest): Mono<ServerResponse> {
        val creditCard = request
                .bodyToMono(CreditCard::class.java)
                .flatMap<CreditCard> { this.service.create(it) }
        return creditCard
                .flatMap {
                    created(fromPath("/" + it.id).build().toUri())
                            .contentType(APPLICATION_JSON)
                            .syncBody(it)
                }
    }

    fun findById(request: ServerRequest): Mono<ServerResponse> {
        val creditCard = Mono
                .just(request.pathVariable("creditCardId"))
                .flatMap<CreditCard> { service.fetchById(it) }
        return creditCard
                .flatMap {
                    ServerResponse.ok()
                            .contentType(APPLICATION_JSON)
                            .body(creditCard, CreditCard::class.java)
                }
                .switchIfEmpty(notFound().build())
    }
}
