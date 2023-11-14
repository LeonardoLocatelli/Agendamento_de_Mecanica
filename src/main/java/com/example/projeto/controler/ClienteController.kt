package com.example.projeto.controler

import com.example.projeto.model.Cliente
import com.example.projeto.service.ClienteService
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestClienteWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api")
class ClienteController (

        @Autowired
            private val clienteService: ClienteService,
){

    @PostMapping("/cadastrarCliente")
    fun cadastrarCliente(@RequestBody cliente: RequestClienteWrapper): ApiResponse<String> {
        return try {
            clienteService.cadastrarCliente(cliente)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao adicionar cliente")
        }
    }

    @PostMapping("/excluirCliente/{clienteId}")
    fun excluirCliente(@PathVariable clienteId: String): ApiResponse<String> {
        return try {
            clienteService.excluirCliente(clienteId)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao excluir cliente")
        }
    }

    @PostMapping("/editarCliente")
    fun editarCliente(@RequestBody cliente: RequestClienteWrapper): ApiResponse<Cliente> {
        return try {
            clienteService.editarCliente(cliente)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao editar cliente")
        }
    }

    @PostMapping("/buscarListaCliente")
    fun buscarListaCliente(): ApiResponse<List<Cliente>> {
        return try {
            clienteService.buscaCliente()
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "erro ao buscar lista de cliente")
        }
    }

}