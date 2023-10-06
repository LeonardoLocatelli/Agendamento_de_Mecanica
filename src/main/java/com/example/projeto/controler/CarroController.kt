package com.example.projeto.controler

import com.example.projeto.model.Carro
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
    fun adicionarCarro(@RequestBody carro: RequestCarroWrapper): ApiResponse<String> {
        return try {
            carroService.adicionarCarro(carro)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar carro")
        }
    }

    @PostMapping("/excluirCarro/{carroId}")
    fun excluirCarro(@PathVariable carroId: String): ApiResponse<String> {
        return try {
            carroService.excluirCarro(carroId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir carro")
        }
    }

    @PostMapping("/editarCarro")
    fun editarCarro(@RequestBody carro: RequestCarroWrapper): ApiResponse<Carro> {
        return try {
             carroService.editarCarro(carro)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar carro")
        }
    }

}