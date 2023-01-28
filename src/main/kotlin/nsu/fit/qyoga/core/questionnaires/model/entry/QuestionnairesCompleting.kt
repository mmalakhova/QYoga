package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.users.model.User
import java.util.*

data class QuestionnairesCompleting(
    val client: User,
    var answers: List<Answer>,
    var date: Date
    )