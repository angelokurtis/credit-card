package com.sensedia.creditcard.infra

import com.sensedia.creditcard.domain.handler.CreditCardHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
@ComponentScan(basePackageClasses = [CreditCardHandler::class])
class RouteConfiguration {

    @Bean
    fun routes(handler: CreditCardHandler): RouterFunction<ServerResponse> {
        return route(GET("/credit-card"), HandlerFunction<ServerResponse> { handler.all(it) }).andNest(path("/"),
                route(
                        POST("/"),
                        HandlerFunction<ServerResponse> { handler.create(it) }))
                .andRoute(
                        GET("/{creditCardId}"),
                        HandlerFunction<ServerResponse> { handler.findById(it) })
    }

}
