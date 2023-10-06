package com.example.projeto.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext

@Configuration
class MongoConfig(
        private val mongoDbFactory: MongoDatabaseFactory,
        private val mongoMappingContext: MongoMappingContext
) {

    @Bean
    fun mappingMongoConverter(): MappingMongoConverter {
        DefaultDbRefResolver(mongoDbFactory).let {
            MappingMongoConverter(it, mongoMappingContext).apply {
                this.setTypeMapper(DefaultMongoTypeMapper(null))
                return this
            }
        }
    }
}