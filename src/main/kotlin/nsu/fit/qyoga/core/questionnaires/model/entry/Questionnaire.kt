package nsu.fit.qyoga.core.questionnaires.model.entry

import org.springframework.data.relational.core.mapping.Table

@Table("questionnaires")
data class Questionnaire(
    val title: String,
    val id: Long = 0
)