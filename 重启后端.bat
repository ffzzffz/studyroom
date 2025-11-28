@echo off
echo ====================================
echo 重启后端服务
echo ====================================

echo.
echo 正在停止端口 9999 上的服务...
for /f "tokens=5" %%a in ('netstat -ano ^| findstr :9999 ^| findstr LISTENING') do (
    echo 找到进程: %%a
    taskkill /F /PID %%a
)

echo.
echo 等待 3 秒...
timeout /t 3 /nobreak >nul

echo.
echo 正在启动后端服务...
cd /d "%~dp0studyroom-java"
start "后端服务" cmd /k "mvn spring-boot:run"

echo.
echo 后端服务正在启动，请等待...
echo 启动完成后，访问: http://localhost:9999/self-study
echo.
pause

