package nsu.fit.qyoga.core.questionnaires.service.interfaces

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer

interface AnswerService {
    /**
     * Получение ответа по его id
     */
    fun getAnswer(id :Long): Answer

    /**
     * Сохранение ответа
     */
    fun saveAnswer(answer :Answer)

    /**
     * Удаление ответа
     */
    fun deleteAnswer(id :Long)

    /**
     * Получения списка ответов по id вопроса
     * @param id - id вопроса
     * @return List<Answer> - список ответов
     */
    fun getQuestionAnswers(id :Long): List<Answer>

    /**
     * Изменение существующего ответа
     */
    fun updateAnswer(answer: Answer)

}