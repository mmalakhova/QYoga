import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.7.20"
	kotlin("plugin.spring") version "1.7.20"
}

group = "nsu.fit"
version = "0.0.1-SNAPSHOT"
extra["testcontainersVersion"] = "1.17.4"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.webjars.npm:htmx.org:1.8.4")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.flywaydb:flyway-core")
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.5")





	api("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	testImplementation("io.rest-assured:rest-assured:5.2.0")
	testImplementation("io.rest-assured:kotlin-extensions:5.2.0")
	testImplementation("io.kotest:kotest-runner-junit5:5.5.0")
	testImplementation("io.kotest:kotest-assertions-core:5.5.0")

	runtimeOnly("org.postgresql:postgresql:42.5.0")

    modules {
        module("org.codehaus.groovy:groovy") {
            replacedBy("org.apache.groovy:groovy", "conflicts in current rest-assured version")
        }
        module("org.codehaus.groovy:groovy-xml") {
            replacedBy("org.apache.groovy:groovy-xml", "conflicts in current rest-assured version")
        }
    }
}

dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

