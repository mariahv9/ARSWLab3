# ARSWLab3

## Introduction to Spring and Configuration using annotations

## Part I - Basic workshop

To illustrate the use of the Spring framework, and the development environment for its use through Maven (and NetBeans), the configuration of a text analysis application will be made, which makes use of a grammar verifier that requires a spelling checker. The grammar checker will be injected, at the time of execution, with the spelling checker required (for now, there are two available: English and Spanish).
1. Open the project sources in NetBeans.
2. Review the Spring configuration file already included in the project (src / main / resources). It indicates that Spring will automatically search for the 'Beans' available in the indicated package.
3. Making use of the Spring configuration based on annotations mark with the annotations @Autowired and @Service the dependencies that must be injected, and the 'beans' candidates to be injected -respectively-:
* GrammarChecker will be a bean, which depends on something like 'SpellChecker'.

![Grammar](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/english.png)

* EnglishSpellChecker and SpanishSpellChecker are the two possible candidates to be injected. One must be selected, or another, but NOT both (there would be dependency resolution conflict). For now, have EnglishSpellChecker used. 

4. Make a test program, where an instance of GrammarChecker is created by Spring, and use it:

![English](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/english1.png)

## Part II

1. Modify the configuration with annotations so that the Bean 'GrammarChecker' now makes use of the SpanishSpellChecker class (so that GrammarChecker is injected with EnglishSpellChecker instead of SpanishSpellChecker.) Verify the new result.

![Grammar](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/spanish.png)
![Spanish](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/spanish1.png)
## Cinema Book System

## Description

In this exercise we will build a class model for the logical layer of an application that allows managing the sale of cinema tickets for a prestigious company.

![Diagram](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/CinemaClassDiagram.png)

## Part I 

1. Configure the application to work under a dependency injection scheme, as shown in the previous diagram. The above requires:
* Add the dependencies of Spring. 
* Add the Spring configuration. 
* Configure the application -by means of annotations- so that the persistence scheme is injected at the moment of creation of the 'CinemaServices' bean. 

2. Complete the getCinemaByName (), buyTicket (), and getFunctionsbyCinemaAndDate () operations. Implement everything required from the lower layers (for now, the available persistence scheme 'InMemoryCinemasPersistence') by adding the corresponding tests in 'InMemoryPersistenceTest'.

![name](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/byname.png)
![ticket](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/buyticket.png)
![function](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/functions.png)
![memory](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/memory.png)

3. For later queries, we want to implement two functionalities:
* A method 'getFunctionsbyCinemaAndDate' that allows to obtain all the functions of a certain cinema for a certain date. 

![function](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/functim.png)

* Allow the purchase or reservation of tickets for a certain position of chairs in the room through the 'buyTicket' method. 

![buy](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/ticm.png)

4. Make a program in which you create (through Spring) an instance of CinemaServices, and rectify the functionality of it: register cinemas, consult cinemas, obtain the functions of certain cinema, buy / book tickets, etc.
5. It is wanted that the consultations realize a filtering process of the films to exhibit, said filters look for to give him the facility to the user to see the most suitable films according to his necessity. Adjust the application (adding the abstractions and implementations that you consider) so that the CinemaServices class is injected with one of two possible 'filters' (or possible future filters). The use of more than one at a time is not contemplated:
* (A) Filtered by gender: Allows you to obtain only the list of the films of a certain genre (of a certain cinema and a certain date) (The genre enters by parameter). 
* (B) Filtering by availability: Allows you to obtain only the list of films that have more than x empty seats (of a certain cinema and a certain date) (The number of seats is entered per parameter).

![Filter](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/filter.png)

6. Add the corresponding tests to each of these filters, and test their operation in the test program, verifying that only by changing the position of the annotations -without changing anything else-, the program returns the list of films filtered in the manner (A ) or in the way (B).

![Test1](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/test1.png)
![Test2](https://github.com/mariahv9/ARSWLab3/blob/master/GRAMMAR-CHECKER/resources/test2.png)

## Construido con 

* [Java 8](https://www.java.com/es/about/whatis_java.jsp)
* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Reviewed

Diego Alfonso Prieto Torres

## Authors

* **Alan Yesid Marin Mendez** - [PurpleBooth](https://github.com/Elan-MarMEn)
* **Maria Fernanda Hernandez Vargas** - [PurpleBooth](https://github.com/mariahv9)


Students of Systems Engineering of Escuela Colombiana de Ingenieria Julio Garavito 
