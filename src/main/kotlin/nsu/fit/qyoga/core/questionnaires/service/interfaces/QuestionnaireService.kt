package nsu.fit.qyoga.core.questionnaires.service.interfaces


import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire


interface QuestionnaireService {
    /**
     * Получение опросника по его id
     */
    fun getQuestionnaire(id :Long): Questionnaire

    /**
     * Сохранение опросника
     */
    fun saveQuestionnaire(questionnaire : Questionnaire)

    /**
     * Удаление опросника
     */
    fun deleteQuestionnaire(id :Long)

    /**
     * Изменение существующего опросника
     */
    fun updateQuestionnaire(questionnaire: Questionnaire)
}