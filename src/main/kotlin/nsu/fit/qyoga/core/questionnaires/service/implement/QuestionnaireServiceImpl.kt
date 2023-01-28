package nsu.fit.qyoga.core.questionnaires.service.implement

import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.model.repository.QuestionnaireRepo
import nsu.fit.qyoga.core.questionnaires.service.interfaces.QuestionnaireService

class QuestionnaireServiceImpl(val questionnaireRepo: QuestionnaireRepo): QuestionnaireService {

    override fun getQuestionnaire(id: Long): Questionnaire {
        TODO("Not yet implemented")
    }

    override fun saveQuestionnaire(questionnaire: Questionnaire) {
        TODO("Not yet implemented")
    }

    override fun deleteQuestionnaire(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateQuestionnaire(questionnaire: Questionnaire) {
        TODO("Not yet implemented")
    }
}