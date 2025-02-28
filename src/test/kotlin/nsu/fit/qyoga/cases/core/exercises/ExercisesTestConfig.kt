package nsu.fit.qyoga.cases.core.exercises

import nsu.fit.qyoga.app.QYogaAppJdbcConfig
import nsu.fit.qyoga.core.exercises.ExercisesConfig
import nsu.fit.qyoga.core.therapeutic_purposes.TherapeuticPurposesConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.context.annotation.Import

@Import(ExercisesConfig::class, TherapeuticPurposesConfig::class, QYogaAppJdbcConfig::class)
@SpringBootApplication(exclude = [WebMvcAutoConfiguration::class])
class ExercisesTestConfig
