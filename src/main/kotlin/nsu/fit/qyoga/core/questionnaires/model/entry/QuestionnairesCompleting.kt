package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.users.model.User
import java.util.*

class QuestionnairesCompleting(
    var client: User,
    var answers: List<Answer>,
    var date: Date
    )