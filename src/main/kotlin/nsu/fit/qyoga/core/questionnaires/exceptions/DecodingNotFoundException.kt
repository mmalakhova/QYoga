package nsu.fit.qyoga.core.questionnaires.exceptions

import nsu.fit.qyoga.platform.errors.DomainException
import nsu.fit.qyoga.platform.errors.ResourceNotFound

sealed class DecodingException(message: String, cause: Throwable? = null) : DomainException(message, cause)

class BadDecoding : DecodingException("Bad Decoding")

class DecodingNotFoundException(id: Long): ResourceNotFound("Decoding with id=$id not found")
