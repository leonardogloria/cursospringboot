package com.eluminum.starwars.model


import com.fasterxml.jackson.annotation.*
import java.util.*

/*
class SimpleObject {
    public val name = "Hello"
    private val zone = "World"
    public fun getPlace() = zone
}
*/
data class SimpleObject(var name:String = "Hello", var place:String =  "World" )
data class ComplexObject(var location:String = "Rome", var simple:SimpleObject? = null)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Empresa(var cnpj: String, @JsonProperty(value = "telefones")
var telefone:List<Telefone>? = null, @JsonIgnore var inadimplente:Boolean = false,
                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy" ) var dataAbertura: Date = Date() )
data class Telefone(var ddd:String, var numero:String)
