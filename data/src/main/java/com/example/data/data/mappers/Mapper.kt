package com.example.data.data.mappers

interface Mapper<T, R> {

    fun toDomainModel(dto: T): R
}