package com.example.CuponRequest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object CouponRequestApplication {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(CouponRequestApplication::class.java, *args)
    }
}