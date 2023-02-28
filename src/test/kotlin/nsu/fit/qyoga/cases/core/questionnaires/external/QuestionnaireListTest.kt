package nsu.fit.qyoga.cases.core.questionnaires.external

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import nsu.fit.qyoga.infra.QYogaAppTestBase
import nsu.fit.qyoga.infra.fixture.adminLoginRequest
import org.apache.http.HttpStatus
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class QuestionnaireListTest: QYogaAppTestBase() {
    @Test
    fun `QYoga should return html page on request questionnaires`() {
        Given {
            body(adminLoginRequest)
        } When {
            get("questionnaires")
        } Then {
            statusCode(HttpStatus.SC_OK)
        }
    }
}