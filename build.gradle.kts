allprojects {
    repositories {
        mavenCentral()
    }

    group = "com.github.htgazurex1212"
}

subprojects {
    apply(plugin = "java")

    tasks.withType<JavaCompile> {
        sourceCompatibility = "19"
        targetCompatibility = "19"
        options.encoding = "UTF-8"
    }
}
