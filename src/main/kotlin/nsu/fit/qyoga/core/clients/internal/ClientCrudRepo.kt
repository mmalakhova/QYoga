package nsu.fit.qyoga.core.clients.internal

import nsu.fit.qyoga.core.clients.api.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientCrudRepo : CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {
}