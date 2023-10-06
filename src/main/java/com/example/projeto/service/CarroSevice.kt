package com.example.projeto.service

import com.example.projeto.model.Carro
import com.example.projeto.repository.CarroRepository
import com.example.projeto.wrapper.ApiResponse
import com.example.projeto.wrapper.RequestCarroWrapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class CarroSevice(
        private val carroRepository: CarroRepository
) {

    fun adicionarCarro(carro: RequestCarroWrapper): ApiResponse<String> {
        return try {
            carroRepository.save(Carro(
                    marca = carro.marca,
                    ano = carro.ano,
                    modelo = carro.modelo,
                    problema = carro.problema,
                    dono = carro.dono,
                    telefonedono = carro.telefoneDono

            ))
            ApiResponse(HttpStatus.OK, data = null, message = "Carro Salvo com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Carro não encontrado")
        }
    }

    fun excluirCarro(carroId: String): ApiResponse<String> {
        return try {
            carroId.let { carroRepository.deleteById(it) }
            ApiResponse(HttpStatus.OK, data = null, message = "Carro Excluido com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Carro não encontrado")
        }
    }

    fun editarCarro(carro: RequestCarroWrapper): ApiResponse<Carro> {
        return try {

            val carroMongo = carro.id?.let { carroRepository.findById(it) }!!.get()

            carroMongo.marca = carro.marca ?: carroMongo.marca
            carroMongo.ano = carro.ano ?: carroMongo.ano
            carroMongo.modelo = carro.modelo ?: carroMongo.modelo
            carroMongo.problema = carro.problema ?: carroMongo.problema
            carroMongo.dono = carro.dono ?: carroMongo.dono
            carroMongo.telefonedono = carro.telefoneDono ?: carroMongo.telefonedono

            carroRepository.save(carroMongo)

            ApiResponse(HttpStatus.OK, data = carroMongo, message = "Carro editado com sucesso!")
        } catch (e: Exception) {
            ApiResponse(HttpStatus.BAD_REQUEST, data = null, message = "Carro não encontrado")
        }
    }

}
