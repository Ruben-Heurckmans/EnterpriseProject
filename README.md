# EnterpriseProject
Repo voor het project van enterprise project

## Teammembers
- Joppe Vanhelden
- Ruben Heurckmans

## Gekozen thema:
Voor dit project zijn we gegaan voor een basic restaurant review app. Hierbij kunnen gebruikers reviews achterlaten voor een restaurant. In die review kunnen ze afbeeldingen meegeven en deze worden dan ook gelinkt aan het restaurant.

## Microservices: 
- Restaurantservice:
  Service dat restaurant data bijhoudt. De data dat wordt bijgehouden is: id, restaurantCode, naam, straat, huisnummer, 
  plaats en postcode.
- Reviewservice:
  Service dat de review data bijhoudt. De data dat wordt bijgehouden is: id, reviewCode, userCode, imageCode en description
- Imageservice
  Service dat de data van de afbeeldingen bijhoudt. De data dat wordt bijgehouden is: id, imageCode, reviewCode,   
  restaurantCode en imageUrl.
  plaats en postcode.
- Userservice:
  Service dat user data bijhoudt. De data dat wordt bijgehouden is: id, userCode, naam, voornaam, straat, huisnummer, 
  plaats en postcode.

## Gateways:

## Schema:

## Screenshots endpoints:

### User
user/get/all -> lijst van alle users
![userGetAll](./screenshots/userGetAll.png)

user/get/user1 -> data van user1
![userGetAll](./screenshots/userGetUser1.png)

### Review
review/get/all -> lijst van alle reviews
![reviewGetAll](./screenshots/reviewGetAll.png)

review/get/rev1 -> data van rev1
![reviewGetRev1](./screenshots/reviewGetRev1.png)

review/add -> toevoegen van review
![reviewAdd](./screenshots/reviewAdd.png)

review/get/all -> lijst van alle reviews na toevoegen rev5
![reviewGetAll2](./screenshots/reviewGetAll2.png)

review/delete/rev1 -> deleten van rev1
![reviewDeleteRev1](./screenshots/reviewDeleteRev1.png)

review/get/all -> lijst van alle reviews na delete rev1
![reviewGetAll3](./screenshots/reviewGetAll3.png)

### Image

image/get/all -> lijst van alle images
![imageGetAll](./screenshots/imageGetAll.png)

image/get/img1 -> data van img1
![imageGetImg1](./screenshots/imageGetImg1.png)

### Restaurant

restaurant/add -> toevoegen van restaurant
![restaurantAdd](./screenshots/restaurantAdd.png)

restaurant/get/all -> lijst van alle restaurants
![restaurantGetAll](./screenshots/restaurantGetAll.png)

restaurant/update/resto5 -> data van img1
![restaurantUpdateResto5](./screenshots/restaurantUpdateResto5.png)


