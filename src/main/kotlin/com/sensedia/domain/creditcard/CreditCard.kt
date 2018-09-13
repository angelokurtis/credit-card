package com.sensedia.domain.creditcard

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cards")
class CreditCard(
        @Id val id: String?,
        val issuer: String,
        val number: String,
        val name: String,
        val address: String,
        val country: String,
        val exp: String)
