package com.sensedia.domain.cashback.service

import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class CashbackListener {

  @KafkaListener(topics = ["\${cashback.topic}"])
  fun receive(message: String) {
    log.info("received data='{}'", message)
  }

  companion object {
    private val log = LogManager.getLogger(CashbackListener::class.java)
  }
}
