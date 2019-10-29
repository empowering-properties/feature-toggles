package com.tibtof.empoweringproperties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RefreshScope
@Configuration
@ConfigurationProperties("message")
class Message {
    lateinit var greeting: String
}

@RestController
class ConfigurationPropertyController(val message: Message) {

    @GetMapping("/greeting")
    fun greet() = message.greeting

}
