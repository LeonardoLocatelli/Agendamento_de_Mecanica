package com.example.projeto.repository

import com.example.projeto.model.Servico
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.MongoRepository

@Repository
interface ServicoRepository: MongoRepository<Servico, String> {


    override fun findAll(): List<Servico>
}