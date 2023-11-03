package com.ray.relationalDB

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.ray.relationalDB"])
class RelationalDbApplication

fun main(args: Array<String>) {
	runApplication<RelationalDbApplication>(*args)
}
