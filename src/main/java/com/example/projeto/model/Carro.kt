package com.example.projeto.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Carro")
data class Carro(

    @Id
    @Field("carroId")
    val carroId: String? = null,

    @Field("marca")
    val marca: String? = null,

    @Field("ano")
    val ano: Int? = null,

    @Field("modelo")
    val modelo: String? = null,

    @Field("problema")
    val problema: String? = null,

    @Field("dono")
    val dono: String? = null
)