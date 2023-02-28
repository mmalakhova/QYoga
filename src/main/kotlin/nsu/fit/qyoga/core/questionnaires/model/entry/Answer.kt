package nsu.fit.qyoga.core.questionnaires.model.entry

import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import org.springframework.data.relational.core.mapping.Table

@Table("answers")
class Answer(
    var optionsText: String = "text",
    var optionsPhotoPath: String? = null,
    var optionsLowerBound: Int = 0,
    var optionsLowerBoundText: String? = "left text",
    var optionsUpperBound: Int = 10,
    var optionsUpperBoundText: String? = "right text",
    var optionsScore: Int = 0,
    var id: Long = 0
)