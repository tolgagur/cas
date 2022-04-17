
Swagger-UI : http://localhost:8080/swagger-ui.html#/

Postman API Documentation : https://documenter.getpostman.com/view/13362796/Uyr5oKEk

# A**uth Controller**

**POST /api/auth/login**

```
{
"password":"string",
"username":"string"
}
```

**POST /api/auth/signup**

```
{
"password":"string",
"username":"string"
}
```

**POST /api/auth/refresh/token**

```
{
"refreshToken":"string",
"username":"string"
}
```

**POST /api/auth/logout**

```
{
"refreshToken":"string",
"username":"string"
}
```

# File Controller

**POST /api/file**

```
{
  "customerId": Integer,
  "fileName": "string",
  "id": Integer
}
```

**GET /api/file/all**

**DELETE /api/file/deleteById/{id}**

**DELETE /api/file/deleteByName/{name}**

**PUT /api/file/update/{id}**

```
{
  "customerId": Integer,
  "fileName": "string",
  "id": Integer
}
```

# Customer Controller

**POST /api/file**

```
{
"customerId":Integer,
"fileName":"string",
"id":Integer
}
```

**GET /api/customer/all**

**DELETE /api/customer/deleteById/{id}**

**DELETE /api/customer/deleteByName/{name}**

**PUT /api/customer/update/{id}**

```
{
  "customerName": "string",
  "id": Integer,
  "info": "string"
}
```
