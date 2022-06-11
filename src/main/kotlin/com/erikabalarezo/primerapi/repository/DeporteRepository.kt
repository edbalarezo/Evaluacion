package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.dto.Hora
import com.erikabalarezo.primerapi.model.Deporte
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DeporteRepository: JpaRepository <Deporte, Long> {
    fun findById (id:Long?): Deporte?

    @Query(nativeQuery = true)
    fun getListNombre (@Param("nombre")nombre:String?) : List <Deporte>?

    @Query(nativeQuery = true)
    fun getListHora (@Param("hora")hora:Int?) : List <Deporte>?

    @Query(nativeQuery = true)
    fun getListCancha (@Param("cancha")cancha:String?) : List <Deporte>?

    @Query(nativeQuery = true)
    fun getFrecuenciaHora (): List<Hora>

}