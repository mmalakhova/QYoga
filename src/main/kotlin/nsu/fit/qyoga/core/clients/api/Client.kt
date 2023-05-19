package nsu.fit.qyoga.core.clients.api

import jakarta.validation.constraints.Email
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@Table("clients")
data class Client(
    @Id
    val id: Long = 0,
    val first_name: String,
    val patronymic: String,
    val last_name: String,

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val birth_date: LocalDate? = null,

    @Email
    val email: String,
    val phone_number: Long,
    val address: String,
    val distribution_source: String,
    val diagnose: String
)


