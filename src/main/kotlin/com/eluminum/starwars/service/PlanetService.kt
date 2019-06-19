package com.eluminum.starwars.service

import com.eluminum.starwars.model.Planet

interface PlanetService {
    fun getById(id: Int) : Planet?
    fun create(planet:Planet)
    fun delete(id:Int)
    fun update(id: Int, planet: Planet)
    fun search(nameFilter:String): List<Planet>

}