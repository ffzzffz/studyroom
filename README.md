# 🎯 自习室座位管理系统

> 基于 Spring Boot + Vue.js 的自习室座位预约管理系统

[![GitHub stars](https://img.shields.io/github/stars/ffzzffz/studyroom.svg?style=social&label=Star)](https://github.com/ffzzffz/studyroom)
[![GitHub forks](https://img.shields.io/github/forks/ffzzffz/studyroom.svg?style=social&label=Fork)](https://github.com/ffzzffz/studyroom/fork)
[![GitHub license](https://img.shields.io/github/license/ffzzffz/studyroom.svg)](https://github.com/ffzzffz/studyroom/blob/master/LICENSE)

---

## 📖 项目简介

这是一个功能完善的自习室座位预约管理系统，支持管理后台、微信小程序等多端访问。系统采用前后端分离架构，提供座位管理、预约管理、公告管理等核心功能。

### ✨ 主要特性

- 🎨 **现代化界面** - 基于 Element UI 的美观管理后台
- 📱 **微信小程序** - 支持用户端小程序预约
- 🔐 **安全认证** - 集成 Shiro 安全框架
- 📊 **数据可视化** - 座位使用率、预约统计等图表展示
- 🚀 **前后端分离** - 独立部署，灵活扩展
- 📝 **完整文档** - 提供详细的部署和使用文档

---

## 🛠️ 技术栈

### 后端技术

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.6.6 | 核心框架 |
| MyBatis Plus | 3.3.1 | ORM 框架 |
| MySQL | 8.0+ | 数据库 |
| Redis | - | 缓存 |
| Shiro | 1.9.0 | 安全框架 |
| JWT | 0.7.0 | Token 认证 |
| Swagger | 2.7.0 | API 文档 |

### 前端技术

| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 2.5.16 | 前端框架 |
| Element UI | 2.8.2 | UI 组件库 |
| Axios | 0.17.1 | HTTP 客户端 |
| Webpack | 3.6.0 | 打包工具 |

---

## 📁 项目结构

```
studyroom/
├── docs/                    # 📚 项目文档
├── images/                  # 🖼️ 图片资源
├── scripts/                 # 🔧 脚本工具
├── studyroom-java/          # ☕ 后端项目（Spring Boot）
├── studyroom-vue/           # 🎨 前端项目（Vue.js）
├── studyroom-wx/            # 📱 微信小程序
└── README.md                # 📖 项目说明
```

**📘 详细结构说明：** [查看完整项目结构文档](项目结构说明.md)

### 核心目录说明

- **`docs/`** - 存放所有项目文档（使用指南、API 文档等）
- **`scripts/`** - 存放启动脚本和工具脚本
- **`studyroom-java/`** - Spring Boot 后端服务
  - `src/main/java/` - Java 源代码
  - `src/main/resources/` - 配置文件和资源
  - `db.sql` - 数据库初始化脚本
- **`studyroom-vue/`** - Vue.js 前端管理系统
  - `src/views/` - 页面组件
  - `src/components/` - 公共组件
  - `src/utils/` - 工具类
- **`studyroom-wx/`** - 微信小程序
  - `pages/` - 小程序页面
  - `components/` - 自定义组件

---

## 🚀 快速开始

### 环境要求

- **JDK**: 1.8+
- **Maven**: 3.6+
- **Node.js**: 14+
- **MySQL**: 8.0+
- **Redis**: (可选)

### 1️⃣ 克隆项目

```bash
git clone https://github.com/ffzzffz/studyroom.git
cd studyroom
```

### 2️⃣ 数据库配置

1. 创建数据库：
```sql
CREATE DATABASE self_study DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. 导入数据：
```bash
mysql -u root -p self_study < studyroom-java/db.sql
```

3. 修改配置文件 `studyroom-java/src/main/resources/application-dev.yml`：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/self_study?useUnicode=true&characterEncoding=UTF-8
    username: root
    password: your_password
```

### 3️⃣ 启动后端

```bash
cd studyroom-java
mvn spring-boot:run
```

后端服务将运行在：`http://localhost:9999/self-study`

### 4️⃣ 启动前端

```bash
cd studyroom-vue
npm install
npm run dev
```

前端服务将运行在：`http://localhost:8001`

### 5️⃣ 登录系统

访问：`http://localhost:8001`

默认账户：
- 用户名：`admin`
- 密码：`admin`

---

## 📊 功能模块

### 管理后台

- ✅ **系统管理**
  - 用户管理
  - 角色管理
  - 菜单管理
  - 日志管理

- ✅ **业务管理**
  - 座位管理
  - 预约管理
  - 公告管理
  - 消息管理

- ✅ **基础设置**
  - 楼层管理
  - 房间管理
  - 系统配置

### 微信小程序

- 座位浏览
- 在线预约
- 我的预约
- 公告查看

---

## 📸 系统截图

### 管理后台

![登录页面](images/login.jpg)
![首页](images/home.jpg)
![座位管理](images/seat.jpg)

### 微信小程序

![小程序首页](images/wx-home.jpg)
![座位预约](images/wx-booking.jpg)

---

## 🔧 开发指南

### 后端开发

1. **添加新模块**
   - 在 `modules` 包下创建新的模块
   - 遵循 MVC 分层架构
   - 使用 MyBatis Plus 简化 CRUD

2. **API 接口规范**
   - 使用 RESTful 风格
   - 统一返回格式（R 类）
   - 添加 Swagger 注解

### 前端开发

1. **添加新页面**
   - 在 `views` 目录创建 `.vue` 文件
   - 在 `router/index.js` 添加路由配置

2. **调用后端接口**
   - 使用 `this.$http` 封装的 Axios
   - 统一错误处理
   - 支持 Token 认证

---

## 📚 文档

### 📖 核心文档
- **[项目结构说明](项目结构说明.md)** - 完整的目录结构和文件说明
- **[快速使用指南](docs/快速使用指南.md)** - 快速上手教程
- **[登录信息](docs/登录信息.md)** - 默认账户和密码

### 🔧 开发文档
- [后端接口测试指南](studyroom-java/接口测试指南.md) - API 测试说明
- [项目启动完整指南](studyroom-java/项目启动完整指南.md) - 详细启动步骤

### 📦 部署文档
- [系统部署状态](docs/系统部署状态.md) - 部署状态说明
- [Git 推送指南](docs/Git推送指南.md) - Git 使用教程

---

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request！

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

---

## 📄 开源协议

本项目采用 MIT 协议开源，详见 [LICENSE](LICENSE) 文件。

---

## 👨‍💻 作者

[@ffzzffz](https://github.com/ffzzffz)

---

## 🙏 致谢

感谢以下开源项目：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org/)
- [Element UI](https://element.eleme.io/)
- [MyBatis Plus](https://baomidou.com/)

---

## 📞 联系方式

如有问题，欢迎通过以下方式联系：

- 📧 Email: [your-email@example.com](mailto:your-email@example.com)
- 💬 Issues: [GitHub Issues](https://github.com/ffzzffz/studyroom/issues)

---

<div align="center">

**如果这个项目对你有帮助，请给个 ⭐️ Star 支持一下！**

Made with ❤️ by ffzzffz

</div>

