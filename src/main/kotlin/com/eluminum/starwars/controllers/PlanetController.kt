package com.eluminum.starwars.controllers

import com.eluminum.starwars.model.Planet
import com.eluminum.starwars.service.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class PlanetController {
    @Autowired
    lateinit var planetService: PlanetService

    @GetMapping(value="/planets/{id}")
    fun getPlanet(@PathVariable id: Int) = planetService.getById(id)

    @GetMapping(value="/planets")
    fun filterByName(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            planetService.search(nameFilter)



    @PostMapping(value = "/planets")
    fun createPlanet(@RequestBody planet: Planet){
        planetService.create(planet)
    }

    @DeleteMapping(value= "/planets/{id}")
    fun deletePlanet(@PathVariable id: Int){
        planetService.delete(id)
    }
    @PutMapping(value = "/planets/{id}")
    fun updatePlanet(@PathVariable id: Int, @RequestBody planet: Planet){
        planetService.update(id,planet)

    }





}