# 📚 LAB03 - Design Patterns Implementation

## 👨‍🎓 Thông Tin Sinh Viên

* **Họ và Tên:** Thân Hoàng Thiên Thiên
* **MSSV:** 22687721
* **Học Kỳ:** HK2 (2025–2026)
* **Môn học:** KTTKPM - Kiến Trúc Thiết Kế Phần Mềm
* **Bài tập:** LAB03 - Ứng Dụng Design Patterns

---

# 🎯 Tổng Quan Dự Án

Lab03 là dự án thực hành nhằm áp dụng các **Design Patterns** trong Java để xây dựng hệ thống phần mềm có:

* Tính **mở rộng (scalable)**
* Dễ **bảo trì (maintainable)**
* Tuân thủ **SOLID principles**

Dự án gồm 4 phần chính:

1. Adapter Pattern
2. Composite Pattern
3. Observer Pattern
4. Library Management System (tích hợp nhiều pattern)

---

# 📁 Cấu Trúc Dự Án

```bash
.
├── adapter_pattern/
├── composite_pattern/
├── observer_pattern/
├── library_management_system/
└── docker-nginx/
```

---

# 🧩 1. Adapter Pattern (Structural)

## 📌 Mô tả

Adapter Pattern cho phép chuyển đổi interface của một lớp thành interface khác mà client mong đợi.

➡️ Giải quyết: **tương thích giữa các hệ thống khác nhau**

---

## 🏗️ Thành phần chính

* `JsonService` – Interface JSON
* `XmlService` – Interface XML
* `JsonToXmlAdapter` – Chuyển JSON → XML
* `XmlToJsonAdapter` – Chuyển XML → JSON

---

## ✅ Lợi ích

* Tái sử dụng code cũ
* Không cần sửa code gốc
* Giảm phụ thuộc giữa các module

---

# 🌳 2. Composite Pattern (Structural)

## 📌 Mô tả

Cho phép tổ chức object theo dạng **cây (tree structure)**.

➡️ Client xử lý **leaf và composite giống nhau**

---

## 🏗️ Thành phần chính

### File System:

* `FileComponent` – Interface chung
* `FileLeaf` – File
* `Folder` – Thư mục

### UI:

* `UIComponent` – Interface
* `Button` – Leaf
* `Panel` – Composite

---

## ✅ Lợi ích

* Quản lý cấu trúc phức tạp dễ dàng
* Tuân thủ Open/Closed Principle
* Code client đơn giản

---

# 🔔 3. Observer Pattern (Behavioral)

## 📌 Mô tả

Thiết lập quan hệ **1-nhiều (one-to-many)** giữa các object.

➡️ Khi Subject thay đổi → tất cả Observer được cập nhật

---

## 🏗️ Thành phần chính

* `Observer` – Interface nhận update
* `Subject` – Interface quản lý observers
* `Stock` – Subject
* `Investor` – Observer

---

## ✅ Lợi ích

* Loose coupling
* Hỗ trợ event-driven
* Dễ mở rộng

---

# 🏛️ 4. Library Management System

## 📌 Mô tả

Hệ thống quản lý thư viện tích hợp nhiều Design Pattern để mô phỏng hệ thống thực tế.

---

## 🧠 Các Design Pattern sử dụng

### 🔹 1. Singleton

* **Lớp:** `Library`
* **Mục đích:** Đảm bảo chỉ có 1 instance duy nhất

---

### 🔹 2. Factory

* **Lớp:** `BookFactory`
* **Tạo các loại sách:**

  * PhysicalBook
  * EBook
  * AudioBook

---

### 🔹 3. Strategy

* **Interface:** `SearchStrategy`
* **Triển khai:**

  * SearchByTitle
  * SearchByAuthor
  * SearchByGenre

➡️ Cho phép thay đổi thuật toán runtime

---

### 🔹 4. Observer

* **Listener:**

  * LibrarianListener
  * UserNotificationListener

➡️ Theo dõi sự kiện:

* Thêm sách
* Mượn sách
* Trả sách

---

### 🔹 5. Decorator

* **Chức năng mượn:**

  * SimpleBorrow
  * ExtendedTimeBorrow
  * SpecialVersionBorrow

➡️ Thêm tính năng động mà không cần subclass

---

## 🏗️ Cấu trúc chính

```bash
library_management_system/
├── model/
├── factory/
├── strategy/
├── observer/
├── decorator/
└── singleton/
```

---

## 📊 Mô hình dữ liệu

* **Book**: id, title, author, genre, available
* **User**: userId, name, email
* **BorrowRecord**: thông tin mượn/trả

---

## 🚀 Tính năng chính

* 📚 Quản lý sách
* 👤 Quản lý người dùng
* 🔄 Mượn / trả sách
* 🔔 Thông báo sự kiện
* 💰 Tính phí dịch vụ

---

# 📘 Tổng Hợp Design Patterns

| Pattern   | Loại       | Ứng dụng          | Mục đích          |
| --------- | ---------- | ----------------- | ----------------- |
| Adapter   | Structural | adapter_pattern   | Kết nối interface |
| Composite | Structural | composite_pattern | Cấu trúc cây      |
| Observer  | Behavioral | observer_pattern  | Thông báo         |
| Singleton | Creational | library_system    | Instance duy nhất |
| Factory   | Creational | library_system    | Tạo object        |
| Strategy  | Behavioral | library_system    | Chọn thuật toán   |
| Decorator | Structural | library_system    | Mở rộng chức năng |

---

# 🎯 Kết Luận

Dự án giúp nắm vững:

✅ Các Design Pattern phổ biến
✅ Cách áp dụng vào hệ thống thực tế
✅ Nguyên lý thiết kế phần mềm (SOLID)
✅ Tăng khả năng viết code chuyên nghiệp

---

# 🚀 Hướng Phát Triển

* Tích hợp REST API (Spring Boot)
* Kết nối database (MySQL, PostgreSQL)
* Áp dụng Docker để deploy
* Xây dựng UI frontend

---

# ⭐ Ghi chú

Đây là project học tập nhằm mục đích:

* Hiểu rõ Design Patterns
* Thực hành kiến trúc phần mềm

👉 Có thể mở rộng thành hệ thống thực tế trong tương lai.
