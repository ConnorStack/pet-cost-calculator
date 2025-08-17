plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "personal.project"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

val netflixDgsVersion: String by extra("10.2.1")
val flywayVersion: String by extra("11.10.0")

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}
repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// flyway
	implementation("org.flywaydb:flyway-core:$flywayVersion")
	implementation("org.flywaydb:flyway-database-postgresql:$flywayVersion")

	// postgres
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:$netflixDgsVersion")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
