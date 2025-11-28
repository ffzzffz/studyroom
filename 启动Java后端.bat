@echo off
echo ========================================
echo   启动 Java 后端项目 (studyroom-java)
echo ========================================
echo.

cd /d "%~dp0studyroom-java"

echo [1/2] 检查项目目录...
if not exist "pom.xml" (
    echo [错误] 找不到 pom.xml 文件！
    echo [提示] 请确保在正确的目录运行此脚本
    pause
    exit /b 1
)
echo [成功] 项目目录正确

echo.
echo [2/2] 启动 Spring Boot 应用...
echo [信息] 后端地址: http://localhost:9999/self-study
echo [信息] API 文档: http://localhost:9999/self-study/swagger-ui.html
echo [信息] 数据监控: http://localhost:9999/self-study/druid/
echo [信息] 按 Ctrl+C 停止服务器
echo.

call mvn spring-boot:run

if errorlevel 1 (
    echo.
    echo [错误] 启动失败！
    echo [建议] 请检查：
    echo   1. Maven 是否已安装并配置环境变量
    echo   2. JDK 是否已安装
    echo   3. MySQL 数据库是否已启动
    echo   4. 端口 9999 是否被占用
    pause
    exit /b 1
)

