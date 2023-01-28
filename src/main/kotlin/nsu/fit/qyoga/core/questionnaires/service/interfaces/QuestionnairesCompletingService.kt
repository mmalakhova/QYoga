package nsu.fit.qyoga.core.questionnaires.service.interfaces

import nsu.fit.qyoga.core.questionnaires.model.entry.QuestionnairesCompleting

interface QuestionnairesCompletingService {
    /**
     * Получение прохождения по его id
     */
    fun getCompleting(id :Long): QuestionnairesCompleting

    /**
     * Сохранение прохождения
     */
    fun saveCompleting(completing : QuestionnairesCompleting)

    /**
     * Удаление прохождения
     */
    fun deleteCompleting(id :Long)

    /**
     * Получения списка прохождений опросников по id вопроса
     * @param id - id вопроса
     * @return List<QuestionnairesCompleting> - список прохождения
     */
    fun getQuestionCompleting(id :Long): List<QuestionnairesCompleting>
}