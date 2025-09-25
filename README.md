# Campus Course & Records Manager
CCRM is a console-based Java SE application for an academic institution to manage students, courses, enrollments, and records. It's a complete showcase of basic and advanced Java SE capabilities, Object-Oriented Programming (OOP) principles, and current development tendencies.

---

## Running the Project

### Requirements
* **Java Development Kit (JDK):** Version 11 or higher.
* **IDE (Optional):** An Integrated Development Environment like Eclipse, IntelliJ IDEA, or VS Code.
* **Git:** To clone the repository.

### Steps
1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-link>
    cd CCRM
    ```
2.  **Compile the Code:**
    Navigate to the main project directory (`CCRM`) and run:
    ```bash
    javac -d bin src/edu/ccrm/main/MainMenu.java
```
```
3.  **Run the Application:**
In the project directory (`CCRM`), run:
    ```bash
    java -ea -cp bin edu.ccrm.main.MainMenu
    ```

---

##  Project Documentation

### 1. Evolution of Java (Brief Timeline)
* **1995:** Sun Microsystems releases Java 1.0.
* **2004:** Release of J2SE 5.0 (Tiger) with major changes like generics and enums.
* **2014:** Launch of Java SE 8 with Lambda Expressions and the Stream API.
* **2018-Present:** Java shifts to a quicker, 6-month release cycle with Long-Term Support (LTS) versions. 

### 2. Java Platform Editions: ME vs. SE vs. E

| Feature          | Java ME (Micro Edition)                               | Java SE (Standard Edition)                            | Java EE (Enterprise Edition)                          |
| ----------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| **Target** | Resource-constrained devices (IoT).                   | Desktop, server, and console applications.            | Large-scale, distributed, enterprise applications.    |
| **Core API** | A subset of the Java SE API.                          | The Java platform's core.                              | Extends Java SE with more enterprise APIs.            |
| **Common Use** | Embedded systems.                                     | General-purpose programming (this project).           | Web servers, application servers, microservices.      |


### 3. Java Architecture: JDK, JRE, JVM

* **JVM (Java Virtual Machine):** Virtual machine that offers a runtime environment to execute Java bytecode.
* **JRE (Java Runtime Environment):** Includes the JVM and core libraries necessary to *execute* Java applications.
* **JDK (Java Development Kit):** Superset of the JRE with development tools like the compiler (`javac`) necessary to *compile* Java applications.

---

## Syllabus Topic to Code Mapping

| Topic/Concept               | File(s) / Location                                                        |
| ------------------------------- | ------------------------------------------------------------------------------------- |
| **OOP - Encapsulation** | `domain/Student.java` (private fields, public getters/setters)                         |
| **OOP - Inheritance** | `domain/Student.java` extends `domain/Person.java`                                     |
| **OOP - Abstraction** | `domain/Person.java` (abstract class with abstract methods)                           |
| **OOP - Polymorphism** | `service/TranscriptService.java` (uses `Person` reference for `Student`)              |
| **Design Pattern: Singleton** | `config/AppConfig.java`                                                               |
| **Design Pattern: Builder** | `domain/Course.java` (Exposed through `CourseBuilder`)                              |
| **NIO.2 API (`Path`, `Files`)** | `io/BackupService.java`                                                               |
| **Streams API** | `service/CourseService.java` (for search/filter)                                      |
| **Lambdas & Functional I/F** | `util/Comparators.java`                                                               |
| **Recursion** | `util/RecursiveFileUtils.java`                                                    |
| **Custom Exceptions** | `exception/DuplicateEnrollmentException.java`                                         |

---

##  Sample Usage

1.  Run the application.
2.  Select `Data Utilities` -> `Import Data` to import sample CSVs.
3.  Select `Manage Students` -> `List All Students` to see the imported data.
4.  Use other menu options to play around with functions like enrollment and printing of transcripts.
