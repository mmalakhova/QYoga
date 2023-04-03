package nsu.fit.qyoga.cases.core.exercises.ui

import io.github.ulfs.assertj.jsoup.Assertions
import io.restassured.http.Cookie
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import nsu.fit.qyoga.core.exercises.api.dtos.CreateExerciseDto
import nsu.fit.qyoga.core.exercises.api.model.ExerciseType
import nsu.fit.qyoga.infra.QYogaAppTestBase
import nsu.fit.qyoga.infra.db.DbInitializer
import org.jsoup.Jsoup
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

private const val USERNAME_FORM_PARAM = "username"
private const val PASSWORD_FORM_PARAM = "password"

class ExerciseViewTest : QYogaAppTestBase() {

    @Autowired
    lateinit var dbInitializer: DbInitializer
    lateinit var cookie: Cookie

    @BeforeEach
    fun setupDb() {
        dbInitializer.executeScripts(
            "/db/exercises/exercises-init-script.sql" to "dataSource",
            "/db/exercises/exercises-insert-data-script.sql" to "dataSource"
        )
    }

    @BeforeEach
    fun setupCookie() {
        cookie = Given {
            formParam(USERNAME_FORM_PARAM, "therapist")
            formParam(PASSWORD_FORM_PARAM, "diem-Synergy5")
        }.post("/users/login").thenReturn().detailedCookie("JSESSIONID")
    }

    @Test
    fun `QYoga returns exercise-search page with exercise table`() {
        Given {
            cookie(cookie)
        } When {
            get("/exercises/")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#exercisesTable") { exists() }
                node("#exercises-list") { exists() }
                node("td") { exists() }
            }
        }
    }

    @Test
    fun `QYoga returns exercise-search page with input fields`() {
        Given {
            cookie(cookie)
        } When {
            get("/exercises/")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#titleFilter") { exists() }
                node("#contradictionFilter") { exists() }
                node("#therapeuticPurposeFilter") { exists() }
                node("#exerciseTypeFilter") { exists() }
            }
        }
    }

    @Test
    fun `QYoga returns exercises table with pagination`() {
        Given {
            cookie(cookie)
        } When {
            get("/exercises/search")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#exercisesTable") { exists() }
                node("#exercises-list") { exists() }
                node("td") { exists() }
                node("#pagination") { exists() }
            }
        }
    }

    @Test
    fun `QYoga returns exercise creation page`() {
        Given {
            cookie(cookie)
        } When {
            get("/exercises/create")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#createExerciseForm") { exists() }
                node("#buttons") { exists() }
            }
        }
    }

    @Test
    fun `QYoga returns exercise search page after creating a new exercise`() {
        val createDto = CreateExerciseDto(
            title = "Разминка для спины",
            description = "",
            indications = "",
            contradiction = "",
            duration = "00:10:00",
            exerciseType = ExerciseType.WarmUp
        )

        Given {
            cookie(cookie)
        } When {
//            param("createDto", createDto)
            post("/exercises/")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#exercisesTable") { exists() }
                node("#exercises-list") { exists() }
                node("td") { exists() }
                node("#pagination") { exists() }
            }
        }
    }
}
