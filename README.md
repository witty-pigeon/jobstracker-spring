# Jobs Tracker (Spring version)

This is a small webapp that allows tracking of positions of interest.
This app uses Spring 4 and Hibernate 5

## Requirements
- Java 8
- A webapp container (e.g. Tomcat 8)
- A database to which you can connect (MySQL, PostgreSQL, ...)

## Setup

### 1.  git clone the repo

```sh
git clone https://github.com/witty-pigeon/jobstracker-spring.git
cd jobstracker-spring
```

### 2. configure the database parameters
  ```sh
    cp src/main/resources/config/hibernate-setup.example.properties \
    src/main/resources/config/hibernate-setup.properties
  ```
  Edit the file in
  `src/main/resources/config/hibernate-setup.properties`
  and adjust it to your needs.

### 3. create the WAR file and deploy it
```sh
mvn package
```

Deploy the `target/JobsTrackerSpring.war` on your webapp container

### 4. Run it
Access the app from your webapp container

E.g.
http://localhost:8080/JobsTrackerSpring/


## Licence

Apache License 2.0

(see LICENSE file)
