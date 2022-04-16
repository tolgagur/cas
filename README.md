
Swagger-UI : http://localhost:8080/swagger-ui.html#/
localhost:8080

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

**DELETE /api/file/delete/{id}**

**DELETE /api/file/delete/{name}**

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

**DELETE /api/customer/delete/{id}**

**DELETE /api/customer/delete/{name}**

**PUT /api/customer/update/{id}**

```
{
  "customerName": "string",
  "id": Integer,
  "info": "string"
}
```
