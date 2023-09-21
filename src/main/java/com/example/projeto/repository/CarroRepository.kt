package com.example.projeto.repository

import com.example.projeto.model.Carro
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.MongoRepository

@Repository
interface CarroRepository: MongoRepository<Carro, String>