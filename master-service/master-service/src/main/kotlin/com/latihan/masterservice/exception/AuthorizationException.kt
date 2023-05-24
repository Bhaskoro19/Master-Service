package com.latihan.masterservice.exception

open class AuthorizationException : RuntimeException{
    constructor(message: String) : super(message)
}