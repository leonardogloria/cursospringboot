package com.eluminum.starwars

import com.eluminum.starwars.model.Planet
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class StarwarsApplication{


}

fun main(args: Array<String>) {
	runApplication<StarwarsApplication>(*args)
}
