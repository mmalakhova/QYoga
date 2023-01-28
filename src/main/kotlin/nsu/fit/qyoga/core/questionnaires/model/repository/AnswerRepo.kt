package nsu.fit.qyoga.core.questionnaires.model.repository

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepo : CrudRepository<Answer, Long> {

    fun findAnswersByQuestionId(id: Long): List<Answer>
}