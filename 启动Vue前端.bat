@echo off
echo ========================================
echo   启动 Vue 前端项目 (studyroom-vue)
echo ========================================
echo.

cd /d "%~dp0studyroom-vue"

echo [1/3] 检查 node_modules...
if not exist "node_modules" (
    echo [提示] 首次运行，正在安装依赖...
    echo [提示] 这可能需要几分钟时间...
    echo [提示] 使用 --legacy-peer-deps 解决依赖冲突...
    call npm install --legacy-peer-deps
    if errorlevel 1 (
        echo.
        echo [错误] 依赖安装失败！
        echo [建议] 请检查：
        echo   1. Node.js 是否已安装
        echo   2. npm 是否可用
        echo   3. 网络连接是否正常
        pause
        exit /b 1
    )
    echo [成功] 依赖安装完成！
    echo.
) else (
    echo [成功] 依赖已存在
)

echo.
echo [2/3] 启动开发服务器...
echo [信息] 前端地址: http://localhost:8001
echo [信息] 后端地址: http://localhost:9999/self-study
echo [信息] 按 Ctrl+C 停止服务器
echo.

call npm run dev

if errorlevel 1 (
    echo.
    echo [错误] 启动失败！
    pause
    exit /b 1
)

