plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
}

allprojects {
    group = "com.project"
    version = "1.0.0"
}

subprojects {
    apply(plugin = "java-library")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
        withSourcesJar()
        withJavadocJar()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }
}
