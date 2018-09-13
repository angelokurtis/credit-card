package com.sensedia.domain.creditcard.repository

import com.sensedia.domain.creditcard.CreditCard
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CreditCardRepository : ReactiveCrudRepository<CreditCard, String>
