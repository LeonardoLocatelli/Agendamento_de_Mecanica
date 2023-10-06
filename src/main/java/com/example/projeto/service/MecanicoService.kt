package com.example.projeto.service

import com.example.projeto.model.Mecanico
import com.example.projeto.repository.MecanicoRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestMecanicoWrapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class MecanicoService(
        private val mecanicoRepository: MecanicoRepository
) {

    fun adicionarMecanico(mecanico: RequestMecanicoWrapper): ApiResponse<String> {
        return try {
            mecanicoRepository.save(Mecanico(
                    nome = mecanico.nome,
                    telefone = mecanico.telefone,
                    cpf = mecanico.cpf,
                    salario = mecanico.salario
            ))
            ApiResponse(HttpStatus.OK, data = null, message = "Mecanico Salvo com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Mecanico não encontrado")
        }
    }

    fun excluirMecanico(mecanicoId: String): ApiResponse<String> {
        return try {
            mecanicoId.let { mecanicoRepository.deleteById(it) }
            ApiResponse(HttpStatus.OK, data = null, message = "Mecanico Excluido com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Mecanico não encontrado")
        }
    }

    fun editarMecanico(mecanico: RequestMecanicoWrapper): ApiResponse<Mecanico> {
        return try {

            val mecanicoMongo = mecanico.id?.let { mecanicoRepository.findById(it) }!!.get()

            mecanicoMongo.nome = mecanico.nome ?: mecanicoMongo.nome
            mecanicoMongo.telefone = mecanico.telefone ?: mecanicoMongo.telefone
            mecanicoMongo.cpf = mecanico.cpf ?: mecanicoMongo.cpf
            mecanicoMongo.salario = mecanico.salario ?: mecanicoMongo.salario

            mecanicoRepository.save(mecanicoMongo)

            ApiResponse(HttpStatus.OK, data = mecanicoMongo)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Mecanico não encontrado")
        }
    }

}