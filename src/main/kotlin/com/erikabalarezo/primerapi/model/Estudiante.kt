package com.erikabalarezo.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "estudiante")

class Estudiante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var nombre: String? = null
    var cedula: Long? = null
    var edad: Long? = null
    var telefono: Long? = null
    var discapacidad: String? = null
    var curso: String? = null

}