package com.erikabalarezo.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "deporte_view")
class DeporteView {

    @Id
    @Column(updatable = false)
    var hora: String? = null
    var frecuencia: String? = null
}