# 自习室预约管理系统 - 后端

## 项目简介
这是一个基于 Spring Boot + MyBatis Plus 的自习室预约管理系统后端项目，包含管理后台和小程序接口。

## 技术栈
- Spring Boot 2.6.6
- MyBatis Plus 3.3.1
- MySQL 8.0
- Redis (可选)
- Druid 数据库连接池
- JWT 认证
- Apache Shiro (权限控制)

## 项目结构
```
studyroom-java/
├── src/main/java/com/selfstudy/
│   ├── Application.java                 # 主启动类
│   ├── common/                          # 公共模块
│   │   ├── annotation/                  # 自定义注解
│   │   ├── aspect/                      # 切面
│   │   ├── exception/                   # 异常类
│   │   ├── handler/                     # 全局异常处理
│   │   └── utils/                       # 工具类
│   ├── config/                          # 配置类
│   │   ├── CorsConfig.java             # 跨域配置
│   │   └── FilterConfig.java           # 过滤器配置
│   ├── modules/                         # 业务模块
│   │   ├── applet/                     # 小程序模块
│   │   │   ├── controller/             # 控制器
│   │   │   ├── entity/                 # 实体类
│   │   │   ├── dao/                    # 数据访问层
│   │   │   ├── service/                # 服务层
│   │   │   ├── vo/                     # 视图对象
│   │   │   ├── dto/                    # 数据传输对象
│   │   │   └── utils/                  # 工具类
│   │   └── sys/                        # 系统管理模块
│   │       ├── entity/                 # 实体类
│   │       ├── dao/                    # 数据访问层
│   │       └── service/                # 服务层
│   └── datasource/                      # 数据源配置
└── src/main/resources/
    ├── application.yml                  # 主配置文件
    ├── application-dev.yml              # 开发环境配置
    ├── mapper/                          # MyBatis XML映射文件
    │   ├── sys/                        # 系统模块映射
    │   └── applet/                     # 小程序模块映射
    └── logback-spring.xml              # 日志配置
```

## 快速开始

### 1. 环境要求
- JDK 1.8 或更高版本
- Maven 3.6+
- MySQL 8.0+
- Redis (可选，如果开启缓存功能)

### 2. 数据库配置
1. 创建数据库并导入 SQL 文件：
```bash
# 登录 MySQL
mysql -u root -p

# 执行 SQL 文件
source db.sql
```

2. 修改 `application-dev.yml` 中的数据库配置：
```yaml
spring:
  datasource:
    druid:
      url: jdbc:mysql://localhost:3306/study-room?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
      username: root
      password: 你的密码
```

### 3. 微信小程序配置
修改 `application.yml` 中的微信配置：
```yaml
applet:
  wechat:
    appid: 你的微信小程序APPID
    secret: 你的微信小程序SECRET
```

### 4. 运行项目

#### 方式一：使用 IDEA 运行
1. 用 IDEA 打开项目
2. 等待 Maven 依赖下载完成
3. 找到 `Application.java` 主类
4. 右键选择 `Run 'Application'`

#### 方式二：使用 Maven 命令运行
```bash
# 清理并编译
mvn clean install

# 运行
mvn spring-boot:run
```

#### 方式三：打包运行
```bash
# 打包
mvn clean package

# 运行 jar 包
java -jar target/studyroom.jar
```

### 5. 访问项目
- 项目启动后，访问地址：`http://localhost:9999/self-study`
- API 文档（如果启用 Swagger）：`http://localhost:9999/self-study/swagger-ui.html`

## 默认账号
- 管理员账号：admin
- 管理员密码：admin

## 配置说明

### 端口配置
在 `application.yml` 中修改：
```yaml
server:
  port: 9999  # 修改为你需要的端口
```

### Redis 配置
在 `application.yml` 中启用/禁用 Redis：
```yaml
spring:
  redis:
    open: true  # true 开启，false 关闭
    host: localhost
    port: 6379
    password: # Redis 密码
```

### JWT 配置
在 `application.yml` 中修改：
```yaml
applet:
  jwt:
    secret: f4e2e52034348f86b67cde581c0f9eb5  # JWT 加密秘钥
    expire: 604800  # token 有效期（秒），默认7天
```

## 常见问题

### 1. 启动时数据库连接失败
- 检查 MySQL 是否启动
- 检查数据库配置是否正确
- 确认数据库 `study-room` 是否已创建

### 2. Maven 依赖下载失败
- 检查网络连接
- 配置国内 Maven 镜像源（阿里云）
- 清理本地 Maven 仓库后重新下载

### 3. 端口被占用
- 修改 `application.yml` 中的端口号
- 或者关闭占用该端口的程序

## API 接口说明

### 小程序接口
- `/applet/login` - 用户登录
- `/applet/register` - 用户注册
- `/applet/wxlogin` - 微信登录
- `/applet/notice/*` - 公告相关接口

### 管理后台接口
- `/sys/*` - 系统管理相关接口

## 开发说明
- 所有接口统一返回格式为 R 对象
- 使用 JWT 进行用户认证
- 使用 MyBatis Plus 简化 CRUD 操作
- 统一异常处理
- 支持跨域请求

## 联系方式
如有问题，请联系：2891517520@qq.com

## 许可证
MIT License

