package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.model.Deporte
import com.erikabalarezo.primerapi.model.DeporteView
import com.erikabalarezo.primerapi.repository.DeporteRepository
import com.erikabalarezo.primerapi.repository.DeporteViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DeporteService {

    @Autowired
    lateinit var deporteRepository: DeporteRepository

    @Autowired
    lateinit var deporteViewRepository: DeporteViewRepository

    fun save(deporte: Deporte): Deporte {
        try {
            deporte.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("El nombre no debe ser vacio")

            deporte.cancha?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("La cancha no debe ser vacia")

            return deporteRepository.save(deporte)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun list ():List<Deporte>{
        return deporteRepository.findAll()
    }

    fun getByNombre (nombre: String?):List<Deporte>?{
        return deporteRepository.getListNombre(nombre)
    }

    fun getByHora (hora: String):List<Deporte>?{
        return deporteRepository.getListHora(hora)
    }

    fun getByCancha (cancha: String?):List<Deporte>?{
        return deporteRepository.getListCancha(cancha)
    }

    fun getFrecuenciaHora(): List<DeporteView>{
        return deporteViewRepository.findAll()
    }
}