package nsu.fit.qyoga.app.therapist.clients

import nsu.fit.qyoga.core.clients.api.ClientService
import nsu.fit.qyoga.core.clients.api.Dto.ClientDto
import nsu.fit.qyoga.core.clients.api.Dto.ClientSearchDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/therapist/clients")
class ClientListPageController(
    private val clientService: ClientService
) {
    @GetMapping
    fun getClients(
        @ModelAttribute("searchDto") searchDto: ClientSearchDto,
        @PageableDefault(value = 10, page = 0) pageable: Pageable,
        model: Model
    ): String {
        val clients = clientService.getClients(
            searchDto,
            pageable
        )
        model.addAllAttributes(toModelAttributes(clients, searchDto))
        return "therapist/clients/clients-list"
    }

    @GetMapping("/search-cl")
    fun getClientsFiltered(
        @ModelAttribute("searchDto") searchDto: ClientSearchDto,
        @PageableDefault(value = 10, page = 0) pageable: Pageable,
        model: Model
    ): String {
        val clients = clientService.getClients(
            searchDto,
            pageable
        )
        model.addAllAttributes(toModelAttributes(clients, searchDto))
        return "therapist/clients/clients-list :: clients"
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteClient(
        @PathVariable id: Int
    ) {
        clientService.deleteClient(id)
    }

    fun toModelAttributes(clients: Page<ClientDto>, searchDto: ClientSearchDto): Map<String, *> = mapOf(
        "searchDto" to searchDto,
        "clients" to clients,
        "pageNumbers" to 1..clients.totalPages
    )
}
