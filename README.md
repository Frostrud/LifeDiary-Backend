# LifeDiary Backend
This is the backend server side for a showcase project for a website. The website is planned to be a Cloud storage site that supports documents and images. The user can create an account and login where they will have their own homescreen with one or more collections. These collections can store either a text document or an image.

The logic of the code follows a Model-Viewer-Controller pattern. It has model classes for entitites to be used in the DB and corresponding Controller classes to manipulate and/or send data to the viewer. The logic between the controller and the DB is handled in the Service classes and the repositories deal with queries to the DB.

The backend is currently not configured to connect to a DB, but rather uses a temporary local one with already added test data that is created on run. The temporary DB runs on port 8080 and can be accessed by localhost:8080

This repo is made to run with the accompanying frontend project located [at this repo](https://github.com/Frostrud/LifeDiary-Frontend).

## How to run
Download the project to your chosen folder.

Navigate to the project directory and run using Maven:

### `mvn spring-boot:run`

Access the functionality using the Frontend project.

