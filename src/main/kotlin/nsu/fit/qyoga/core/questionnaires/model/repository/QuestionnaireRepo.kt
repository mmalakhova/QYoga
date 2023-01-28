package nsu.fit.qyoga.core.questionnaires.model.repository

import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionnaireRepo : CrudRepository<Questionnaire, Long> {
}