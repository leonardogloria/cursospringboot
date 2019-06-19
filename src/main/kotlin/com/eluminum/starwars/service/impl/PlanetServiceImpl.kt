package com.eluminum.starwars.service.impl

import com.eluminum.starwars.model.Planet
import com.eluminum.starwars.service.PlanetService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PlanetServiceImpl: PlanetService {
    companion object {
        val initialPlanets = arrayOf(
                Planet(1," Coruscan"),
                Planet(2,"Dagobah"))
    }

    val planets = ConcurrentHashMap<Int,Planet>(initialPlanets.associateBy(Planet::id))

    override fun getById(id: Int): Planet? = planets[id]

    override fun create(planet: Planet) {
        planets[planet.id] = planet
    }

    override fun delete(id: Int) {
       planets.remove(id)
    }

    override fun update(id: Int, planet: Planet) {
        delete(id)
        create(planet)
    }

    override fun search(nameFilter: String): List<Planet> {
        return planets.filter { it.value.name.contains(nameFilter,ignoreCase = true) }.map(Map.Entry<Int,Planet>::value).toList()
    }


}