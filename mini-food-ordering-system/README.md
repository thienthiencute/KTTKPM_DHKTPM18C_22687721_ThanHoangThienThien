# Mini Food Ordering System - Service-Based Architecture (Buoi 5)

## Services (Spring Boot)
- **User Service**: `backend/user-service/` (8081) - register/login/JWT/users
- **Food Service**: `backend/food-service/` (8082) - CRUD foods + seed data  
- **Order Service**: `backend/order-service/` (8083) - POST/GET orders (call user/food)
- **Payment Service**: `backend/payment-service/` (8084) - payments + notification

## Run (4 terminals)
```
cd backend/user-service && mvn spring-boot:run
cd backend/food-service && mvn spring-boot:run
cd backend/order-service && mvn spring-boot:run
cd backend/payment-service && mvn spring-boot:run
```

Frontend: `cd frontend && npm start` (3000)

## Test Flow
1. POST localhost:8081/api/auth/register → login
2. GET localhost:8082/api/foods → add cart
3. POST localhost:8083/api/orders → pay 8084/api/payments
4. Notification console.log Payment service ✅

**LAN: Thay localhost bằng 192.168.x.x trong services (RestTemplate URLs)**

**H2 Console:** localhost:8081/h2-console (JDBC: jdbc:h2:mem:userdb)

**Full spec Buoi 5 complete!**
