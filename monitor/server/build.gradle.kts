plugins {
    id("foam.spring-boot-app")
}

dependencies {
    // 版本均由 Spring Boot BOM 管理
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.micrometer.registry.prometheus)
}
