package nsu.fit.qyoga.core.questionnaires.model.entry

import org.springframework.data.relational.core.mapping.Table

@Table("questionnaires")
class Questionnaire(
    var title: String,
    var questions: List<Question>,
    var id: Long = 0
)