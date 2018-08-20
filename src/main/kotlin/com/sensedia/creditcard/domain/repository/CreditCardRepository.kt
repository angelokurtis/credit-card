package com.sensedia.creditcard.domain.repository

import com.sensedia.creditcard.domain.CreditCard
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CreditCardRepository : ReactiveCrudRepository<CreditCard, String>
