package nsu.fit.qyoga.core.clients.internal

import nsu.fit.qyoga.core.clients.api.ClientService
import nsu.fit.qyoga.core.clients.api.Dto.ClientDto
import nsu.fit.qyoga.core.clients.api.Dto.ClientSearchDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ClientServiceImpl(
    private val clientRepo: ClientRepo
) : ClientService {

    override fun getClients(searchDto: ClientSearchDto, page: Pageable): Page<ClientDto> {
        return clientRepo.getClientsByFilters(searchDto, page)
    }

    override fun deleteClient(id: Int): Boolean {
        return clientRepo.deleteClient(id)
    }
}
