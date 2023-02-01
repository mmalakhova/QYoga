package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import org.springframework.data.relational.core.mapping.Table


@Table("questions")
class Question(
    var type: QuestionType = QuestionType.SINGLE,
    var text: String = "text",
    var optionsPhotoPath: String? = null,
    /*var questionnaire: Questionnaire,*/
    var answers: List<Answer> = mutableListOf(),
    var id: Long = 0
)