# ToDoList 
## Test

>### Create user
> ```
>>curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"username":"User", "password": "Pwd"}' http://localhost:8080/registration
> ```
>### Get auth token
> ```
>>curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"username":"User", "password": "Pwd"}' http://localhost:8080/auth
>```
>### Create first task
> ```
>> curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IlVzZXIiLCJleHAiOjE2NTI5MDc2MDB9.QVXaTNdvxCfRDOKgLe6qMxLAxemJcf5jvcQ7vuKzIEc" -X POST -d '{"description":"Do some"}' http://localhost:8080/task/create
>```
>### Create second task
> ```
>> curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IlVzZXIiLCJleHAiOjE2NTI5MDc2MDB9.QVXaTNdvxCfRDOKgLe6qMxLAxemJcf5jvcQ7vuKzIEc" -X POST -d '{"description":"Do some again"}' http://localhost:8080/task/create
>```
>### Get first task
> ```
>> curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IlVzZXIiLCJleHAiOjE2NTI5MDc2MDB9.QVXaTNdvxCfRDOKgLe6qMxLAxemJcf5jvcQ7vuKzIEc" -X GET -d http://localhost:8080/task/0
>```
>### Get list of tasks
> ```
>> curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IlVzZXIiLCJleHAiOjE2NTI5MDc2MDB9.QVXaTNdvxCfRDOKgLe6qMxLAxemJcf5jvcQ7vuKzIEc" -X GET -d http://localhost:8080/task/list
>```
>### Delete first task
> ```
>> curl -H "Accept: application/json" -H "Content-type: application/json" -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IlVzZXIiLCJleHAiOjE2NTI5MDc2MDB9.QVXaTNdvxCfRDOKgLe6qMxLAxemJcf5jvcQ7vuKzIEc" -X POST -d  http://localhost:8080/task/delete/0
> 