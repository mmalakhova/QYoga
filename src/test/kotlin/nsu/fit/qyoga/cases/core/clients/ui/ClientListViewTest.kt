package nsu.fit.qyoga.cases.core.clients.ui

import io.github.ulfs.assertj.jsoup.Assertions
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import nsu.fit.qyoga.infra.QYogaAppTestBase
import nsu.fit.qyoga.infra.db.DbInitializer
import org.jsoup.Jsoup
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

const val CLIENTS_SEARCH_ENDPOINT = "/therapist/clients/search-cl"
const val DELETE_CLIENT_ENDPOINT_BASE = "/therapist/clients/delete/"

class ClientListViewTest : QYogaAppTestBase() {

    @Autowired
    lateinit var dbInitializer: DbInitializer

    @BeforeEach
    fun setupDb() {
        dbInitializer.executeScripts(
            "/db/clients-init-script.sql" to "dataSource",
            "/db/migration/demo/V23050904__insert_clients.sql" to "dataSource",
        )
    }

    @Test
    fun `QYoga returns client-search page with clients table`() {
        Given {
            authorized()
        } When {
            get("/therapist/clients")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#clientsTable") {
                    hasText(
                        "ФИО Петров Пётр Петрович Удалить Иванов Иван Иванович Удалить Сергеев Сергей Иванович Удалить"
                    )
                }
                node("#clients-list") {
                    hasText(
                        "Петров Пётр Петрович Удалить Иванов Иван Иванович Удалить Сергеев Сергей Иванович Удалить"
                    )
                }
                node("td") { hasText("Петров") }
                node("tr>td>button") {
                    attribute("hx-delete") { matchesText("$DELETE_CLIENT_ENDPOINT_BASE\\d+") }
                }

                node("form") {
                    attribute("hx-get") { hasText(CLIENTS_SEARCH_ENDPOINT) }
                }
            }
        }
    }

    @Test
    fun `QYoga returns clients-search page with input fields`() {
        Given {
            authorized()
        } When {
            get("/therapist/clients")
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#lastnameFilter") { exists() }
                node("#firstnameFilter") { exists() }
                node("#patronymicFilter") { exists() }
            }
        }
    }

    @Test
    fun `QYoga returns clients table with pagination`() {
        Given {
            authorized()
        } When {
            get(CLIENTS_SEARCH_ENDPOINT)
        } Then {
            val body = Jsoup.parse(extract().body().asString())
            Assertions.assertThatSpec(body) {
                node("#clientsTable") { exists() }
                node("#clients-list") { exists() }
                node("td") { exists() }
                node("#pagination") { exists() }
            }
        }
    }
}
