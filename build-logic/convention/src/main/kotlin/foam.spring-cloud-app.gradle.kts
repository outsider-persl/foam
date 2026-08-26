plugins {
    id("foam.spring-boot-app")
}

// 预编译脚本插件中无法直接使用 libs 访问器，这里通过扩展读取同一个 catalog（gradle/libs.versions.toml）
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

// Spring Cloud 生态版本统一由 BOM 管理（Boot BOM 已由 foam.spring-boot-app 引入）
dependencyManagement {
    imports {
        mavenBom(libs.findLibrary("spring-cloud-dependencies").get().get().toString())
        mavenBom(libs.findLibrary("spring-cloud-alibaba-dependencies").get().get().toString())
    }
}
