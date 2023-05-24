package com.latihan.masterservice.exception

open class RequiredFieldIsMissingException : RuntimeException{
    constructor(message: String) : super(message)
}