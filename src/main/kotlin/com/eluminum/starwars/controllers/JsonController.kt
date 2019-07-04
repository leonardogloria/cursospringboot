package com.eluminum.starwars.controllers

import com.eluminum.starwars.model.ComplexObject
import com.eluminum.starwars.model.Empresa
import com.eluminum.starwars.model.SimpleObject
import com.eluminum.starwars.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonController {
    @GetMapping(value = "/json1/")
    fun getJson() = SimpleObject("Hi","Chinatown")
    @GetMapping(value = "/complex/")
    fun getComplex() = ComplexObject("Maldivas", SimpleObject())

    @GetMapping(value = "/empresas/")
    fun getEmpresa() = Empresa("12312323",
            listOf(Telefone("21","5551314"),
                    Telefone("21","5551747"))
           )
    @GetMapping(value = "/empresas2/")
    fun getEmpresa2() = Empresa("12312323")



}