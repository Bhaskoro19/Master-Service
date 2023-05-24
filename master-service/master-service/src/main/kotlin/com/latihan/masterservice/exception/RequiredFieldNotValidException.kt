package com.latihan.masterservice.exception

import java.lang.RuntimeException

class RequiredFieldNotValidException : RuntimeException {
    constructor(message: String) : super(message)
}