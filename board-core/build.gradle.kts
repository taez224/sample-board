plugins {
    id("java")
}

group = "com.sample"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":board-entity"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
