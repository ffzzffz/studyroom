@echo off
echo ========================================
echo 自习室预约管理系统 - 快速启动
echo ========================================
echo.
echo 正在启动项目...
echo 提示：首次启动可能需要下载依赖，请耐心等待
echo 访问地址：http://localhost:9999/self-study
echo Swagger文档：http://localhost:9999/self-study/swagger-ui.html
echo 健康检查：http://localhost:9999/self-study/applet/health
echo.
echo 按 Ctrl+C 可停止项目
echo.
call mvn spring-boot:run

