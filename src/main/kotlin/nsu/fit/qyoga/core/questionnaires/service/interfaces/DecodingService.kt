package nsu.fit.qyoga.core.questionnaires.service.interfaces

import nsu.fit.qyoga.core.questionnaires.model.entry.Decoding


interface DecodingService {
    /**
     * Получение ключа по его id
     */
    fun getDecoding(id :Long): Decoding

    /**
     * Сохранение ключа
     */
    fun saveDecoding(decoding: Decoding)

    /**
     * Удаление ключа
     */
    fun deleteDecoding(id :Long)

    /**
     * Получения списка ключей по id опросника
     * @param id id опросника
     * @return список ключей
     */
    fun getQuestionnaireDecoding(id :Long): List<Decoding>

    /**
     * Изменение существующего ключа
     */
    fun updateDecoding(decoding: Decoding)

    /**
     * Получение расшифровки результата
     * @param id id опросника
     * @param result набранные очки
     * @return ключ, содержащий этот результат
     */
    fun getResultDecoding(id: Long, result: Long): Decoding
}