package com.sensedia.infra

import com.sensedia.domain.creditcard.handler.CreditCardHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RouterFunctions.route

@Configuration
@ComponentScan(basePackageClasses = [CreditCardHandler::class])
class RouteConfiguration {

    @Bean
    fun routes(handler: CreditCardHandler) = route(
                    GET("/api/v1/credit-card"),
                    HandlerFunction { handler.all(it) })
            .andRoute(
                    POST("/api/v1/credit-card"),
                    HandlerFunction { handler.create(it) })
            .andRoute(
                    GET("/api/v1/credit-card/{creditCardId}"),
                    HandlerFunction { handler.findById(it) })

}
