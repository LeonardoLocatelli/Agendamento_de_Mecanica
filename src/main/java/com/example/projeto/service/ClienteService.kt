package com.example.projeto.service

import com.example.projeto.model.Cliente
import com.example.projeto.repository.ClienteRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestClienteWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ClienteService(
        @Autowired
        private val clienteRepository: ClienteRepository
) {


    fun cadastrarCliente(cliente: RequestClienteWrapper): ApiResponse<String> {
        return try {
            clienteRepository.save(Cliente(
                    marca = cliente.marca,
                    ano = cliente.ano,
                    modelo = cliente.modelo,
                    problema = "",
                    dono = cliente.nome,
                    telefone = cliente.telefone,
                    cpf = cliente.cpf,
            ))

            ApiResponse(HttpStatus.OK, data = null, message = "Cliente salvo com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Cliente não encontrado")
        }
    }

    fun excluirCliente(clienteId: String): ApiResponse<String> {
        return try {
            clienteRepository.deleteById(clienteId)
            ApiResponse(HttpStatus.OK, data = null, message = "Cliente excluído com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Cliente não encontrado")
        }
    }

    fun editarCliente(cliente: RequestClienteWrapper): ApiResponse<Cliente> {
        return try {

            val clienteMongo = cliente.id?.let { clienteRepository.findById(it) }!!.get()

            clienteMongo.marca = cliente.marca ?: clienteMongo.marca
            clienteMongo.ano = cliente.ano ?: clienteMongo.ano
            clienteMongo.modelo = cliente.modelo ?: clienteMongo.modelo
            clienteMongo.problema = cliente.problema ?: clienteMongo.problema
            clienteMongo.dono = cliente.nome ?: clienteMongo.dono
            clienteMongo.telefone = cliente.telefone ?: clienteMongo.telefone
            clienteMongo.cpf = cliente.cpf ?: clienteMongo.cpf

            clienteRepository.save(clienteMongo)

            ApiResponse(HttpStatus.OK, data = clienteMongo, message = "Cliente editado com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Cliente não encontrado")
        }
    }

    fun buscaCliente(): ApiResponse<List<Cliente>> {
        return try {
            val clientesMongo = clienteRepository.findAll()
            ApiResponse(HttpStatus.OK, data = clientesMongo)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Clientes não encontrados")
        }
    }
}


