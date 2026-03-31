# 🐳 Docker Learning Project

Sinh viên: Thân Hoàng Thiên Thiên
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
| 16  | `docker run -d -p 8080:80 nginx`           | Map port                  |
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
docker build -t node_app .
docker run -d -p 3000:3000 node_app
```

---

## 🐍 Bài 2: Flask

* Base image: `python:3.9`
* Port: `5000`

```bash
docker build -t flask_app .
docker run -d -p 5000:5000 flask_app
```

---

## ⚛️ Bài 3: React

* Base image: `node:18-alpine`

```bash
docker build -t react_app .
docker run -d -p 3000:3000 react_app
```

---

## 🌐 Bài 4: Nginx Static

* Base image: `nginx:latest`

```bash
docker build -t my_nginx .
docker run -d -p 8080:80 my_nginx
```

---

## 🐹 Bài 5: Golang

```bash
docker build -t go_app .
docker run -d -p 8082:8080 go_app
```

---

## 🔥 Bài 6: Multi-stage Build

* Giảm kích thước image
* Tách build và runtime

```bash
docker build -t node_multi .
docker run -d -p 3003:3000 node_multi
```

---

## ⚙️ Bài 7: Environment Variables

```bash
docker build -t env_app .
docker run env_app
```

---

## 🐘 Bài 8: PostgreSQL

```bash
docker build -t postgres_custom .
docker exec -it <id> psql -U admin -d mydb
```

---

## 🔴 Bài 9: Redis

```bash
docker build -t redis_custom .
docker run -d -p 6379:6379 redis_custom
docker exec -it c55c8e656aae redis-cli
```

---

## 🐘 Bài 10: PHP + Apache

```bash
docker build -t php_app .
docker run -d -p 8085:80 -v ${PWD}:/var/www/html --name php_container php_app
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

# 🚀 Chạy nhanh một bài

```bash
cd bai01 docker build -t node_app . docker run -p 3000:3000 node_app
```

---

# 📌 Yêu cầu hệ thống

* Docker Desktop
* Visual Studio Code

---

# ⭐ Gợi ý mở rộng

* Sử dụng Docker Compose
* Deploy lên VPS
* CI/CD với Docker
* Kubernetes cơ bản

---


