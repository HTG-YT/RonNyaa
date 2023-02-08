version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":game-creation"))
    implementation(project(":models"))

    implementation("io.github.cdimascio:dotenv-java:2.3.2")
    implementation("net.dv8tion:JDA:5.0.0-beta.3") {
        exclude(module = "opus-java")
    }
    implementation("org.postgresql:postgresql:42.5.3")
    implementation("org.slf4j:slf4j-jdk14:2.0.6")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
