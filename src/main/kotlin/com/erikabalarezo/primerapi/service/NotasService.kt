package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.model.Notas
import com.erikabalarezo.primerapi.repository.EstudianteRepository
import com.erikabalarezo.primerapi.repository.NotasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class NotasService {

    @Autowired
    lateinit var notasRepository: NotasRepository

    @Autowired
    lateinit var estudianteRepository: EstudianteRepository

    fun list ():List<Notas>{
        return notasRepository.findAll()
    }

    fun save(notas: Notas):Notas {
        try {
            estudianteRepository.findById(notas.estudianteId)
                    ?: throw Exception("El Id del estudiante no exite")

            return notasRepository.save(notas)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun getByCalificacion (calificacion: Long?):List<Notas>?{
        return notasRepository.getListCalificacion(calificacion)
    }

    fun update (notas: Notas):Notas {
        notasRepository.findById(notas.id) ?: throw Exception ()
        return notasRepository.save(notas)
    }

    fun updateName (nota: Notas): Notas {
        val response = notasRepository.findById(nota.id)
                ?: throw Exception ()

        response.apply {
            calificacion=nota.calificacion
        }

        return notasRepository.save(response)
    }

    fun delete (id:Long): Boolean {
        notasRepository.deleteById(id)
        return true
    }


}