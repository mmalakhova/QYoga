package nsu.fit.qyoga.core.questionnaires.model.entry

class ClientsAnswers(
    var optionalAnswerText: String? = null,
    var optionalValue: Int? = null,
    var question: Question? = null,
    var answers: List<Answer> = mutableListOf(),
    var id: Long = 0
)