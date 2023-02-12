package nsu.fit.qyoga.core.clients.api.model

import nsu.fit.qyoga.core.clients.api.model.Client
import org.springframework.data.domain.Page
import java.sql.Date

interface ClientsService{
    fun getClients(
        name : String?,
        surname : String?,
        birth_date : Date?,
        area_of_residence: String?,
        phone_number : String?,
        email: String?,
        distribution_source : String?,
        working_diagnose : String?,
        user_id : Int
        ): Page<Client>
}