package nsu.fit.qyoga.core.questionnaires.service.implement

import nsu.fit.qyoga.core.questionnaires.model.entry.Question
import nsu.fit.qyoga.core.questionnaires.model.repository.QuestionnaireRepo
import nsu.fit.qyoga.core.questionnaires.service.interfaces.QuestionService
import org.springframework.stereotype.Service

@Service
class QuestionServiceImpl(val questionRepo: QuestionnaireRepo): QuestionService {
    override fun getQuestion(id: Long): Question {
        TODO("Not yet implemented")
    }

    override fun saveQuestion(question: Question) {
        TODO("Not yet implemented")
    }

    override fun deleteQuestion(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getQuestionnaireQuestions(id: Long): List<Question> {
        TODO("Not yet implemented")
    }

    override fun updateQuestion(question: Question) {
        TODO("Not yet implemented")
    }
}