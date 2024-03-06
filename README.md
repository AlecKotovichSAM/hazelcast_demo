# Hazelcast demo (JUST AN EXAMPLE!)

### Running locally

1. `docker-compose up -d`

2.  ```>docker-compose ps
    NAME                 IMAGE                               COMMAND                  SERVICE              CREATED              STATUS              PORTS
    hazelcast-server-1   hazelcast_demo-hazelcast-server-1   "/__cacert_entrypoin…"   hazelcast-server-1   About a minute ago   Up About a minute   0.0.0.0:8080->8080/tcp
    hazelcast-server-2   hazelcast_demo-hazelcast-server-2   "/__cacert_entrypoin…"   hazelcast-server-2   About a minute ago   Up About a minute   0.0.0.0:8081->8080/tcp
    hazelcast-server-3   hazelcast_demo-hazelcast-server-3   "/__cacert_entrypoin…"   hazelcast-server-3   About a minute ago   Up About a minute   0.0.0.0:8082->8080/tcp
    ```
3. POST http://localhost:8080/put?key=mykey1&value=myvalue1    
4. POST http://localhost:8080/put?key=mykey2&value=myvalue2
5. GET http://localhost:8081/get?key=mykey1
```
   myvalue1
   ```
6. GET http://localhost:8082/get
```json 
   {
   "mykey1": "myvalue1",
   "mykey2": "myvalue2"
   }
```
7. POST http://localhost:8082/put?key=mykey3&value=myvalue3
8. GET http://localhost:8081
```json
   {
   "mykey3": "myvalue3",
   "mykey1": "myvalue1",
   "mykey2": "myvalue2"
   }
```
