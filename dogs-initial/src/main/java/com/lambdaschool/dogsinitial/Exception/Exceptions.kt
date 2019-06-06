package com.lambdaschool.dogsinitial.Exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(val serialVersionUID: Int = 1, message: String, cause: Throwable?): RuntimeException(message, cause)


class ValidationError(val code: String?, val message: String?)