package com.example.projeto.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "carro")
data class Carro(

        @Id
        @Field("_id")
        var id: String = UUID.randomUUID().toString(),

        @Field("marca")
        var marca: String? = null,

        @Field("ano")
        var ano: Int? = null,

        @Field("modelo")
        var modelo: String? = null,

        @Field("problema")
        var problema: String? = null,

        @Field("dono")
        var dono: String? = null,

        @Field("telefonedono")
        var telefonedono: String? = null
)