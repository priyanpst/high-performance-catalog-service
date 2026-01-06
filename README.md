# 🚀 High-Performance Catalog Service

A specialized service demonstrating how to optimize read-heavy workloads using the **Cache-Aside Pattern**.

### ⚡ Performance Features:
- **Distributed Caching:** Uses **Redis** to cache frequently accessed product data, reducing MySQL load by up to 80%.
- **Declarative Caching:** Implements Spring's `@Cacheable` and `@CacheEvict` for clean, manageable caching logic.
- **Serialization:** Custom Redis serializers configured for seamless Java-to-JSON object mapping.

### 📊 Impact:
Designed to handle high-traffic spikes (like Sale Events) where direct database queries would cause a bottleneck.

### 🛠 Stack:
- Java 21, Spring Boot 3.3, Redis, MySQL, Spring Data JPA.
