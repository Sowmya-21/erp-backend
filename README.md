# 🚀 ERP System for Inventory & Sales Management

A full-stack Enterprise Resource Planning (ERP) backend system built using **Spring Boot**.  
This system manages products, customers, orders, inventory, suppliers, and invoices with secure authentication.

---

## 🔥 Features

- 📦 Product Management (CRUD)
- 👤 Customer Management
- 🛒 Sales Order Processing
- 📉 Inventory Management (Auto stock update)
- 🧾 Invoice Generation
- 🚚 Supplier & Purchase Order Flow (GRN)
- 🔐 JWT Authentication & Role-Based Access Control
- ⚠️ Global Exception Handling

---

## 🏗️ System Design Highlights

- Layered Architecture (Controller → Service → Repository)
- RESTful APIs
- Transaction Management using `@Transactional`
- Database: PostgreSQL
- Authentication: JWT (Stateless)
- Role-Based Authorization (ADMIN / USER)

---

## 🔐 Authentication

- Register/Login API
- JWT Token-based authentication
- Secure endpoints using Spring Security

---

## 📡 API Endpoints (Sample)

### Auth
- `POST /api/auth/register`
- `POST /api/auth/login`

### Products
- `GET /api/products`
- `POST /api/products`

### Orders
- `POST /api/orders`
- `GET /api/orders`

### Purchase / GRN
- `POST /api/purchase-orders`
- `POST /api/grns/{id}`

---

## 🧪 Testing

APIs tested using **Postman / Hoppscotch**

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

## 🚀 How to Run

```bash
git clone https://github.com/your-username/erp-backend.git
cd erp-backend
mvn spring-boot:run

📌 Future Improvements

Add React frontend dashboard

Dockerize application

Add caching (Redis)

Deploy on cloud (AWS)

👩‍💻 Author

Sowmya Kanaparthi
