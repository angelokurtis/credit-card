package com.sensedia.creditcard.domain.service

import com.sensedia.creditcard.domain.CreditCard
import com.sensedia.creditcard.domain.repository.CreditCardRepository
import org.springframework.stereotype.Service

@Service
class CreditCardService(private val repository: CreditCardRepository) {

    fun create(creditCard: CreditCard) = this.repository.save(creditCard)

    fun fetchAll() = this.repository.findAll()

    fun fetchById(id: String) = this.repository.findById(id)
}
