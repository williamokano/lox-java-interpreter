plugins {
    id("java")
}

group = "okano.dev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("processLoxFile") {
    // Set the main class to be executed
    mainClass.set("okano.dev.lox.Lox")

    // Configure the classpath to include the project's runtime classpath
    classpath = sourceSets["main"].runtimeClasspath

    // Pass the file argument to the main class
    val inputFile = project.findProperty("file") as String? ?: ""
    args = listOf(inputFile)
}