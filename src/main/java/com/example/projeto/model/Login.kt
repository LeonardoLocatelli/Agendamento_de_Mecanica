package com.example.projeto.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "login")
class Login (

        @Id
        @Field("_id")
        var id: String = UUID.randomUUID().toString(),

        @Field("nome")
        var nome: String? = null,

        @Field("email")
        var email: String? = null,

        @Field("senha")
        var senha: String? = null,
)