package nsu.fit.qyoga.core.questionnaires.exceptions

import nsu.fit.qyoga.platform.errors.DomainException
import nsu.fit.qyoga.platform.errors.ResourceNotFound

sealed class AnswerException(message: String, cause: Throwable? = null) : DomainException(message, cause)

class BadAnswer : AnswerException("Bad Answer")

class AnswerNotFoundException(id: Long): ResourceNotFound("Answer with id=$id not found")
