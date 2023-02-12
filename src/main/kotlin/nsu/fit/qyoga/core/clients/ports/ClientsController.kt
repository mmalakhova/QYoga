package nsu.fit.qyoga.core.clients.ports

import nsu.fit.qyoga.core.clients.api.model.ClientsService
import nsu.fit.qyoga.core.clients.api.model.Client
import org.springframework.data.domain.Page
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.sql.Date

@RestController
@Validated
@RequestMapping("/exercises/")
class ClientsController(
    private val clientsService: ClientsService
) {
    /**
     * Получение списка упражнений
     */
    @GetMapping
    fun getClients(
        @RequestParam(value = "name", required = false) name: String?,
        @RequestParam(value = "surname", required = false) surname: String?,
        @RequestParam(value = "birth_date", required = false) birth_date: Date?,
        @RequestParam(value = "area_of_residence", required = false) area_of_residence: String?,
        @RequestParam(value = "phone_number", required = false) phone_number: String?,
        @RequestParam(value = "email", required = false) email: String?,
        @RequestParam(value = "distribution_source", required = false) distribution_source: String?,
        @RequestParam(value = "working_diagnose", required = false) working_diagnose: String?,
        @RequestParam(value = "user_id", required = false) user_id: Int
    ): Page<Client> {
        return clientsService.getClients(name, surname, birth_date ,area_of_residence, phone_number, email,
            distribution_source, working_diagnose, user_id)
    }

    /**
     * Создание клиента
     */
    @PostMapping
    fun createClient() {

    }

    /**
     * Удаление клиента
     */
    @DeleteMapping
    fun deleteClient() {

    }

    /**
     * Редактирование данных о клиенте
     */
    @PutMapping
    fun editClient() {

    }
}

