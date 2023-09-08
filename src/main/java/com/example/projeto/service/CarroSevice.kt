package com.example.projeto.service

import com.example.projeto.model.Carro
import com.example.projeto.wrapper.RequestCarroWrapper
import org.springframework.stereotype.Service

@Service
class CarroSevice {

    fun adicionarCarro(carro: RequestCarroWrapper): Carro {

        return carro as Carro
    }

    fun excluirCarro(carro: RequestCarroWrapper): Carro{

        return carro as Carro
    }

    fun editarCarro(carro: RequestCarroWrapper): Carro{

        return carro as Carro
    }

}
