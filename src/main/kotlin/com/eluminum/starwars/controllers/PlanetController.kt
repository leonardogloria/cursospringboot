package com.eluminum.starwars.controllers

import com.eluminum.starwars.model.Planet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class PlanetController {
    @Autowired
    lateinit var planets: ConcurrentHashMap<Int,Planet>

    @GetMapping(value="/planets/{id}")
    fun getPlanet(@PathVariable id: Int) = planets[id]

    @GetMapping(value="/planets")
    fun filterByName(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            planets.filter {
                it.value.name.contains(nameFilter, ignoreCase = true) }
                    .map(Map.Entry<Int,Planet>::value).toList()


    @PostMapping(value = "/planets")
    fun createPlanet(@RequestBody planet: Planet){
        planets[planet.id] = planet
    }

    @DeleteMapping(value= "/planets/{id}")
    fun deletePlanet(@PathVariable id: Int){
        planets.remove(id)
    }
    @PutMapping(value = "/planets/{id}")
    fun updatePlanet(@PathVariable id: Int, @RequestBody planet: Planet){
        planets.remove(id)
        planets[planet.id] = planet
    }





}