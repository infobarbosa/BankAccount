### Comandos úteis:
```
mvn exec:java -Dexec.mainClass="com.github.infobarbosa.account.AccountApplication"
```


### Docker run
```
docker run -d -p 80:8080 infobarbosa/bankaccount:1.0

docker run infobarbosa/bankaccount:1.0 -p 8080:8080 -d
```

### Docker build
```
docker build -t infobarbosa/bankaccount:1.0 .
```
