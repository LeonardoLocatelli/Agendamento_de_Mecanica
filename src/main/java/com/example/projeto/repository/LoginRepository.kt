package com.example.projeto.repository

import com.example.projeto.model.Login
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LoginRepository: MongoRepository<Login, String> {

    fun findDistinctByEmail(email: String):Login

    override fun deleteById(id: String)
}