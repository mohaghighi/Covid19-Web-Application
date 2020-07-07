# Covid-19 Data Analytic Microservices Application with Kubernetes and OpenShift

We have seen a range data published on the impact of various parameters on the spread of covid-19, including population density, average number of people per household, ethnicity, weather data etc.
Have you ever wanted to run your own analytics on covid-19 data, and examine data sets in order to draw a particular conclusion? Or possibly evaluate a theory, that may or not may not be true. Such analytics could potentially shed light on the impacts of various factors, and you can apply them to a variety of problems.   
Maybe you'd like to see the impact of temperature and humidity on the spread of covid-19 in different countries?  

teach you how to build, deploy and manage web applications with kubernetes and openshift.

Our workshop series is around covid-19 data retrieval, parsing and analytic. This is a series of 5 x hands-on workshops, teaching you how to retrieve covid-19 data from an authentic source, make them securely available through REST APIS on kubernetes and Openshift.  
The main parser application is written in Spring Boot, but we will add more features and apply analytical services on the data in the form of microservices written in different programming languages.  

Our application also comes with User Interface that connect to our parser and invokes the API endpoints to showcase the power of microservices running as conainers on Kubernetes and Openshift. 

You can use this application as a template for designing your own analytical microservices and deploy onto Kubernetes. 

This workshop series will be focused on: 

### Part 1: Overall architecture of the Parser and UI applications. 
### Part 2: Build your Microservice container with Docker. 
### Part 3: Deploy and manage your application with Kubernetes. 
### Part 4: Deploy and manage your application with managed OpenShift on IBM Cloud. 
### Part 5: Deploy and manage your application with CodeReady Containers. 
### Part 6: Build your CI/CD pipelines with Jenkins and Tekton. 
  
Here is what you will learn by the end of this workshop series:  
  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide2.jpeg)
--- 
## Part 1: Overall architecture of the Parser and UI applications. 

### Agenda
In this section you will learn:
- An overview of Covid-19 data analytic web application
- Quick summary
  - Data source & format
  - Data Parser
  - REST APIs endpoints

- Microservices
  - Why microservices?
  - Orchestration with Kubernetes
  
  
## Prerequisites

Spring Boot v2.2 - https://spring.io/guides/gs/spring-boot/ 

OpenJDK v11 - https://openjdk.java.net/install/ 

(Optional) Apache Netbeans IDE v12 - https://netbeans.apache.org/download/ 

Node.js v14 - https://nodejs.org/en/download/ 

Docker Latest - https://docs.docker.com/engine/install/ 

Minikube Latest - https://kubernetes.io/docs/tasks/tools/install-minikube/ 

CodeReady Containers - https://developers.redhat.com/products/codeready-containers 

(Optional) OpenShift v4.3 on IBM Cloud - https://www.ibm.com/cloud/openshift 


--- 
## Part 2: Build your Microservice container with Docker. 
  
### Agenda
In this section you will learn:
- Install/download prerequisites 
- Package Java Maven application
- Test Java application
- Docker
  - Dockerfile
  - Build Docker image
  - Run Docker containers
  - Use Kubernetes Docker daemon
  - Docker Registry 
  - SSH into Docker images
  - Connecting Docker containers
  - Inspect Docker Containers
  
  
### Clone The Repositories
```
git clone github.com/mohaghighi/covid19-web-application
git clone github.com/mohaghighi/covid19-UI
```
### Package Spring Boot with Maven

```bash
./mvnw clean install 
```
Run the jar file to test the Spring Boot application:
```bash
java -jar target/[filename].jar 
```
Data Parser runs on port 8082. if you want to change th *Port Number*, you need to edit ***"application.properties"*** file under src/main/java/resources/

```bash
curl http://localhost:8082 
```

#### What is a container? 
> Containers are executable units of software in which application code is packaged, along with its libraries and dependencies, in common ways so that they can be run anywhere, whether it be on desktop, traditional IT, or the cloud.

#### What is Docker?
> “Docker is the de facto standard to build and share containerized apps - from desktop, to the cloud”

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide32.jpeg)

#### Docker Image vs. Docker Container
> Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings. (only interacting with designated resources)

> Container ****<ins>images become containers at runtime</ins>**** and in the case of Docker containers - images become containers when they run on Docker.

#### What is a Dockerfile?
A set of build instructions to build the image in a file called "dockerfile". 
  
#### Craft your Dockerfile
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide36.jpeg)

In the case of our Data Parser Spring Boot application: 
```
FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

```
save the file as <ins>dockerfile</ins> with no file extension.

```bash
docker build -t [image name:v1] [path]
```
in this case, let's call it myapp:v1
```bash
docker build -t myapp:v1 .
```
let's take a look at our docker images: 
```
docker images
```
our image must be listed there.  
now let's a look at running containers: 
```
docker ps
```
if you add -al, you can view all running and stopped containers
```
docker ps -al 
```
Now let's go ahead and run our container:
```
docker run -p [PortHost:PortContainer] [imageName] -d --rm 
```
-d and --rm flags will respectively run the docker in detached, mode and replace an existing docker image of the same name with the name one.  
```
docker run -p 8082:8082 myapp:v1 -d --rm 
```


