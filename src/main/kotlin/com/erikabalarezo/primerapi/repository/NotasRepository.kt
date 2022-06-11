package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.model.Notas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NotasRepository: JpaRepository <Notas, Long> {
    fun findById (id: Long?): Notas

    @Query(nativeQuery = true)
    fun getListCalificacion ( @Param("calificacion") calificacion:Long?) : List <Notas>?


}