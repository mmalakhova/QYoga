package nsu.fit.qyoga.core.questionnaires.service.implement

import nsu.fit.qyoga.core.questionnaires.model.entry.QuestionnairesCompleting
import nsu.fit.qyoga.core.questionnaires.model.repository.QuestionnairesCompletingRepo
import nsu.fit.qyoga.core.questionnaires.service.interfaces.QuestionnairesCompletingService
import org.springframework.stereotype.Service

@Service
class QuestionnairesCompletingServiceImpl(val questionnairesCompletingRepo: QuestionnairesCompletingRepo):
    QuestionnairesCompletingService {

    override fun getCompleting(id: Long): QuestionnairesCompleting {
        TODO("Not yet implemented")
    }

    override fun saveCompleting(completing: QuestionnairesCompleting) {
        TODO("Not yet implemented")
    }

    override fun deleteCompleting(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getQuestionCompleting(id: Long): List<QuestionnairesCompleting> {
        TODO("Not yet implemented")
    }

}