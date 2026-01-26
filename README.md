# KTTKPM_DHKTPM18C_22687721_ThanHoangThienThien_Week01
# Spring Boot RabbitMQ Project

## 1. Mục tiêu bài thực hành

* Hiểu và áp dụng mô hình **Event-driven Architecture** với RabbitMQ
* Xây dựng hệ thống **Producer – Consumer** độc lập giao tiếp qua Message Queue
* Áp dụng **Manual Acknowledgment** để kiểm soát xử lý message
* Cấu hình **Dead Letter Queue (DLQ)** nhằm xử lý message lỗi
* Thực hành triển khai hệ thống bằng **Docker Compose**

---

**KTTKPM_DHKTPM18C_22687721_ThanHoangThienThien**

## 2. Tính năng chính

### Producer

* **REST API**: `POST /send` để gửi message
* **Persistent Messages**: Message không bị mất khi RabbitMQ restart
* **JSON Serialization**: Tự động convert `Order` object sang JSON

### Consumer

* **Manual Acknowledgment**: Kiểm soát hoàn toàn việc ACK/NACK
* **Dead Letter Queue (DLQ)**: Message lỗi tự động chuyển sang DLQ
* **Validation**: Kiểm tra `orderId` trước khi xử lý
* **Processing Time**: Giả lập thời gian xử lý 3 giây

---

## 3. Hướng dẫn chạy Project

### 1. Build và Run với Docker Compose

```bash
cd KTTKPM_DHKTPM18C_22687721_ThanHoangThienThien
docker-compose up -d --build
```

### 2. Kiểm tra Logs

```bash
# Xem logs của tất cả services
docker-compose logs -f

# Xem logs từng service
docker-compose logs -f producer
docker-compose logs -f consumer
docker-compose logs -f rabbitmq

# Kiểm tra Consumer đã xử lý thành công chưa
docker logs consumer 2>&1 | Select-String "Process success" | Select-Object -Last 1
```

### 3. Test Producer API

#### Gửi message hợp lệ (xử lý thành công)

```bash
curl -X POST http://localhost:8080/send \
  -H "Content-Type: application/json" \
  -d '{"message": "Order #123", "orderId": "ORD-001"}'
```

**Response**:

```json
{
  "status": "sent",
  "dataSent": {
    "message": "Order #123",
    "orderId": "ORD-001",
    "timestamp": "2026-01-25T04:37:48.241944214"
  }
}
```

#### Gửi message không hợp lệ (sẽ vào DLQ)

```bash
curl -X POST http://localhost:8080/send \
  -H "Content-Type: application/json" \
  -d '{"message": "Invalid Order", "orderId": ""}'
```

---

## 4. Quản lý RabbitMQ

* **Management UI**: [http://localhost:15672](http://localhost:15672)
* **Username**: `user`
* **Password**: `password`

---

## 5. Troubleshooting

### 1. Port already allocated

```bash
# Tìm container đang chiếm port
docker ps -a | Select-String -Pattern "5672|rabbitmq"

# Stop và remove
docker stop rabbitmq-server spring-boot-app
docker rm rabbitmq rabbitmq-server spring-boot-app
```

### 2. Container không start được

```bash
# Xóa containers và volumes
docker-compose down -v

# Rebuild
docker-compose up -d --build
```

### 3. Producer không kết nối được RabbitMQ

* Kiểm tra RabbitMQ đã **healthy** chưa: `docker-compose ps`
* Xem logs: `docker-compose logs rabbitmq`

### 4. Consumer không nhận message

```bash
# Kiểm tra logs consumer
docker-compose logs consumer
```

* Vào RabbitMQ UI kiểm tra queue có message không: [http://localhost:15672](http://localhost:15672)

### 5. Message không vào DLQ

* Kiểm tra queue configuration có `x-dead-letter-exchange`
* Kiểm tra consumer có throw exception hay không

---

## 6. Stop Project

```bash
# Stop containers
docker-compose down

# Stop và xóa volumes
docker-compose down -v
```

---

## 7. Kiến trúc hệ thống

### Thành phần

* **Producer Service**: Nhận request từ client và gửi message vào RabbitMQ
* **RabbitMQ**: Trung gian truyền message, quản lý Queue và DLQ
* **Consumer Service**: Lắng nghe queue, validate và xử lý message

### Luồng xử lý

1. Client gửi HTTP POST `/send` đến Producer
2. Producer serialize `Order` object thành JSON và gửi vào Queue
3. RabbitMQ lưu message ở chế độ **persistent**
4. Consumer nhận message từ Queue
5. Consumer validate `orderId`

   * Hợp lệ → xử lý và ACK
   * Không hợp lệ → throw exception, message chuyển vào DLQ

---

## 8. Sơ đồ hệ thống (mô tả)

```
Client
   |
   | HTTP POST /send
   v
Producer Service
   |
   | Publish message (JSON)
   v
RabbitMQ Queue  -----> Dead Letter Queue (DLQ)
   |
   | Consume
   v
Consumer Service
```

---

## 9. Nhận xét – Đánh giá

### Ưu điểm

* Tách biệt rõ Producer và Consumer, dễ mở rộng
* Message không bị mất nhờ cơ chế persistent
* Xử lý lỗi hiệu quả với Dead Letter Queue
* Phù hợp cho hệ thống phân tán, tải lớn

### Hạn chế

* Cấu hình RabbitMQ và DLQ tương đối phức tạp với người mới
* Khó debug hơn so với kiến trúc synchronous

### Hướng phát triển

* Thêm retry mechanism cho message lỗi
* Áp dụng JWT để bảo mật Producer API
* Monitor hệ thống bằng Prometheus & Grafana
