plugins {
    id("foam.spring-boot-app")
}

dependencies {
    implementation(libs.spring.boot.starter.webmvc)
    implementation(project(":common:utils"))
     implementation(project(":common:core"))
}
