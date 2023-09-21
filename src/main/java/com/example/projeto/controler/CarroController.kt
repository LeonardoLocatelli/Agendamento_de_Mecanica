package com.example.projeto.controler

import com.example.projeto.service.CarroSevice
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestCarroWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/api")
class CarroController(
        private val carroService: CarroSevice
) {

    @PostMapping("/adicionarCarro")
    fun adicionarCarro(@RequestBody carro: RequestCarroWrapper): ApiResponse<Any?>{
       return try {
           ApiResponse(HttpStatus.OK, data = carroService.adicionarCarro(carro))
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar carro")
        }
    }

    @PostMapping("/excluirCarro")
    fun excluirCarro(@RequestBody carro: RequestCarroWrapper): ApiResponse<Any?>{
        return try {
            ApiResponse(HttpStatus.OK, data = carroService.excluirCarro(carro))
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir carro")
        }
    }

    @PostMapping("/editarCarro")
    fun editarCarro(@RequestBody carro: RequestCarroWrapper): ApiResponse<Any?>{
        return try {
            ApiResponse(HttpStatus.OK, data = carroService.editarCarro(carro))
        } catch (e: Exception){
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar carro")
        }
    }

}