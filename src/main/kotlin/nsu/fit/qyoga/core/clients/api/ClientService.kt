package nsu.fit.qyoga.core.clients.api

import nsu.fit.qyoga.core.clients.api.Dto.ClientDto
import nsu.fit.qyoga.core.clients.api.Dto.ClientSearchDto
import nsu.fit.qyoga.core.clients.api.Dto.NewClientDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ClientService {
    fun getClients(
        searchDto: ClientSearchDto,
        page: Pageable
    ): Page<ClientDto>

    fun deleteClient(id: Int): Boolean

    fun createClient(
        newClientDto: NewClientDto,
    ): Client

    fun editClient(
        newClientDto: NewClientDto
    ): Client
}
