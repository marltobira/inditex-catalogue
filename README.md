# inditex-catalogue

### Available endpoints
- List all prices: http://localhost:8080/prices
  - You can filter by PriceFilter params. Currently, they are:
    - productId - brandId - startDate - endDate
  - Eg:
    - http://localhost:8080/prices?productId=35455&brandId=1&endDate=2020-06-14 18:30:00
