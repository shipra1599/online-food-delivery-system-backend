# online-food-delivery-system-backend
This project is the backend for an Online Food Delivery System built using Java Spring Boot and a microservices architecture. It includes separate services for restaurants, menus, orders, and payments. Each service manages its own data and communicates with other services only when required.

## Microservices
### Restaurant Service
Handles restaurant details such as name, location, rating, and status.
### Menu Service
Manages menu items and uses Feign Client to validate restaurants.
### Order Service
Creates and manages customer orders and publishes events to Kafka.
### Payment Service
Consumes Kafka events and processes payments.

## Inter‑Service Communication
### Feign Client (Synchronous)
Used by Menu Service to call Restaurant Service.
### Kafka (Asynchronous)
Order Service publishes events, and Payment Service consumes them.
## ER Diagram
<img width="650" height="281" alt="image" src="https://github.com/user-attachments/assets/c9073494-12b9-4b28-90b2-a635b50f2cb6" />

