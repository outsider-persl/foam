# foam

多模块 Gradle 工程：公共库、业务服务、基础设施、监控组件。

## 模块结构

| 模块 | 说明 | 约定插件 |
|---|---|---|
| `common:core` | 公共地基，零外部依赖 | `foam.java-library` |
| `common:utils` | 工具类库，按需引入外部依赖 | `foam.java-library` |
| `biz:fool` | 业务服务 Demo（新业务服务的模板） | `foam.spring-boot-app` |
| `infra:gateway` | 网关（仅依赖、无逻辑，能启动即可） | `foam.spring-cloud-app` |
| `monitor:server` | 监控组件，默认不参与构建 | `foam.spring-boot-app` |

## 约定插件（build-logic）

- `foam.java-library`：Java 库配方（toolchain 25、JUnit 6 测试底座、统一 group/version），不引入任何 BOM。
- `foam.spring-boot-app`：Spring Boot 应用配方（Boot 插件自带依赖管理，版本由 BOM 决定）。
- `foam.spring-cloud-app`：Spring Cloud 应用配方（复用 spring-boot-app，并引入 Spring Cloud / Alibaba BOM）。

## 版本管理

所有依赖与插件坐标统一声明在 `gradle/libs.versions.toml`：

- 不带 `version.ref` 的库条目 = 交给 Spring Boot BOM 管理（仅限 Boot 应用模块）。
- 带 `version.ref` 的库条目 = 模块自己管理，版本写在 `[versions]`。
- 纯库模块没有 BOM，不带版本的依赖会解析失败，这是刻意的强制机制。
- 不要在 toml 中重复记录 BOM 已管理的版本值（micrometer、lombok、zipkin 等）。

## 新增业务服务（复制模板）

1. 复制 `biz/fool` 为 `biz/<name>`，把包名 `com.outsider.fool` 与应用名改成新服务名。
2. 在 `settings.gradle.kts` 的 `include(...)` 中加入 `"biz:<name>"`。
3. 按需声明依赖（模块间一律 `implementation`，用到 `common:core` 时显式声明）。

## 开启 monitor

```bash
./gradlew -PwithMonitor build          # 或 -PwithMonitor=true
scripts/monitor.sh build               # 或 FOAM_WITH_MONITOR=true ./gradlew build
```

默认不包含 monitor，保持构建最小化。

## 常用命令

```bash
./gradlew build
./gradlew clean build
./gradlew :biz:fool:bootRun
```
