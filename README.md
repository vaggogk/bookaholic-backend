# Bookaholic 

Αυτό το project είναι ένα Personal Book Library System. Το σύστημα επιτρέπει στους χρήστες να διαχειρίζονται την προσωπική τους βιβλιοθήκη, να καταγράφουν την πρόοδό τους στην ανάγνωση, να κρατούν σημειώσεις καθώς και να τα βαθμολογούν.

## Τεχνολογίες

### Backend
- Java 17
- Spring Boot 3.5.6
- Spring Security με JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Spring doc OpenAPI (Swagger)
- JWT (JJWT)

### Frontend
*Το frontend αναπτύχθηκε με React τεχνολογία*

## Domain Model 

### Κύριες Οντότητες
- **User**: Χρήστες συστήματος (id, username, email, password, createdAt)
- **Book**: Βιβλία που ανήκουν στους χρήστες (id, title, author, publisher, pages, cost, readingStatus, reviewRating, notes, coverImage)

### Σχέσεις
- User 1 <-> N Book (Κάθε βιβλίο ανήκει σε έναν χρήστη)

## Προαπαιτούμενα

- Java 17 ή νεότερη
- MySQL 8.0 ή νεότερη
- Maven 3.6+
- Node.js (για frontend - προαιρετικά)

## Εγκατάσταση και Build

### 1. Clone το repository
```bash
git clone https://github.com/vaggogk/bookaholic-backend.git
