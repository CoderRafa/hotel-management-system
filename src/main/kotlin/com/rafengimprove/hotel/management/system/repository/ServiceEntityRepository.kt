package com.rafengimprove.hotel.management.system.repository

import com.rafengimprove.hotel.management.system.model.entity.ServiceEntity
import org.springframework.data.repository.CrudRepository

interface ServiceEntityRepository: CrudRepository<ServiceEntity, Long>