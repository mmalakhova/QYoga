package nsu.fit.qyoga.core.questionnaires.service.interfaces


import nsu.fit.qyoga.core.questionnaires.model.entry.Question

interface QuestionService {
    /**
     * Получение вопроса по его id
     */
    fun getQuestion(id :Long): Question

    /**
     * Сохранение вопроса
     */
    fun saveQuestion(question : Question)

    /**
     * Удаление вопроса
     */
    fun deleteQuestion(id :Long)

    /**
     * Получения списка вопросов по id опросника
     * @param id - id опросника
     * @return List<Question> - список вопросов
     */
    fun getQuestionnaireQuestions(id :Long): List<Question>

    /**
     * Изменение существующего вопроса
     */
    fun updateQuestion(question: Question)
}