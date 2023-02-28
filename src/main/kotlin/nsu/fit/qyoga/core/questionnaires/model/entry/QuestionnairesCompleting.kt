package nsu.fit.qyoga.core.questionnaires.model.entry

import java.util.*

class QuestionnairesCompleting(
    var client: Client,
    var questionnaireId: Int,
    var answers: List<ClientsAnswers>,
    var date: Date,
    var id: Long = 0
    )