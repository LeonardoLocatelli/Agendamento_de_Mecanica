package com.example.projeto.service

import com.example.projeto.model.Login
import com.example.projeto.repository.LoginRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestLoginWrapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class LoginService(
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

    fun logar(body: RequestLoginWrapper): ApiResponse<String> {
        val loginMongo = loginRepository.findDistinctByEmail(body.email!!)
        return if (loginMongo.email == body.email && loginMongo.senha == body.senha) {
            ApiResponse(HttpStatus.OK, data = "Logado com sucesso", message = "")
        } else {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Não foi possivel logar ")
        }
    }

}