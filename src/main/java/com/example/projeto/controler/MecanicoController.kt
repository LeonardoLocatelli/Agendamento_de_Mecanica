package com.example.projeto.controler

import com.example.projeto.model.Mecanico
import com.example.projeto.service.MecanicoService
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestMecanicoWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api")
class MecanicoController(
        private val mecanicoService: MecanicoService
) {

    @PostMapping("/adicionarMecanico")
    fun adicionarMecanico(@RequestBody mecanico: RequestMecanicoWrapper): ApiResponse<String> {
        return try {
            mecanicoService.adicionarMecanico(mecanico)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar mecanico")
        }
    }

    @PostMapping("/excluirMecanico/{mecanicoId}")
    fun excluirMecanico(@PathVariable mecanicoId: String): ApiResponse<String> {
        return try {
            mecanicoService.excluirMecanico(mecanicoId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir mecanico")
        }
    }

    @PostMapping("/editarMecanico")
    fun editarMecanico(@RequestBody mecanico: RequestMecanicoWrapper): ApiResponse<Mecanico> {
        return try {
            mecanicoService.editarMecanico(mecanico)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar mecanico")
        }
    }

}