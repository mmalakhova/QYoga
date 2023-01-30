package nsu.fit.qyoga.core.questionnaires.service.implement

import nsu.fit.qyoga.core.questionnaires.exceptions.*
import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import nsu.fit.qyoga.core.questionnaires.model.repository.AnswerRepo
import nsu.fit.qyoga.core.questionnaires.service.interfaces.AnswerService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AnswerServiceImpl(private val answerRepo : AnswerRepo ): AnswerService {

    override fun getAnswer(id: Long): Answer {
        return answerRepo.findByIdOrNull(id) ?: throw AnswerNotFoundException(id)
    }

    override fun saveAnswer(answer: Answer) {
        try {
            answerRepo.save(answer)
        } catch (e: IllegalArgumentException){
            throw BadAnswer()
        }
    }

    override fun deleteAnswer(id: Long) {
        val answer = answerRepo.findByIdOrNull(id) ?: throw AnswerNotFoundException(id)
        answerRepo.delete(answer)
    }

    override fun getQuestionAnswers(id: Long): List<Answer> {
        TODO("Not yet implemented")
        /*return answerRepo.findAnswersByQuestionId(id)*/
    }

    override fun updateAnswer(answer: Answer) {
        if(answerRepo.findByIdOrNull(answer.id) == null){
            throw AnswerNotFoundException(answer.id)
        }else{
            answerRepo.save(answer)
        }
    }
}