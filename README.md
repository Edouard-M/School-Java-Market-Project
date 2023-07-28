# School Java Market Project
<img src="https://img.shields.io/badge/-Java-E61F24?style=flat&logo=Java&logoColor=ffffff"> <img src="https://img.shields.io/badge/-AWS database-FF9900?style=flat&logo=aws&logoColor=ffffff"> <img src="https://img.shields.io/badge/-SQL-03A6E4?style=flat&logo=SQL&logoColor=ffffff">

## Purpose

The aim of this project is to create a entire IT infrastructure of a Markeplace. For this reason the **app** will contain a **Client side** for shopping and a **Employee side** for maintenance and analytics.

The functionalities are:
* **Client Panel:**
  + Connecion to account
  + Account creation
  + Account management
  + Shopping by searching for items
  + Payement of the shopping list
* **Employee Panel:**
  + Records of all the Clients
  + Records of all the Employees
  + Analytics of the most and least purchased products

## Method used
Technologies used in this project:
* **Java**
* **AWS database**
* **SQL** (database requests)
* **Java Fx** (for UI)
* **MVC Pattern** (Model, View Controller) design pattern

## School
This was a School project for Java and Database courses
> Grade obtained: **19,5 / 20**

## Client side
### Story board:
![story-board-client](ressources/Client_Panel/story-board-client.png)

## Employee side
### Story board:
![story-board-employee](ressources/Employee_Panel/story-board-employee.png)

### Analytics overview:
In order to load faster and to not create frustrating white page transition for the user:

The loading of the differents analytics are **Threaded** (using differents CPU ressources) in order to load in parallel.

![analytics](ressources/Employee_Panel/stats.png)

## MVC Pattern
![MVC-pattern](ressources/Diagrams/MVC-pattern.png)

## Diagrams (UML)
### Controller:
![Controller-Diagram](ressources/Diagrams/Controller-Diagram.png)
### Model:
![Model-Diagram](ressources/Diagrams/Model-Diagram.png)
### View Client:
![View-Diagram-Client](ressources/Diagrams/View-Diagram-Client.png)
### View Employee:
![View-Diagram-Employee](ressources/Diagrams/View-Diagram-Employee.png)
