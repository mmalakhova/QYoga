package nsu.fit.qyoga.core.questionnaires.model.entry

import org.springframework.data.relational.core.mapping.Table

@Table("decoding")
class Decoding(
    var textResult: String,
    var lowerBound: Int,
    var upperBound: Int,
    var questionnaire: Questionnaire,
    var id: Long = 0
)