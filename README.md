# Microservice - Camel - Rest DSL - Archetype

## Camel Rest Dsl + Mybatis + mysql + Junit + Swagger

### Rest: Defined in camel context in Rest Dsl:

the next example create a rest service with the next path ../example/exampleGet

```
	<rest path="/example">
		<get uri="/exampleGet" produces="application/json">
			<to uri="direct:exampleGet"/>
		</get>
	</rest>
```

### Services: Defined in a RouterBuiler in Java DSL  

the following example creates a service that generates a log

```
	from("direct:exampleGet")
	  	.log("Example")
```

### Base Path http://0.0.0.0:8180/archetype

## Swagger

Swagger json data: http://0.0.0.0:8180/archetype/swagger
Swagger UI: http://0.0.0.0:8080/swagger-ui



