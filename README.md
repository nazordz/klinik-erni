# Project Klinki Erni
## Spesification
- [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Netbeans 12.04](https://netbeans.apache.org/download/nb124/nb124.html)
- [Maven 3.8.2](https://maven.apache.org/download.cgi)

## Installation
1. [Install MAVEN](https://maven.apache.org/install.html) - Please follow installation guide from this link!

    > Note: Make sure to add JDK & MAVEN to your PATH.
2. Import sql file into your database and then adjust it appropriate your database.
3. Change db configuration at hibernate config file, and Koneksi class.
4. Install the dependencies with maven.
    ```sh
    cd klinik-erni
    mvn install
    ```
5. Run it in your Netbeans
