package com.example.projeto.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "cliente")
class Cliente (
        @Id
        @Field("_id")
        var id: String = UUID.randomUUID().toString(),

        @Field("marca")
        var marca: String? = null,

        @Field("ano")
        var ano: Int? = null,

        @Field("modelo")
        var modelo: String? = null,

        @Field("dono")
        var dono: String? = null,

        @Field("telefone")
        var telefone: String? = null,

        @Field("cpf")
        var cpf: String? = null,
)