package com.alexhedley.legodemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LegodemoApplication

fun main(args: Array<String>) {
	runApplication<LegodemoApplication>(*args)
}
