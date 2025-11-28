@echo off
echo ========================================
echo 自习室预约管理系统 - 快速检查脚本
echo ========================================
echo.

echo [1/5] 检查 Java 环境...
java -version
if errorlevel 1 (
    echo [错误] 未检测到 Java 环境，请先安装 JDK 1.8+
    pause
    exit /b 1
)
echo [成功] Java 环境正常
echo.

echo [2/5] 检查 Maven 环境...
call mvn -version
if errorlevel 1 (
    echo [错误] 未检测到 Maven 环境，请先安装 Maven 3.6+
    pause
    exit /b 1
)
echo [成功] Maven 环境正常
echo.

echo [3/5] 清理项目...
call mvn clean
echo.

echo [4/5] 编译项目（跳过测试）...
call mvn compile -DskipTests
if errorlevel 1 (
    echo [错误] 项目编译失败，请检查错误信息
    pause
    exit /b 1
)
echo [成功] 项目编译成功
echo.

echo [5/5] 打包项目（跳过测试）...
call mvn package -DskipTests
if errorlevel 1 (
    echo [警告] 项目打包失败，但编译成功，可以尝试运行
) else (
    echo [成功] 项目打包成功
)
echo.

echo ========================================
echo 检查完成！
echo ========================================
echo.
echo 下一步：
echo 1. 确保 MySQL 已启动并创建了 study-room 数据库
echo 2. 修改 application-dev.yml 中的数据库配置
echo 3. 运行 db.sql 初始化数据库表
echo 4. 使用 IDEA 运行 Application.java 或执行: mvn spring-boot:run
echo.
pause

