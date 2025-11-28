@echo off
chcp 65001 >nul
echo ========================================
echo   重新安装 Vue 前端依赖
echo ========================================
echo.
echo [修改] package.json 已更新
echo [变更] node-sass → sass (dart-sass)
echo [变更] sass-loader: 6.0.6 → 10.1.0
echo [优势] 无需编译，兼容所有 Node.js 版本
echo.

cd /d "%~dp0studyroom-vue"

echo ========================================
echo   步骤 1/3: 清理旧依赖
echo ========================================
echo.

if exist "node_modules" (
    echo [执行] 删除 node_modules 目录...
    rd /s /q node_modules
    if exist "node_modules" (
        echo [警告] 无法完全删除，部分文件可能被占用
        echo [提示] 请关闭 VS Code 或其他占用文件的程序
        pause
    ) else (
        echo [成功] 已删除旧依赖
    )
) else (
    echo [提示] node_modules 目录不存在，跳过
)

if exist "package-lock.json" (
    echo [执行] 删除 package-lock.json...
    del /f /q package-lock.json
    echo [成功] 已删除锁文件
)

echo.
echo ========================================
echo   步骤 2/3: 安装依赖
echo ========================================
echo.
echo [执行] 正在安装依赖...
echo [提示] 安装过程需要 3-5 分钟，请耐心等待...
echo [提示] 可能会看到一些警告信息，这是正常的
echo.

call npm install

if errorlevel 1 (
    echo.
    echo [错误] 安装失败！
    echo.
    echo [建议] 请检查：
    echo   1. 网络连接是否正常
    echo   2. npm 版本是否过高（建议使用 npm 6.x）
    echo   3. 是否有防火墙阻止下载
    echo.
    echo [备用方案] 尝试以下命令：
    echo   npm install --legacy-peer-deps
    echo.
    pause
    exit /b 1
)

echo.
echo [成功] 依赖安装完成！
echo.

echo ========================================
echo   步骤 3/3: 验证安装
echo ========================================
echo.

if exist "node_modules\sass" (
    echo [成功] sass 已安装
) else (
    echo [警告] sass 未找到
)

if exist "node_modules\sass-loader" (
    echo [成功] sass-loader 已安装
) else (
    echo [警告] sass-loader 未找到
)

if exist "node_modules\vue" (
    echo [成功] vue 已安装
) else (
    echo [警告] vue 未找到
)

echo.
echo ========================================
echo   安装完成！
echo ========================================
echo.
echo [提示] 现在可以运行以下命令启动项目：
echo   npm run dev
echo.
echo 或者双击：启动Vue前端.bat
echo.
pause

