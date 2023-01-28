package nsu.fit.qyoga.core.questionnaires.model.repository

import nsu.fit.qyoga.core.questionnaires.model.entry.Question
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepo : CrudRepository<Question, Long> {
}