# inditex-catalogue

### Available endpoints
- List all prices by filter: http://localhost:8080/prices
  - You can filter by PriceFilter params. Currently, they are:
    - productId - brandId - date. All them mandatory
  - Eg:
    - http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14 18:30:00

- Evaluation tests
  - The five evaluation tests are available on
    - src/test/java/com/inditex/catalogue/adapter/controller/PriceRestControllerIntegrationTest.java

