package nsu.fit.qyoga.app.therapist

import nsu.fit.qyoga.core.clients.api.ClientService
import nsu.fit.qyoga.core.clients.api.Dto.ClientDto
import nsu.fit.qyoga.core.clients.api.Dto.ClientSearchDto
import nsu.fit.qyoga.core.clients.api.Dto.NewClientDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

const val CLIENT_PAGE = "clients-list"
const val CREATE_EDIT_PAGE = "new-client-card"

@Controller
@RequestMapping("/clients")
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
        return CLIENT_PAGE
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
        return "clients-list :: clients"
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteClient(
        @PathVariable id: Int
    ) {
        clientService.deleteClient(id)
    }
    @GetMapping("/new-client")
    fun getNewClientPage(
        model: Model
    ): String {
        model.addAttribute("createDto", NewClientDto())
        return CREATE_EDIT_PAGE
    }
    @PostMapping
    fun createClient(
        @ModelAttribute("createDto") createDto: NewClientDto,
        @PageableDefault(value = 10, page = 0) pageable: Pageable,
        model: Model
    ): String {

        clientService.createClient(createDto)
        val clients = clientService.getClients(
            ClientSearchDto(),
            pageable
        )
        model.addAllAttributes(toModelAttributes(clients, ClientSearchDto()))
        return "redirect:/clients"
    }
    @PutMapping
    fun editClient(
        @ModelAttribute("clientDto") editDto: NewClientDto,
        @ModelAttribute("searchDto") searchDto: ClientSearchDto,
        @PageableDefault(value = 10, page = 0) pageable: Pageable,
        model: Model
    ): String {
        val clients = clientService.getClients(
            searchDto,
            pageable
        )
        clientService.editClient(editDto)
        model.addAllAttributes(toModelAttributes(clients, searchDto))
        return "redirect:/clients"
    }

    fun toModelAttributes(clients: Page<ClientDto>, searchDto: ClientSearchDto): Map<String, *> = mapOf(
        "searchDto" to searchDto,
        "clients" to clients,
        "pageNumbers" to 1..clients.totalPages
    )
}
