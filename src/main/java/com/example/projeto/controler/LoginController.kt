package com.example.projeto.controler

import com.example.projeto.model.Login
import com.example.projeto.service.LoginService
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestLoginWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api")
class LoginController(
        private val loginService: LoginService
) {
    @PostMapping("/adicionarLogin")
    fun adicionarLogin(@RequestBody login: RequestLoginWrapper): ApiResponse<String> {
        return try {
            loginService.adicionarLogin(login)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar login")
        }
    }

    @PostMapping("/excluirLogin/{loginId}")
    fun excluirLogin(@PathVariable loginId: String): ApiResponse<String> {
        return try {
            loginService.excluirLogin(loginId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir login")
        }
    }

    @PostMapping("/editarLogin")
    fun editarLogin(@RequestBody login: RequestLoginWrapper): ApiResponse<Login> {
        return try {
            loginService.editarLogin(login)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar login")
        }
    }

}