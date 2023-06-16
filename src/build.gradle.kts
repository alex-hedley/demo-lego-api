import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
//	id("org.openapi.generator") version "6.6.0"
}

group = "com.alex-hedley"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.jetbrains.kotlin:kotlin-stdlib")
//	implementation("javax.validation:validation-api:2.0.1.Final")
////	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
////	implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
////	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	implementation(kotlin("stdlib-jdk8"))
}

//val oasPackage = "com.alexhedley.brick"
//val oasSpecLocation = "src/main/resources/brick-spec.yaml"
//val oasGenOutputDir = project.layout.buildDirectory.dir("generated-oas")
//
//tasks.register("generateServer", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
//	input = project.file(oasSpecLocation).path
//	outputDir.set(oasGenOutputDir.get().toString())
//	modelPackage.set("$oasPackage.model")
//	apiPackage.set("$oasPackage.api")
//	packageName.set(oasPackage)
//	generatorName.set("kotlin-spring")
//	configOptions.set(
//		mapOf(
//			"dateLibrary" to "java8",
//			"interfaceOnly" to "true",
//			"useTags" to "true"
//		)
//	)
//}
//
//val clientOutput = project.layout.buildDirectory.dir("generated-oas-test")
//
//tasks.register("generateClient", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
//	input = project.file(oasSpecLocation).path
//	outputDir.set(clientOutput.get().toString())
//	modelPackage.set("$oasPackage.client.model")
//	apiPackage.set("$oasPackage.client.api")
//	packageName.set(oasPackage)
//	generatorName.set("kotlin")
//	configOptions.set(
//		mapOf(
//			"dateLibrary" to "java8",
//			"useTags" to "true"
//		)
//	)
//}
//
//sourceSets {
//	val main by getting
//	main.java.srcDir("${oasGenOutputDir.get()}/src/main/kotlin")
//	val test by getting
//	test.java.srcDir("${clientOutput.get()}/src/main/kotlin")
//}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
//	dependsOn("generateServer")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//kotlin {
//	jvmToolchain(11)
//}