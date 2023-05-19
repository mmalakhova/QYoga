package nsu.fit.qyoga.core.clients.api.Dto

import java.time.LocalDate

data class NewClientDto (
    val id: Long? = null,
    val firstName: String? = null,
    val patronymic: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val phoneNumber: Long? = null,
    val email: String? = null,
    val address: String? = null,
    val diagnose: String? = null,
    val distribution: String? = null
)