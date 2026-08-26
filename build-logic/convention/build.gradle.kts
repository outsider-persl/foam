plugins {
    `kotlin-dsl`
}

dependencies {
    // Spring Boot Gradle 插件：约定插件按 id 应用它，模块侧无需再声明版本
    implementation(libs.spring.boot.gradle.plugin)
    // Boot 4 需要显式应用依赖管理插件，才会导入 Boot BOM
    implementation(libs.dependency.management.plugin)
}
