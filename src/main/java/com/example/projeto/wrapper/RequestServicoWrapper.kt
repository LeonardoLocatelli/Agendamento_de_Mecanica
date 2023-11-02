package com.example.projeto.wrapper

import java.util.Date

class RequestServicoWrapper(
        var id: String? = null,
        val nome: String? = null,
        var cpf: String? = null,
        var telefone: String? = null,
        var marca: String? = null,
        var ano: Int? = null,
        var modelo: String? = null,
        var problema: String? = null,
        var mecanico: String? = null,
        var dataEntrada : String? = null,
        var dataSaia: String? = null,
)