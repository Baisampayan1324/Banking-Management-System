
# **Banking Management System**

A Java-based application that simulates the core functionalities of an ATM. This project allows users to securely perform essential banking operations like deposits, withdrawals, balance inquiries, and transaction history management.

---

## **Features**
- **User Authentication**: Secure login system using account credentials (e.g., account number and PIN).
- **Balance Inquiry**: Check the current account balance.
- **Cash Deposit**: Deposit funds into the account.
- **Cash Withdrawal**: Withdraw money while ensuring sufficient balance.
- **Transaction History**: View a list of recent transactions.
- **Error Handling**: Handles invalid inputs, insufficient balances, and other exceptions to ensure smooth functionality.

---

## **Technologies Used**
- **Programming Language**: Java
- **Framework**: Swing (for GUI)
- **Database**: MySQL (via JDBC for database connectivity)

---

## **Setup Instructions**

### **1. Prerequisites**
- Install [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (Version 8 or later).
- Install [MySQL](https://dev.mysql.com/downloads/installer/) and set up a database server.
- Install an IDE like [Eclipse](https://www.eclipse.org/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/).

### **2. Clone the Repository**
```bash
git clone https://github.com/Baisampayan1324/banking-management-system.git
cd banking-management-system
```

### **3. Configure the Database**
1. Open MySQL and create a database:
   ```sql
   CREATE DATABASE banking_system;
   ```
2. Import the provided SQL file (if applicable) to set up tables and sample data:
   ```bash
   mysql -u your_username -p banking_system < banking_system.sql
   ```
3. Update the database credentials in the project code (e.g., in `DatabaseConnection.java`):
   ```java
   String url = "jdbc:mysql://localhost:3306/banking_system";
   String user = "your_username";
   String password = "your_password";
   ```

### **4. Run the Application**
1. Open the project in your IDE.
2. Compile and run the `Main.java` file to launch the application.

---
