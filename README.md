# trade-systems

About Trade Systems : 

Trade System is an application which can get thousands of trades flowing in to trade store . While persisting the trade data , certain validations will be performed to keep sanity of the data.
Certain automated process will take care of daily updates on expired trades.

Considerations/assumptions made before build of Trade Systems:

Application has been built as a micro service .
Synchronous APIs to be called by consumers to send the trade data in the form of TradeStore  model object.
SOLID design principles have been adopted - Classes have been designed to handle single chain of responsibility , interface segregation , open close principle.
12 factors have been considered while design/implementation.
REST api internally will validate the data and persist in database if all validations are through - all these transactions/validations happen on same request thread . No parallel processing has been considered here while doing validations.
H2 in-memory database has been considered for persistent/retrieval of data.
TDD driven in the form of integrated test cases.
No Resource authentication.
No cache has been considered.

Design/Implementation /Tech Stack :

SOLID Design principles,12 factor app,Java 8 , Microservice using Spring Boot , Spring MVC , Spring Data using JPA, in-memory H2 database , synchronous blocking REST API , TDD approach .

6 test cases have been implemented to cover all possible scenarios and drive use cases in TDD approach.

Controller , Service , Persistence have been segregated as per responsibility segregation . Interface can be extended without breaking any existing contract supporting interface segregation.


Improvement:

To improve throughput - REST calls can be converted to NIO calls using webflux - event driven programming.
API Gateway - which can handle the throttling.
Discovery Services - For better API management between microservices and Load Balancing
In case synchronous response is not needed , entire trade store transaction can happen as event based where trade data can be pushed as messages into Kafka topic and separate consumer can be consume , validate and persist - more scalable solution.
Oauth2 can be introduced as separate resource which can authenticate calls for REST api based on token.
Unit Test cases can be made based on Mockito/Mock/MockBean/Spy .
Gherkin based feature files can be used to drive TDD approach where data can be stubbed inside feature or export from spreadsheet.






