# Proyecto de Pasantías - Backend

Este es el repositorio para el proyecto de pasantías en el backend. El proyecto se centra en la creación de una API RESTful que se integra con una base de datos. El proyecto utiliza Chaos Monkey para mejorar la resiliencia del sistema.

## Ejecución

Para instalar el proyecto, se debe clonar el repositorio y construir el proyecto con el siguiente comando:

```bash 
./mvnw clean package
```

Posterior a ello  se ejecuta el siguiente comando para correr el proyecto:

```bash
./mvnw spring-boot:run
```

O se puede realizar ambas acciones en simultaneo con el siguiente comando:

```bash
./mvnw clean package spring-boot:run
```

Y por ultimo, para ejecutarlo en modo Chaos Engeenerin se de invocar de la siguiente manera
    
```bash 
./mvnw clean package spring-boot:run -Dspring-boot.run.profiles=chaos-monkey
```

## Autores
- Jose Amadeo Condori Ramos
- Cosette Adriana Guevara Rivera
- Edely Mireya Tito Loredo