package nsu.fit.qyoga.core.questionnaires.model.repository

import nsu.fit.qyoga.core.questionnaires.model.entry.QuestionnairesCompleting
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionnairesCompletingRepo : CrudRepository<QuestionnairesCompleting, Long> {
}