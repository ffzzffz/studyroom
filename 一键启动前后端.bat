@echo off
chcp 65001 >nul
echo ========================================
echo   一键启动前后端项目
echo ========================================
echo.
echo [提示] 此脚本将同时启动：
echo   - 后端 (studyroom-java)  端口: 9999
echo   - 前端 (studyroom-vue)   端口: 8001
echo.
echo [注意] 需要同时打开两个命令行窗口
echo.
pause

cd /d "%~dp0"

echo.
echo ========================================
echo   步骤 1/2: 启动后端
echo ========================================
start "自习室后端 - Java Spring Boot" cmd /k "cd studyroom-java && echo [后端] 正在启动... && mvn spring-boot:run"

echo [等待] 给后端 5 秒启动时间...
timeout /t 5 /nobreak >nul

echo.
echo ========================================
echo   步骤 2/2: 启动前端
echo ========================================
start "自习室前端 - Vue.js" cmd /k "cd studyroom-vue && echo [前端] 正在启动... && npm run dev"

echo.
echo ========================================
echo   启动完成！
echo ========================================
echo.
echo [后端地址] http://localhost:9999/self-study
echo [前端地址] http://localhost:8001
echo.
echo [Swagger] http://localhost:9999/self-study/swagger-ui.html
echo [Druid]   http://localhost:9999/self-study/druid/
echo.
echo [提示] 已在新窗口中启动前后端项目
echo [提示] 等待启动完成后，访问前端地址: http://localhost:8001
echo [提示] 关闭那两个命令行窗口即可停止服务
echo.
pause

