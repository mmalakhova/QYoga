package nsu.fit.qyoga.core.questionnaires.web.dto

import nsu.fit.qyoga.core.questionnaires.model.entry.ClientsAnswers
import nsu.fit.qyoga.core.questionnaires.model.entry.Question

class QuestionAnswersDto(
    var question: Question,
    var clientsAnswers: ClientsAnswers
)