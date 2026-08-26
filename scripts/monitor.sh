#!/usr/bin/env bash
# 按需开启 monitor 模块的构建入口。
# 用法：scripts/monitor.sh build   （等价于 FOAM_WITH_MONITOR=true ./gradlew build）
set -euo pipefail

FOAM_WITH_MONITOR=true exec ./gradlew "$@"
