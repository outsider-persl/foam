plugins {
    `java-library`
}

// 预编译脚本插件中无法直接使用 libs 访问器，这里通过扩展读取同一个 catalog（gradle/libs.versions.toml）
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

group = "com.outsider"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    testImplementation(libs.findLibrary("junit-jupiter").get().get())
    testRuntimeOnly(libs.findLibrary("junit-platform-launcher").get().get())
}

tasks.withType<Test> {
    useJUnitPlatform()
}
