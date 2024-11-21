package com.example.extendednewsapp.data

sealed class NewsException(message: String): Exception(message) {
    class NetworkException(message: String): NewsException(message)
    class UnauthorizedException(message: String): NewsException(message)
    class NotFountException(message: String): NewsException(message)
    class ServerException(message: String): NewsException(message)
    class ParsingException(message: String): NewsException(message)
    class UnknownException(message: String): NewsException(message)
}