# 🐳 Docker Learning Project

Sinh vien: Thân Hoàng Thiên Thiên
MSSV: 22687721

## 📌 Giới thiệu

Dự án này bao gồm các bài tập thực hành từ cơ bản đến nâng cao về Docker, giúp bạn:

* Làm quen với các lệnh Docker phổ biến
* Hiểu cách build và chạy container
* Viết Dockerfile cho nhiều loại ứng dụng khác nhau
* Sử dụng các tính năng nâng cao như:

  * Volume
  * Network
  * Environment Variables
  * Multi-stage build

---

# 📚 Phần 1: Các Lệnh Cơ Bản Với Docker

| STT | Lệnh                                    | Mô tả                     |
| --- | --------------------------------------- | ------------------------- |
| 1   | `docker --version`                      | Kiểm tra phiên bản Docker |
| 2   | `docker run hello-world`                | Chạy container test       |
| 3   | `docker pull nginx`                     | Tải image nginx           |
| 4   | `docker images`                         | Liệt kê image             |
| 5   | `docker run -d nginx`                   | Chạy container nền        |
| 6   | `docker ps`                             | Xem container đang chạy   |
| 7   | `docker ps -a`                          | Xem tất cả container      |
| 8   | `docker logs <id>`                      | Xem log                   |
| 9   | `docker exec -it <id> /bin/sh`          | Truy cập container        |
| 10  | `docker stop <id>`                      | Dừng container            |
| 11  | `docker restart <id>`                   | Khởi động lại             |
| 12  | `docker rm <id>`                        | Xóa container             |
| 13  | `docker container prune`                | Xóa container dừng        |
| 14  | `docker rmi <id>`                       | Xóa image                 |
| 15  | `docker image prune -a`                 | Xóa image không dùng      |
| 16  | `docker run -p 8080:80 nginx`           | Map port                  |
| 17  | `docker inspect <id>`                   | Xem chi tiết              |
| 18  | `docker run -v mydata:/data nginx`      | Mount volume              |
| 19  | `docker volume ls`                      | Xem volume                |
| 20  | `docker volume prune`                   | Xóa volume                |
| 21  | `docker run --name my_nginx nginx`      | Đặt tên container         |
| 22  | `docker stats`                          | Xem tài nguyên            |
| 23  | `docker network ls`                     | Xem network               |
| 24  | `docker network create my_network`      | Tạo network               |
| 25  | `docker run --network my_network nginx` | Chạy trong network        |
| 26  | `docker network connect`                | Kết nối network           |
| 27  | `docker run -e KEY=value nginx`         | Biến môi trường           |
| 28  | `docker logs -f`                        | Log realtime              |
| 29  | Dockerfile cơ bản                       | FROM + COPY               |
| 30  | `docker build`                          | Build image               |
| 31  | `docker run`                            | Run image                 |

---

# 🛠️ Phần 2: Thực Hành Dockerfile

## 📁 Cấu trúc thư mục

```
.
├── bai01/  # Node.js
├── bai02/  # Flask
├── bai03/  # React
├── bai04/  # Nginx static
├── bai05/  # Golang
├── bai06/  # Multi-stage
├── bai07/  # ENV
├── bai08/  # PostgreSQL
├── bai09/  # Redis
├── bai10/  # PHP
└── docker-nginx/
```

---

## 🚀 Bài 1: Node.js

* Base image: `node:18`
* Port: `3000`

### Chạy:

```bash
docker build -t bai01 .
docker run -p 3000:3000 bai01
```

---

## 🐍 Bài 2: Flask

* Base image: `python:3.9`
* Port: `5000`

```bash
docker build -t bai02 .
docker run -p 5000:5000 bai02
```

---

## ⚛️ Bài 3: React

* Base image: `node:18-alpine`

```bash
docker build -t bai03 .
docker run -p 3000:3000 bai03
```

---

## 🌐 Bài 4: Nginx Static

* Base image: `nginx:latest`

```bash
docker build -t bai04 .
docker run -p 8080:80 bai04
```

---

## 🐹 Bài 5: Golang

```bash
docker build -t bai05 .
docker run -p 8080:8080 bai05
```

---

## 🔥 Bài 6: Multi-stage Build

* Giảm kích thước image
* Tách build và runtime

```bash
docker build -t bai06 .
docker run -p 3000:3000 bai06
```

---

## ⚙️ Bài 7: Environment Variables

```bash
docker build -t bai07 .
docker run bai07
```

---

## 🐘 Bài 8: PostgreSQL

```bash
docker build -t bai08 .
docker run -e POSTGRES_PASSWORD=123456 -p 5432:5432 bai08
```

---

## 🔴 Bài 9: Redis

```bash
docker build -t bai09 .
docker run -p 6379:6379 bai09
```

---

## 🐘 Bài 10: PHP + Apache

```bash
docker build -t bai10 .
docker run -p 8080:80 -v $(pwd):/var/www/html bai10
```

---

## 📦 Thư mục docker-nginx

Dùng để:

* Custom Nginx
* Serve static website

---

# 🎯 Kiến thức đạt được

Sau khi hoàn thành project, bạn sẽ:

✅ Hiểu Docker cơ bản
✅ Biết cách viết Dockerfile
✅ Biết build & run container
✅ Làm việc với:

* Volume
* Network
* ENV
  ✅ Tối ưu image với Multi-stage

---

# 🚀 Cách chạy nhanh toàn bộ project

```bash
cd bai01 && docker build -t bai01 . && docker run -p 3000:3000 bai01
```

---

# 📌 Yêu cầu hệ thống

* Docker Desktop
* Visual Studio Code

---

# 👨‍💻 Tác giả

* Docker Practice Project
* Mục tiêu: học và thực hành Docker từ cơ bản đến nâng cao

---

# ⭐ Gợi ý mở rộng

* Sử dụng Docker Compose
* Deploy lên VPS
* CI/CD với Docker
* Kubernetes cơ bản

---


