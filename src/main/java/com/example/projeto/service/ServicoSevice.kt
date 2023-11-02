package com.example.projeto.service

import com.example.projeto.model.Servico
import com.example.projeto.repository.ServicoRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestServicoWrapper
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ServicoSevice(
        private val servicoRepository: ServicoRepository
) {

    fun cadastrarServico(servico: RequestServicoWrapper): ApiResponse<String> {
        return try {
            servicoRepository.save(Servico(
                    marca = servico.marca,
                    ano = servico.ano,
                    modelo = servico.modelo,
                    problema = servico.problema,
                    dono = servico.nome,
                    telefone = servico.telefone,
                    cpf = servico.cpf,
                    mecanico = servico.mecanico,
                    dataEntrada = servico.dataEntrada,
                    dataSaida = servico.dataSaia
            ))
            ApiResponse(HttpStatus.OK, data = null, message = "Serviço salvo com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Serviço não encontrado")
        }
    }

    fun excluirServico(servicoId: String): ApiResponse<String> {
        return try {
            servicoId.let { servicoRepository.deleteById(it) }
            ApiResponse(HttpStatus.OK, data = null, message = "Serviço excluído com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Serviço não encontrado")
        }
    }

    fun editarServico(servico: RequestServicoWrapper): ApiResponse<Servico> {
        return try {

            val servicoMongo = servico.id?.let { servicoRepository.findById(it) }!!.get()

            servicoMongo.marca = servico.marca ?: servicoMongo.marca
            servicoMongo.ano = servico.ano ?: servicoMongo.ano
            servicoMongo.modelo = servico.modelo ?: servicoMongo.modelo
            servicoMongo.problema = servico.problema ?: servicoMongo.problema
            servicoMongo.dono = servico.nome ?: servicoMongo.dono
            servicoMongo.telefone = servico.telefone ?: servicoMongo.telefone
            servicoMongo.cpf = servico.cpf ?: servicoMongo.cpf
            servicoMongo.mecanico = servico.mecanico ?: servicoMongo.mecanico

            // Atualize as datas de entrada e previsão de saída conforme necessário
            servicoMongo.dataEntrada = servico.dataEntrada
            servicoMongo.dataSaida = servico.dataSaia

            servicoRepository.save(servicoMongo)

            ApiResponse(HttpStatus.OK, data = servicoMongo, message = "Serviço editado com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Serviço não encontrado")
        }
    }

    fun buscaServico(): ApiResponse<List<Servico>> {
        return try {
            val servicosMongo = servicoRepository.findAll()
            ApiResponse(HttpStatus.OK, data = servicosMongo)
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Serviços não encontrados")
        }
    }
}