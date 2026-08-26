pluginManagement {
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "foam"

include(
    "common:core",
    "common:utils",
    "biz:fool",
    "infra:gateway"
)

// monitor 默认不参与构建，按需开启：
//   ./gradlew -PwithMonitor ...              或  -PwithMonitor=true
//   scripts/monitor.sh ...                   或  FOAM_WITH_MONITOR=true ./gradlew ...
val withMonitor = providers.gradleProperty("withMonitor")
    .map { it.isEmpty() || it.toBoolean() }
    .orElse(false)
    .get() || System.getenv("FOAM_WITH_MONITOR") == "true"

if (withMonitor) {
    include("monitor:server")
}
