@echo off
chcp 65001 >nul
echo ====================================
echo 快速推送代码到 GitHub
echo ====================================
echo.

cd /d "%~dp0"

echo 📊 当前修改状态：
echo ====================================
git status
echo.

set /p commit_msg="请输入提交说明 (直接回车使用默认): "
if "%commit_msg%"=="" set commit_msg=更新代码

echo.
echo ✅ 正在添加文件...
git add -A

echo.
echo ✅ 正在提交...
git commit -m "%commit_msg%"

echo.
echo ✅ 正在推送到 GitHub...
git push

echo.
if %errorlevel% equ 0 (
    echo ====================================
    echo ✅ 推送成功！
    echo ====================================
    echo.
    echo 在线查看: https://github.com/ffzzffz/studyroom
    echo 当前分支: main
) else (
    echo ====================================
    echo ❌ 推送失败！
    echo ====================================
    echo.
    echo 请检查网络连接或查看错误信息
)

echo.
pause

