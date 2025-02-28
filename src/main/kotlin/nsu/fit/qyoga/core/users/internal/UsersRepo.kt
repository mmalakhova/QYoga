package nsu.fit.qyoga.core.users.internal

import nsu.fit.qyoga.core.users.api.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface UsersRepo : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?

}
