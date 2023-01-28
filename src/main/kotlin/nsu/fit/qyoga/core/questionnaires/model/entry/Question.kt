package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import org.springframework.data.relational.core.mapping.Table


@Table("questions")
data class Question(
    val type: QuestionType,
    val text: String,
    val optionsPhotoPath: String,
    val questionnaire: Questionnaire,
    val id: Long = 0
)