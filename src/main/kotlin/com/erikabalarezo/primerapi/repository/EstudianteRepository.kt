package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface EstudianteRepository: JpaRepository <Estudiante, Long>{
    fun findById (id:Long?): Estudiante?

    @Query(nativeQuery = true)
    fun getListEdad (@Param("edad") edad:Long?) : List <Estudiante>?

    @Query(nativeQuery = true)
    fun getListCedula (@Param("cedula") cedula:Long?) : List <Estudiante>?

    @Query(nativeQuery = true)
    fun getListDiscapacidad (@Param("discapacidad") discapacidad:String?) : List <Estudiante>?

    @Query(nativeQuery = true)
    fun getListCurso (@Param("curso") curso:String?) : List <Estudiante>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherDiscapacidad (@Param("discapacidad") discapacidad: String?, @Param("nuevaDiscapacidad") nuevaDiscapacidad: String?): Int?

}