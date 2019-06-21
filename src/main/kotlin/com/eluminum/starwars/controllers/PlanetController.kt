package com.eluminum.starwars.controllers

import com.eluminum.starwars.model.Planet
import com.eluminum.starwars.service.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class PlanetController {
    @Autowired
    lateinit var planetService: PlanetService

    @GetMapping(value="/planets/{id}")
    fun getPlanet(@PathVariable id: Int) : ResponseEntity<Planet?>{
        val planet = planetService.getById(id)
        val status = if(planet == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(planet,status)
    }

    @GetMapping(value="/planets")
    fun filterByName(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            planetService.search(nameFilter)



    @PostMapping(value = "/planets")
    fun createPlanet(@RequestBody planet: Planet): ResponseEntity<Unit?>{
        planetService.create(planet)

        return ResponseEntity(null,null,HttpStatus.CREATED)
    }

    @DeleteMapping(value= "/planets/{id}")
    fun deletePlanet(@PathVariable id: Int): ResponseEntity<Unit>{
        var status = HttpStatus.NOT_FOUND
        if(planetService.getById(id) != null){
            planetService.delete(id)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit,status)
    }
    @PutMapping(value = "/planets/{id}")
    fun updatePlanet(@PathVariable id: Int, @RequestBody planet: Planet): ResponseEntity<Unit>{
        var status = HttpStatus.NOT_FOUND
        if(planetService.getById(id) != null){
            planetService.update(id,planet)
            status = HttpStatus.ACCEPTED

        }
        return ResponseEntity(Unit,status)

    }





}