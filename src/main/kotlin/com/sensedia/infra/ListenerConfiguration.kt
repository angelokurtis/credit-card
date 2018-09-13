package com.sensedia.infra

import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
@EnableKafka
class ListenerConfiguration {

  @Value("\${spring.kafka.bootstrap-servers}")
  private val bootstrapServers: String? = null
  @Value("\${cashback.topic}")
  private val groupId: String? = null

  @Bean
  fun consumerFactory(): ConsumerFactory<String, String> {
    val props = mapOf<String, Any?>(
        BOOTSTRAP_SERVERS_CONFIG to this.bootstrapServers,
        GROUP_ID_CONFIG to this.groupId,
        KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java)

    return DefaultKafkaConsumerFactory<String, String>(props)
  }

  @Bean
  fun kafkaListenerContainerFactory(consumerFactory: ConsumerFactory<String, String>): ConcurrentKafkaListenerContainerFactory<String, String> {
    val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
    factory.consumerFactory = consumerFactory
    return factory
  }

}
