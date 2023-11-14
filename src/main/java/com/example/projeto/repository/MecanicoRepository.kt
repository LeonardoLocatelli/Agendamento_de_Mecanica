package com.example.projeto.repository

import com.example.projeto.model.Mecanico
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MecanicoRepository: MongoRepository<Mecanico, String> {

    fun findAllByOcupado(ocupado: Boolean): List<Mecanico>
    fun findByNome(nome: String): Mecanico
    fun deleteByNome(nome: String)
}