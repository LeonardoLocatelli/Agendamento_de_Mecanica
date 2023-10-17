package com.example.projeto.controler

import com.example.projeto.model.Servico
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestServicoWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/api")
class ServicoController() {

    @PostMapping("/adicionarServico")
    fun adicionarServico(@RequestBody carro: RequestServicoWrapper): ApiResponse<String> {
        return try {
            carroService.adicionarServico(carro)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar carro")
        }
    }

    @PostMapping("/excluirServico/{carroId}")
    fun excluirServico(@PathVariable carroId: String): ApiResponse<String> {
        return try {
            carroService.excluirServico(carroId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir carro")
        }
    }

    @PostMapping("/editarServico")
    fun editarServico(@RequestBody carro: RequestServicoWrapper): ApiResponse<Servico> {
        return try {
            carroService.editarServico(carro)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar carro")
        }
    }

}