TOURIST REST API - STS IMPORT INSTRUCTIONS

1. Extract tourist-api.zip to a folder.
2. Open Spring Tool Suite (STS).
3. Choose File > Import...
4. Choose Maven > Existing Maven Projects > Next.
5. Browse to the extracted tourist-api folder (the folder containing pom.xml).
6. Select the project and click Finish.
7. Wait for Maven dependencies to download.
8. Expand src/main/java > com.example.tourist.
9. Right-click TouristApiApplication.java > Run As > Spring Boot App.
10. The application uses port 8081.

Postman test:
Method: POST
URL: http://localhost:8081/api/tourists
Headers:
  Token: valid-token-123
  Content-Type: application/json
Body > raw > JSON:
{
  "name": "Jaswanth",
  "destination": "Goa",
  "country": "India"
}

Expected response: 200 OK, Tourist Created Successfully

Invalid/missing Token header returns 401 Unauthorized.

GET all saved tourists:
Method: GET
URL: http://localhost:8081/api/tourists

NOTE: The fixed token is only for a classroom demo; it is not real JWT signature validation.
The H2 database is in-memory and resets when the app stops.
Internet access is needed the first time Maven downloads dependencies.
