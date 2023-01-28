package nsu.fit.qyoga.core.questionnaires.model.entry

import org.springframework.data.relational.core.mapping.Table

@Table("decoding")
data class Decoding(
    val textResult: String,
    val lowerBound: Int,
    val upperBound: Int,
    val questionnaire: Questionnaire,
    val id: Long = 0
)