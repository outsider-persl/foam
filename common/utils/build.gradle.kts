plugins {
    id("foam.java-library")
}

dependencies {
    // 不对外传递：需要 core 类型的下游模块必须自行声明 project(":common:core")
    implementation(project(":common:core"))
    // 工具类外部依赖按需添加，版本统一在 gradle/libs.versions.toml 管理。
}
