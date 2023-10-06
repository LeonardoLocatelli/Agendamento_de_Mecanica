package com.example.projeto.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.math.BigDecimal
import java.util.*

@Document(collection = "mecanico")
class Mecanico(

        @Id
        @Field("_id")
        var id: String = UUID.randomUUID().toString(),

        @Field("nome")
        var nome: String? = null,

        @Field("telefone")
        var telefone: String? = null,

        @Field("cpf")
        var cpf: String? = null,

        @Field("salario")
        var salario: BigDecimal? = null,
)