package com.example.projeto.controler

import com.example.projeto.wrapper.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("carro")
class CarroController() {

    @PostMapping("/adicionarCarro")
    fun adicionarCarro(@RequestBody body: Map<String, Any?> ): ApiResponse<Any?>{
       return try {
           ApiResponse(HttpStatus.OK, data = null, message = "eba conectou")
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "nao deu certo")
        }
    }

    @PostMapping("/excluirCarro")
    fun excluirCarro(@RequestBody body: Map<String, Any?> ): ApiResponse<Any?>{
        return try {
            ApiResponse(HttpStatus.OK, data = null, message = "eba conectou")
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "nao deu certo")
        }
    }

    @PostMapping("/editarCarro")
    fun editarCarro(@RequestBody body: Map<String, Any?> ): ApiResponse<Any?>{
        return try {
            ApiResponse(HttpStatus.OK, data = null, message = "eba conectou")
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "nao deu certo")
        }
    }

}