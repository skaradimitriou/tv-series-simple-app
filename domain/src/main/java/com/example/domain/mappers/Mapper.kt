package com.example.domain.mappers

interface Mapper<T, R> {

    fun toDomainModel(dto: T): R
}