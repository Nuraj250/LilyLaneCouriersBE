# Lily Lane Couriers Service BackEnd Application

Before running the application, make sure to set the active profile to .dev for development purposes.
To run your Spring Boot project with a MongoDB database locally, follow these steps:

**Step 1: Install and Start MongoDB or Mysql**

**MONGODB**

1. Install MongoDB on your computer if you haven't already. You can download it from the official MongoDB website:
   [MongoDB Download Page](https://www.mongodb.com/try/download/community).

2. Start the MongoDB server by running the following command in your terminal or command prompt:

   ```
   mongod
   ```

   This command starts the MongoDB server locally, allowing your Spring Boot application to connect to it.

**MYSQL**

1. Install MySQL on your computer if you haven't already. You can download it from the official MySQL website: MySQL
   Downloads.

2. Start the MySQL server and create a database for your project. You can use a MySQL client like MySQL Workbench or the
   command line to do this.

**Step 2: Configure MongoDB Connection**

1. In your Spring Boot project, open the `application.properties` file to configure the MongoDB
   connection.

   Example `application.properties` configuration:

   ```properties
   # MongoDB Connection Settings
   spring.data.mongodb.host=localhost
   spring.data.mongodb.port=27017
   spring.data.mongodb.database=your-database-name
   ```

   Replace `your-database-name` with the name of your MongoDB database.

**MYSQL**

1. In your Spring Boot project, locate the application.properties or application.yml file, typically located in the
   src/main/resources directory.

2. Set up the database connection by providing your MySQL database information. Replace the placeholders with your
   database details:

application.properties:

   ```properties
   # MYSQL Connection Settings
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

**Step 3: Start Your Spring Boot Application**

1. In your project directory, navigate to the directory containing your Spring Boot application (where your main class
   is located).

2. Run the following command to start your Spring Boot application:

   ```
   ./mvnw spring-boot:run
   ```

   or

   ```
   mvn spring-boot:run
   ```

   This command will compile and start your Spring Boot application. It will connect to the MongoDB database using the
   configuration you provided in the `application.properties` or `application.yml` file.

3. You should see log messages indicating that your Spring Boot application is running and that it's connected to
   MongoDB.

With these steps completed, your Spring Boot application should be up and running, connected to your local MongoDB
database. You can now interact with your API and perform database operations using MongoDB.

**Step 4: Test Your API**

You can use tools like Postman or any API testing tool to test your Spring Boot API locally.
Your API endpoints should be accessible at http://localhost:8080 by default, assuming you haven't specified a different
port in your Spring Boot configuration.

Here are some example requests:

**To create a user**

- **Method:** POST
    - **URL:** http://localhost:8080/api/couriers/auth/signin
        - **Request Body (in JSON format):**
        ```json
        {
          "name": "--add user's name--",
          "username": "--add user's name for app use--",
          "email": "--add user's email--",
          "password": "--add user's password--"
        }
        ```

**To log in**

- **Method:** POST
    - **URL:** http://localhost:8080/api/couriers/auth/login
        - **Request Body (in JSON format):**
  ```json
  {
    "username": "--add user's saved name for app use--",
    "password": "--add user's  saved password--"
  }
  ```

Make sure to adjust the route paths and logic in your Spring Boot code based on the actual implementation of your API.
The default port is 8080, but if you've configured a different port, replace `localhost:8080` with the appropriate URL.

