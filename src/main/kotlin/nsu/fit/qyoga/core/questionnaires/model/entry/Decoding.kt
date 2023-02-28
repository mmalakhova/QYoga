package nsu.fit.qyoga.core.questionnaires.model.entry

import org.springframework.data.relational.core.mapping.Table

@Table("decoding")
class Decoding(
    var textResult: String = "",
    var lowerBound: Int = 0,
    var upperBound: Int = 0,
    var questionnaire: Questionnaire? = null,
    var id: Long = 0
)