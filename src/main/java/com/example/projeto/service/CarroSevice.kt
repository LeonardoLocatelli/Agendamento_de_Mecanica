package com.example.projeto.service

import com.example.projeto.model.Carro
import com.example.projeto.repository.CarroRepository
import com.example.projeto.wrapper.RequestCarroWrapper
import org.springframework.stereotype.Service

@Service
class CarroSevice(
        private val carroRepository: CarroRepository
) {

    fun adicionarCarro(carro: RequestCarroWrapper): Carro {
        return try {
             carroRepository.save(Carro(
                     carroId = "teste",
                     marca = "BMW",
                     ano = 2022,
                     modelo = "Conversivel",
                     problema = "Pneu furado",
                     dono = "Bedin",
            ))
        } catch (e: Exception) {
            carro as Carro
        }
    }

    fun excluirCarro(carro: RequestCarroWrapper): Carro {
        return try {
           var retorno = carro.id?.let { carroRepository.findById(it) }
            if(retorno!!.isPresent){

            }
            carro as Carro
        } catch (e: Exception) {
            carro as Carro
        }
    }

    fun editarCarro(carro: RequestCarroWrapper): Carro {
        return try {
            carroRepository.save(Carro(
                    carroId = "teste",
                    marca = "BMW",
                    ano = 2022,
                    modelo = "Conversivel",
                    problema = "Pneu furado",
                    dono = "Bedin",
            ))
        } catch (e: Exception) {
            carro as Carro
        }
    }

}
