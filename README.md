# Campus Course & Records Manager (CCRM)

CCRM is a console-based Java SE application designed for an educational institute to manage students, courses, enrollments, and records. It's a comprehensive demonstration of core and advanced Java SE features, Object-Oriented Programming (OOP) principles, and modern development practices.

---

##  How to Run the Project

### Prerequisites
* **Java Development Kit (JDK):** Version 11 or higher.
* **IDE (Optional):** An IDE like Eclipse, IntelliJ IDEA, or VS Code.
* **Git:** For cloning the repository.

### Steps
1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-link>
    cd CCRM
    ```
2.  **Compile the Code:**
    Navigate to the main project folder (`CCRM`) and run:
    ```bash
    javac -d bin src/edu/ccrm/main/MainMenu.java
    ```
3.  **Run the Application:**
    From the main project folder (`CCRM`), run:
    ```bash
    java -ea -cp bin edu.ccrm.main.MainMenu
    ```

---

##  Project Documentation

### 1. Evolution of Java (Brief Timeline)
* **1995:** Java 1.0 released by Sun Microsystems.
* **2004:** J2SE 5.0 (Tiger) released with major updates like generics and enums.
* **2014:** Java SE 8 released, introducing Lambda Expressions and the Stream API.
* **2018-Present:** Java moves to a faster, 6-month release cycle with Long-Term Support (LTS) versions.

### 2. Java Platform Editions: ME vs. SE vs. EE

| Feature           | Java ME (Micro Edition)                               | Java SE (Standard Edition)                            | Java EE (Enterprise Edition)                          |
| ----------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| **Target** | Resource-constrained devices (IoT).                   | Desktop, server, and console applications.            | Large-scale, distributed, enterprise applications.    |
| **Core API** | A subset of the Java SE API.                          | The core Java platform.                               | Builds on Java SE with additional enterprise APIs.    |
| **Typical Use** | Embedded systems.                                     | General-purpose programming (this project).           | Web servers, application servers, microservices.      |


### 3. Java Architecture: JDK, JRE, JVM

* **JVM (Java Virtual Machine):** An abstract machine that provides a runtime environment to execute Java bytecode.
* **JRE (Java Runtime Environment):** Includes the JVM and core libraries needed to *run* Java applications.
* **JDK (Java Development Kit):** A superset of the JRE that includes development tools like the compiler (`javac`) needed to *develop* Java applications.



---
##  Syllabus Topic to Code Mapping

| Topic/Concept                   | File(s) / Location                                                                    |
| ------------------------------- | ------------------------------------------------------------------------------------- |
| **OOP - Encapsulation** | `domain/Student.java` (private fields, public getters/setters)                        |
| **OOP - Inheritance** | `domain/Student.java` extends `domain/Person.java`                                    |
| **OOP - Abstraction** | `domain/Person.java` (abstract class with abstract methods)                           |
| **OOP - Polymorphism** | `service/TranscriptService.java` (uses `Person` reference for `Student`)              |
| **Design Pattern: Singleton** | `config/AppConfig.java`                                                               |
| **Design Pattern: Builder** | `domain/Course.java` (implemented via `CourseBuilder`)                                |
| **NIO.2 API (`Path`, `Files`)** | `io/BackupService.java`                                                               |
| **Streams API** | `service/CourseService.java` (for search/filter)                                      |
| **Lambdas & Functional I/F** | `util/Comparators.java`                                                               |
| **Recursion** | `util/RecursiveFileUtils.java`                                                        |
| **Custom Exceptions** | `exception/DuplicateEnrollmentException.java`                                         |

---

##  Sample Usage

1.  Run the application.
2.  Select `Data Utilities` -> `Import Data` to load sample CSV files.
3.  Select `Manage Students` -> `List All Students` to see the imported data.
4.  Use other menu options to test features like enrollment and transcript generation.
