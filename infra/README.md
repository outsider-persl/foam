# infra

基础设施组件目录（如 gateway）。

| 模块 | 说明 | 约定插件 |
|---|---|---|
| `infra:gateway` | 网关（当前仅依赖，无业务逻辑，能启动即可） | `foam.spring-cloud-app` |

新增基础设施模块时：

- 普通 Spring Boot 服务应用 `foam.spring-boot-app`；
- 需要 Spring Cloud / Alibaba 生态的（如 gateway）应用 `foam.spring-cloud-app`；
- 版本统一在 `gradle/libs.versions.toml` 管理，BOM 由约定插件引入。
