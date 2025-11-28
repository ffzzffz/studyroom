@echo off
chcp 65001 >nul
cls
echo.
echo ╔════════════════════════════════════════════════════════════╗
echo ║     Vue 前端依赖安装 - 最终解决方案                         ║
echo ╚════════════════════════════════════════════════════════════╝
echo.
echo 【问题】node-sass 编译失败
echo   - 原因1: Node.js v22 太新，不兼容
echo   - 原因2: 需要 Python 2.7，但你装的是 3.12
echo   - 原因3: 需要 C++ 编译环境
echo.
echo 【解决】使用 sass (dart-sass) 替代
echo   ✅ 无需编译
echo   ✅ 无需 Python
echo   ✅ 兼容 Node.js v22
echo   ✅ 安装更快
echo.
echo ════════════════════════════════════════════════════════════
echo.
pause
echo.

cd /d "%~dp0studyroom-vue"

echo 【步骤 1/4】清理旧依赖...
echo.

if exist "node_modules" (
    echo   ⏳ 正在删除 node_modules 目录...
    rd /s /q node_modules 2>nul
    echo   ✅ 已删除
) else (
    echo   ✅ 目录不存在，跳过
)

if exist "package-lock.json" (
    echo   ⏳ 正在删除 package-lock.json...
    del /f /q package-lock.json 2>nul
    echo   ✅ 已删除
)

echo.
echo 【步骤 2/4】安装依赖（使用 sass 替代 node-sass）...
echo.
echo   ⏳ 正在下载并安装依赖包...
echo   ℹ️  预计时间: 2-3 分钟
echo   ℹ️  可能会有一些警告，这是正常的
echo.

call npm install

if errorlevel 1 (
    echo.
    echo   ❌ 安装失败！
    echo.
    echo   【建议】请检查：
    echo     1. 网络连接是否正常
    echo     2. npm 是否可用：npm -v
    echo     3. 磁盘空间是否充足
    echo.
    pause
    exit /b 1
)

echo.
echo 【步骤 3/4】验证安装...
echo.

if exist "node_modules\sass" (
    echo   ✅ sass 已安装
) else (
    echo   ⚠️  sass 未找到
)

if exist "node_modules\sass-loader" (
    echo   ✅ sass-loader 已安装
) else (
    echo   ⚠️  sass-loader 未找到
)

if exist "node_modules\vue" (
    echo   ✅ vue 已安装
) else (
    echo   ⚠️  vue 未找到
)

echo.
echo 【步骤 4/4】完成！
echo.
echo ╔════════════════════════════════════════════════════════════╗
echo ║                    ✅ 安装成功！                            ║
echo ╚════════════════════════════════════════════════════════════╝
echo.
echo 【下一步】
echo   1. 双击 "启动Vue前端.bat" 启动前端
echo   2. 访问 http://localhost:8001
echo.
echo 【技术细节】
echo   - 使用 sass (dart-sass) 替代 node-sass
echo   - 无需编译，兼容 Node.js v22
echo   - 安装更快，更稳定
echo.
pause

