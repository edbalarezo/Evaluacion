package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.dto.NuevaDiscapacidad
import com.erikabalarezo.primerapi.model.Estudiante
import com.erikabalarezo.primerapi.service.EstudianteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/estudiante")

class EstudianteController {
    @Autowired
    lateinit var estudianteService: EstudianteService

    @GetMapping
    fun list(): List<Estudiante>{
        return estudianteService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Estudiante? {
        return estudianteService.getById(id)
    }

    @GetMapping("/edad/{edad}")
    fun listByEdad (@PathVariable("edad") edad: Long):List<Estudiante>? {
        return estudianteService.getByEdad(edad)
    }

    @GetMapping("/cedula/{cedula}")
    fun listByCedula (@PathVariable("cedula") cedula: Long):List<Estudiante>? {
        return estudianteService.getByCedula(cedula)
    }

    @GetMapping("/discapacidad/{discapacidad}")
    fun listByDicapacidad (@PathVariable("discapacidad") discapacidad: String):List<Estudiante>? {
        return estudianteService.getByDiscapacidad(discapacidad)
    }

    @GetMapping("/curso/{curso}")
    fun listByCurso (@PathVariable("curso") curso: String):List<Estudiante>? {
        return estudianteService.getByCurso(curso)
    }

    @PostMapping
    fun save(@RequestBody estudiante: Estudiante): Estudiante {
        return estudianteService.save(estudiante)
    }

    @PostMapping ("/change/discapacidad")
    fun updateOtherDiscapacidad (@RequestBody nuevaDiscapacidad: NuevaDiscapacidad): String? {
        return estudianteService.updateOtherDiscapacidad (nuevaDiscapacidad)
    }

    @PutMapping
    fun update (@RequestBody estudiante: Estudiante): Estudiante {
        return estudianteService.update(estudiante)
    }

    @PatchMapping
    fun updateName(@RequestBody estudiante: Estudiante): Estudiante {
        return estudianteService.updateName(estudiante)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return estudianteService.delete(id)
    }
}