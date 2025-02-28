package nsu.fit.qyoga.core.exercises.api.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.time.Duration

@Table("exercises")
data class Exercise(
        val title: String,
        val description: String,
        val indications: String,
        val contradictions: String,
        val duration: Duration,
        val exerciseTypeId: Long,
        val therapistId: Long,
        @MappedCollection(idColumn = "exercise_id")
        val purposes: Set<ExercisePurpose>,
        @MappedCollection(idColumn = "exercise_id", keyColumn = "step_index")
        val steps: List<ExerciseStep>,
        @Id
        val id: Long = 0
) {

    fun mapSteps(body: (ExerciseStep) -> ExerciseStep): Exercise {
        val newSteps = steps.map(body)
        return copy(steps = newSteps)
    }

}
