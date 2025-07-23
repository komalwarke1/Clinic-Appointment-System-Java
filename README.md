# Clinic-Appointment-System-Java

## Clinic Appointment Booking System (Java + MySQL)

A Java-based mini project that allows clinics to manage doctors, patients, and appointments using a simple console-based UI and JDBC-MySQL backend.

---

## ✅ Features:
- Add, view, and manage **doctors**
- Add, view, and manage **patients**
- Book, view, and delete **appointments**
- View appointments by **specific date**
- MySQL backend with **foreign key constraints**
- Full JDBC integration with prepared statements

---

## 🛠️ Technologies Used:
- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA
- Git & GitHub

---

## 🗄️ Database Schema:

- **Doctor** (`id`, `name`, `specialization`)
- **Patient** (`id`, `name`, `age`, `gender`)
- **Appointment** (`id`, `doctor_id`, `patient_id`, `date`, `time`)

---

## 🚀 How to Run:
1. Clone the repository  
2. Import into IntelliJ  
3. Set up your MySQL database and update DB credentials  
4. Run `Main.java`  
5. Interact with the system via console menu

---

## Folder Structure:
src/
├── DBConnection.java
├── Doctor.java
├── Patient.java
├── Appointment.java
└── Main.java
