plugins {
    id("foam.spring-cloud-app")
}

dependencies {
    // 版本由 Spring Cloud BOM 管理
    implementation(libs.spring.cloud.starter.gateway.server.webflux)
    // 后续接入 Nacos 注册/配置时按需添加（版本由 Alibaba BOM 管理）：
    // implementation(libs.spring.cloud.starter.alibaba.nacos.discovery)
    // implementation(libs.spring.cloud.starter.alibaba.nacos.config)
}
