package com.example.projeto.repository

import com.example.projeto.model.Servico
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ServicoRepository: MongoRepository<Servico, String> {
    override fun findAll(): List<Servico>

    override fun findById(id: String): Optional<Servico>
}