package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import org.springframework.data.relational.core.mapping.Table

@Table("answers")
class Answer(
    var optionsText: String = "text",
    var optionsNumber: Int? = null,
    var optionsPhotoPath: String? = null,
    var optionsLowerBound: Int = 0,
    var optionsLowerBoundText: String? = null,
    var optionsUpperBound: Int = 2,
    var optionsUpperBoundText: String? = null,
    var points: Int = 0,
    /*var question: Question,*/
    var id: Long = 0
)