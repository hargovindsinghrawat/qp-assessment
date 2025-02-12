# qp-assessment
 Grocery booking api

# How to test

Step 1: Setup Postman
Create a new Collection (e.g., "Grocery Booking API").
Configure Authentication for the collection:
Go to the Authorization tab.
Select Basic Auth.
Add credentials:
Admin: Username = admin, Password = admin
User: Username = user, Password = user

Step 2: Test Admin Endpoints:
1. Add a Grocery Item
Method: POST
URL: http://localhost:8080/admin/items
Headers:
Content-Type: application/json
Body (raw JSON):
{
  "name": "Apple",
  "price": 1.99,
  "inventory": 100
}
Expected Response (201 Created):
{
  "id": 1,
  "name": "Apple",
  "price": 1.99,
  "inventory": 100
}

2. View All Grocery Items
Method: GET
URL: http://localhost:8080/admin/items
Expected Response (200 OK):
[
  {
    "id": 1,
    "name": "Apple",
    "price": 1.99,
    "inventory": 100
  }
]

3. Update a Grocery Item
Method: PUT
URL: http://localhost:8080/admin/items/1
Body:
{
  "name": "Green Apple",
  "price": 2.99,
  "inventory": 50
}
Expected Response (200 OK):
{
  "id": 1,
  "name": "Green Apple",
  "price": 2.99,
  "inventory": 50
}

4. Delete a Grocery Item
Method: DELETE
URL: http://localhost:8080/admin/items/1
Expected Response: 204 No Content.

Step 3: Test User Endpoints
1. View Available Grocery Items
Method: GET
URL: http://localhost:8080/user/items
Expected Response (200 OK):
[
   {
    "id": 1,
    "name": "Green Apple",
    "price": 2.99
  }
]

2. Place an Order
Method: POST
URL: http://localhost:8080/user/orders
Body:
{
  "userId": 1,
  "items": [
    {
      "groceryItemId": 1,
      "quantity": 5
    }
  ]
}
Expected Response (201 Created):
{
  "id": 1,
  "userId": 1,
  "totalAmount": 14.95,
  "createdAt": "2023-10-01T12:00:00"
}
