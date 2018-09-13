package com.sensedia.domain.creditcard.service

import com.sensedia.domain.creditcard.CreditCard
import com.sensedia.domain.creditcard.repository.CreditCardRepository
import org.springframework.stereotype.Service

@Service
class CreditCardService(private val repository: CreditCardRepository) {

  fun create(creditCard: CreditCard) = this.repository.save(creditCard)

  fun fetchAll() = this.repository.findAll()

  fun fetchById(id: String) = this.repository.findById(id)
}
