package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.model.Notas
import com.erikabalarezo.primerapi.service.NotasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping ("/notas")

class NotasController {
    @Autowired
    lateinit var notasService: NotasService

    @GetMapping
    fun list(): List<Notas> {
        return notasService.list()
    }

    @GetMapping ("/calificacion/{calificacion}")
    fun listByCalificacion (@PathVariable("calificacion") calificacion: Long):List<Notas>? {
        return notasService.getByCalificacion(calificacion)
    }

    @PostMapping
    fun save(@RequestBody notas: Notas): Notas {
        return notasService.save(notas)
    }

    @PutMapping
    fun update(@RequestBody notas: Notas): Notas {
        return notasService.update(notas)
    }

    @PatchMapping
    fun updateName(@RequestBody notas: Notas): Notas {
        return notasService.updateName(notas)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return notasService.delete(id)
    }
}
