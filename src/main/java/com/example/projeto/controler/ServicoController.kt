package com.example.projeto.controler


import com.example.projeto.model.Servico
import com.example.projeto.service.ServicoSevice
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestServicoWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/api")
class ServicoController(
        private val servicoService: ServicoSevice
) {

    @PostMapping("/cadastrarServico")
    fun cadastrarServico(@RequestBody servico: RequestServicoWrapper): ApiResponse<String> {
        return try {
            servicoService.cadastrarServico(servico)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar servico")
        }
    }

    @PostMapping("/excluirServico/{servicoId}")
    fun excluirServico(@PathVariable servicoId: String): ApiResponse<String> {
        return try {
            servicoService.excluirServico(servicoId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir servico")
        }
    }

    @PostMapping("/editarServico")
    fun editarServico(@RequestBody servico: RequestServicoWrapper): ApiResponse<Servico> {
        return try {
             servicoService.editarServico(servico)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar servico")
        }
    }

    @PostMapping("/buscarListaServico")
    fun buscarListaServico(): ApiResponse<List<Servico>> {
        return try {
            servicoService.buscaServico()
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao buscar lista de servico")
        }
    }

    @PostMapping("/alteraSituacaoServico/{servicoId}")
    fun alteraSituacaoServico(@PathVariable servicoId: String): ApiResponse<Boolean> {
       return try {
           return servicoService.alteraSituacao(servicoId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = false, message = "erro ao buscar servico")
        }
    }

}