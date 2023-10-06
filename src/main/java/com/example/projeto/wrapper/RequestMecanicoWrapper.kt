package com.example.projeto.wrapper

import java.math.BigDecimal

class RequestMecanicoWrapper (
        val id: String? = null,
        var nome: String? = null,
        var telefone: String? = null,
        var cpf: String? = null,
        var salario: BigDecimal? = null
)