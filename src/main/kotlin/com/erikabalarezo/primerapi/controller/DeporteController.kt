package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.model.Deporte
import com.erikabalarezo.primerapi.model.DeporteView
import com.erikabalarezo.primerapi.service.DeporteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping ("/deporte")

class DeporteController {

    @Autowired
    lateinit var deporteService: DeporteService

    @PostMapping
    fun save(@RequestBody deporte: Deporte): Deporte {
        return deporteService.save(deporte)
    }

    @GetMapping
    fun list(): List<Deporte>{
        return deporteService.list()
    }

    @GetMapping ("/nombre/{nombre}")
    fun listByNombre (@PathVariable("nombre") nombre: String):List<Deporte>? {
        return deporteService.getByNombre(nombre)
    }

    @GetMapping ("/hora/{hora}")
    fun listByHora (@PathVariable("hora") hora: String):List<Deporte>? {
        return deporteService.getByHora(hora)
    }

    @GetMapping ("/cancha/{cancha}")
    fun listByCancha (@PathVariable("cancha") cancha: String):List<Deporte>? {
        return deporteService.getByCancha(cancha)
    }

    @GetMapping ("frecuencia/hora")
    fun getFrecuenciaHora ():List<DeporteView>?{
        return deporteService.getFrecuenciaHora()
    }



}