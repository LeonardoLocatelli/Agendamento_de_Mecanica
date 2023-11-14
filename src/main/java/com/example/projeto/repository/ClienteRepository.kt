package com.example.projeto.repository

import com.example.projeto.model.Cliente
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: MongoRepository<Cliente, String> {
}