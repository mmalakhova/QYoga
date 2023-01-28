package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.users.model.User
import org.springframework.data.relational.core.mapping.Table

@Table("answers")
data class Answer(
    val optionsText: String,
    val optionsNumber: Int,
    val optionsPhotoPath: String,
    val optionsLowerBound: Int,
    val optionsUpperBound: Int,
    val points: Int,
    val question: Question,
    val id: Long = 0
)