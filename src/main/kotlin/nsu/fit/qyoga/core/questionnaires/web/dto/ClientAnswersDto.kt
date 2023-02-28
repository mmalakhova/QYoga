package nsu.fit.qyoga.core.questionnaires.web.dto

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import nsu.fit.qyoga.core.questionnaires.model.entry.ClientsAnswers
import nsu.fit.qyoga.core.questionnaires.model.entry.Question

class ClientAnswersDto(
    var optionalAnswerText: String? = null,
    var optionalValue: Int? = null,
    var questionId: Int = 0,
    var answersIdList: List<Int?> = mutableListOf(),
)

class ClientAnswersDtoList{
    var clientAnswersDtoList: List<ClientAnswersDto> = mutableListOf()
}