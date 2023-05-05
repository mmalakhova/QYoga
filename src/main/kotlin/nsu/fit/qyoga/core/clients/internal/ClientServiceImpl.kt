package nsu.fit.qyoga.core.clients.internal

import nsu.fit.platform.errors.ResourceNotFound
import nsu.fit.qyoga.core.clients.api.Client
import nsu.fit.qyoga.core.clients.api.ClientService
import nsu.fit.qyoga.core.clients.api.Dto.ClientDto
import nsu.fit.qyoga.core.clients.api.Dto.ClientSearchDto
import nsu.fit.qyoga.core.clients.api.Dto.NewClientDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ClientServiceImpl(
    private val clientRepo: ClientRepo,
    private val clientCrudRepo: ClientCrudRepo
) : ClientService {

    override fun getClients(searchDto: ClientSearchDto, page: Pageable): Page<ClientDto> {
        return clientRepo.getClientsByFilters(searchDto, page)
    }

    override fun deleteClient(id: Int): Boolean {
        return clientRepo.deleteClient(id)
    }

    override fun createClient(newClientDto: NewClientDto): Client {

        return clientCrudRepo.save(
            Client(
                firstname = newClientDto.firstName!!,
                patronymic = newClientDto.patronymic!!,
                lastname = newClientDto.lastName!!,
                birthdate = newClientDto.birthDate!!,
                phoneNumber = newClientDto.phoneNumber!!,
                email = newClientDto.email!!,
                address = newClientDto.address!!,
                workingDiagnose = newClientDto.diagnose!!,
                distributionSource = newClientDto.distribution!!
            )
        )
    }

    override fun editClient(newClientDto: NewClientDto): Client {
        val targetClient =
            clientCrudRepo.findByIdOrNull(newClientDto.id!!)
                ?: throw ResourceNotFound("No existing exercise with id = ${newClientDto.id}")

        return targetClient.copy(
            firstname = newClientDto.firstName!!,
            patronymic = newClientDto.patronymic!!,
            lastname = newClientDto.lastName!!,
            birthdate = newClientDto.birthDate!!,
            phoneNumber = newClientDto.phoneNumber!!,
            email = newClientDto.email!!,
            address = newClientDto.address!!,
            workingDiagnose = newClientDto.diagnose!!,
            distributionSource = newClientDto.distribution!!
        )
    }

}
