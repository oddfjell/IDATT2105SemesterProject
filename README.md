# IDATTSemesterProject
>Group members:
> 
> Ann-Marie Revillard
>
> Emil Orvik Olsson
>
> Jonas Aleksander Mørkand
> 
The product is an e-commerce marketplace like web application where sellers can list their items and potential buyers can browse the items using various filter mechanisms, can add items into their favorite lists, and can check out and buy items!

## Technical requirements:  
- Clean CSS. No use of CSS frameworks like Tailwind  
- Spring Boot/REST based backend. Each endpoint should have proper authentication/authorization, for example based on JWT and Spring Security.  
- Database communication using plain JDBC or Spring JDBC / JPA   
- The solution should contain tests. The code coverage shall be at least 50%   
- The group should make sure to use CI/CD during development.   
- OWASP and universal design principles/techniques should be used in the project  
- Session storage can be used to provide short-lived login session on the frontend 5. Documentations requirements (for each module)  
- End points (API) must be documented, for example, using Swagger. Note, an explanation of what the endpoints do and what the different attributes are is required.     In addition, code must be documented as usual (javadoc).  
- System documentation is also a requirement., i.e., documentation that enables a new developer to quickly get the project up and running for testing and further       development (architecture sketches/class diagram). Instructions for how to run the project can preferably be done as a README file, while other documentation           should be as a PDF.  
- Test data that can be used while testing the app, for example, test user credentials, database credentials, etc.  
- The prerequisites must be documented if the project/module is dependent on other projects  

## Submission materials.   
- A zip file including all the modules/files  
- A runnable source code of each project/module. For example  
  - Properly documented Source and Test files.   
  - Configuration files like pom.xml (maven), package.json, Dockerfile, etc.   
  - Flyway or normal DB schema scripts with test data  
- Description of how to run tests and get the system running. This should be made easy (for the user) - as a script, docker/maven command or the like.  

## Product requirements / features  

> Take inspirations from the following sites or any other comparable sites you are aware of:
>> https://letsdeal.no/  
>> https://www.finn.no/   
  
The layout and design of user-interface elements such as screens is open-ended and it´s up to each individual group's creativity. However, UI screens should be designed such that they are mobile devices friendly in terms of size, pagination and scroll ability. In addition, the application shall have the following features. 

- Listing of items on the main page can be done in scrollable, paginated, and thumbnail (default) view or map view.   
  - A frontend shall have support for multiple sizes of item thumbnails such as full width, half-width, quarter-width, double-height, etc.   
  - The frontend should retrieve items from the backend using APIs  
  - The backend shall provide APIs for adding, getting, updating, deleting such items.   
  - The backend APIs should be documented with Swagger.  
- Listed items can be filtered based on, for example, categories, locations etc.  
- Items can be searched based on item descriptions, locations, categories etc.  
- An item can have the following properties – id, brief description, full description, category, location (latitude, longitude), price, etc.  
- Upon clicking an icon thumbnail or map marker, an item details page shall be shown. In item details page,  
  - Shall include information about the item such as item description, price, location, contact information of the seller and so on.   
  - Shall include pictures gallery of the related item.  
  - Shall allow the logged-in user to bookmark the item, for example by clicking the bookmark logo displayed on the top-right corner of the items page.  
  - Shall allow the logged-in user able to contact the user who posted the item, for example via message inbox/dialogue.  
- The application (frontend) supports internationalization, i.e., supports multiple languages based on language settings on the browser  
- Users shall be:   
  - able to register themselves,   
  - able to edit their profile including credentials  
- There will be two types of user roles  
  - Normal user - can list, buy/sell items, etc.  
  - Administrator – can add/update/modify categories, can do other administrative actions  
- A logged in user(s)  
  - can add new items, can update, delete, archive own listed items only  
  - can add items into their favorite or bookmarked list.  
  - can negotiate price on a listed item   
  - can buy an item listed by other users  
- The application shall have a main menu towards top of the screen with relevant menu items

## How to run the project

### Frontend
> cd frontend/vue-full-stack-project
> 
> npm install
> 
> npm run dev

### Backend
> cd backend/eCommerceMarketplace
> 
> mvn spring-boot:run

### Database
> The database used in this project is a student database
> that runs on NTNU's servers. The user should therefore not need to do anything
> with the database. Everything is already configured in:
> 
> backend/eCommerceMarketplace/src/main/resources/application.properties
> 
> If the user is interested in exploring the database with a GUI, they can visit https://mysqladmin.it.ntnu.no/
> and log in with:
> 
> username: emiloo_user1
> 
> password: password

### Swagger
> cd backend/eCommerceMarketplace
> 
> mvn spring-boot:run
>
> *go to http://localhost:8080/swagger-ui/index.html#/*
