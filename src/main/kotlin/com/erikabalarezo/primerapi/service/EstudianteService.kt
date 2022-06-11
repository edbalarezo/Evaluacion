package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.dto.NuevaDiscapacidad
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.model.Estudiante
import com.erikabalarezo.primerapi.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EstudianteService {

    @Autowired
    lateinit var estudianteRepository: EstudianteRepository

    fun list ():List<Estudiante>{
        return estudianteRepository.findAll()
    }

    fun getById (id: Long?): Estudiante?{
        return estudianteRepository.findById(id)
    }

    fun getByEdad (edad: Long?):List<Estudiante>?{
        return estudianteRepository.getListEdad(edad)
    }

    fun getByCedula (cedula: Long?):List<Estudiante>?{
        return estudianteRepository.getListCedula(cedula)
    }

    fun getByDiscapacidad (discapacidad: String?):List<Estudiante>?{
        return estudianteRepository.getListDiscapacidad(discapacidad)
    }

    fun getByCurso (curso: String?):List<Estudiante>?{
        return estudianteRepository.getListCurso(curso)
    }

    fun save(estudiante: Estudiante): Estudiante {
        try {
            estudiante.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre del estudiante no debe ser vacio")

            return estudianteRepository.save(estudiante)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun update (estudiante: Estudiante):Estudiante {
        estudianteRepository.findById(estudiante.id) ?: throw Exception ()
        return estudianteRepository.save(estudiante)
    }

    fun updateOtherDiscapacidad (nuevaDiscapacidad: NuevaDiscapacidad): String? {
        val rows = estudianteRepository.setOtherDiscapacidad(nuevaDiscapacidad.discapacidad, nuevaDiscapacidad.nuevaDiscapacidad)
        return "Se edito Discapacidad: " + rows
    }

    fun updateName(estudiante: Estudiante): Estudiante {
        val response = estudianteRepository.findById(estudiante.id)
                ?: throw Exception ()

        response.apply {
            nombre=estudiante.nombre
        }

        return estudianteRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        estudianteRepository.deleteById(id)
        return true
    }

}