# Microservices architektúrájú gépjármű konfigurációs alkalmazás fejlesztése
A közelmúlt ígéretes új megközelítése a jól skálázódó, magas rendelkezésre állású rendszerek tervezéséhez a microservices architektúra. A hallgató feladata egy ilyen architektúrájú alkalmazás tervezése és fejlesztése. Az alkalmazás célja különböző gépjármű gyártók termékeinek kezelése, keresés és összehasonlítás támogatása.

A felhasználók az alkalmazás segítségével megadhatják milyen paraméterekkel keresnek járművet, ami alapján a rendszer találatokat mutat nekik. A korábbi keresések elmenthetők, ezekből statiszták készíthetők, a rendszer ajánlatokat adhat a felhasználói számára. 

Az alkalmazás fejlesztése során a hallgató megismeri a microservices alapú alkalmazások fejlesztésének, telepítésének és üzemeltetésének módszereit, melyeket a gyakorlatban is alkalmaz.

A munka során olyan új és innovatív technológiák kerülnek fehasználásra, melyek az adott architektúrális mintának megfelelő alkalamazások fejlesztését teszik lehetővé. Ilyen technológiák például a Spring keretrendszer, vagy a Docker. A hallgató a munka során ezen technológiák segítségével készíti el az alkalmazást, közben megismerve ezek jellemzőit és előnyeit.
A hallgató feladatának a következőkre kell kiterjednie:
- Valósítsa meg a kiválasztott alkalmazást microservices architektúra segítségével.
- Biztosítsa az alkalmazás komponenseinek horizontális skálázódását.
- Ismertesse a felhasznált elveket és architektúrális mintákat, térjen ki a meghozott
technikai döntések indoklására.

## User stories
|As a |I want |so that|
|:---|:---|:---|
|Visitor |filtering by parameters|I can search vehicles|
|Visitor |a comparator page|I can compare vehicles|
|User |everything *visitor* has | |
|User |login| I can save my searches|
|User |to make statistics from my saved searches| I can get recommendations|
|Manufacturer |admin page|I can add or edit my vehicles|
 
 ## Architektúra 
 ![final architecture](architektúra.jpg)
 
## Run and Verify

### 1. Go to the directory (:
```bash
D:
cd D:\Windows\Documents\Szakdolgozat\v2\car-searcher
```

### 2. Compile and package
```bash
mvn clean package
```

### 3. Start services
```bash
@echo off

start "api-gateway" java -jar api-gateway\target\api-gateway-0.0.1-SNAPSHOT.jar
start "vehicle-service" java -jar vehicle-service\target\vehicle-service-0.0.1-SNAPSHOT.jar
start "auth-server" java -jar auth-server\target\auth-server-0.0.1-SNAPSHOT.jar
pause
```

### Togerher....
```bash
D:
cd D:\Windows\Documents\Szakdolgozat\v1\car-searcher
mvn clean package
@echo off

start "api-gateway" java -jar api-gateway\target\api-gateway-0.0.1-SNAPSHOT.jar
start "vehicle-service" java -jar vehicle-service\target\vehicle-service-0.0.1-SNAPSHOT.jar
start "auth-server" java -jar auth-server\target\auth-server-0.0.1-SNAPSHOT.jar
pause
```

### [Authentication](https://github.com/TechPrimers/jwt-security-example)

This Project uses JWT to secure the REST endpoints.

The Following are the REST end points available in the example.
- `/auth-server/token` - Generates the JWT token based on the JSON sent. Its a POST method which expects the JSON: `{ "username": "name", "id": 123, "role": "admin"}` 
- `/rest/hello` - Requires a JWT Token with Header `key - "Authorisation"` and `value - "Token <JWT_Token>"`
