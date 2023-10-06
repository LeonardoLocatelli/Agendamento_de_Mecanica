package com.example.projeto.service

import com.example.projeto.model.Login
import com.example.projeto.repository.LoginRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestLoginWrapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class LoginService (
        private val loginRepository: LoginRepository
) {

    fun adicionarLogin(login: RequestLoginWrapper): ApiResponse<String> {
        return try {
            loginRepository.save(Login(
                    nome = login.nome,
                    email = login.email,
                    senha = login.senha,

            ))
            ApiResponse(HttpStatus.OK, data = null, message = "Login Salvo com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Login não encontrado")
        }
    }

    fun excluirLogin(loginId: String): ApiResponse<String> {
        return try {
            loginId.let { loginRepository.deleteById(it) }
            ApiResponse(HttpStatus.OK, data = null, message = "Login Excluido com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Login não encontrado")
        }
    }

    fun editarLogin(login: RequestLoginWrapper): ApiResponse<Login> {
        return try {

            val loginMongo = login.id?.let { loginRepository.findById(it) }!!.get()

            loginMongo.nome = login.nome ?: loginMongo.nome
            loginMongo.email = login.email ?: loginMongo.email
            loginMongo.senha = login.senha ?: loginMongo.senha

            loginRepository.save(loginMongo)

            ApiResponse(HttpStatus.OK, data = loginMongo, message = "Login editado com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Login não encontrado")
        }
    }

}