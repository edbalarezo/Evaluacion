package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.model.DeporteView
import org.springframework.data.jpa.repository.JpaRepository

interface DeporteViewRepository: JpaRepository<DeporteView, String> {
}