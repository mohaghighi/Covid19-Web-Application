![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/intro.png)
# Covid-19 Data Analytic Microservices Application with Kubernetes and OpenShift

We have seen a range data published on the impact of various parameters on the spread of covid-19, including population density, average number of people per household, ethnicity, weather data etc.
Have you ever wanted to run your own analytics on covid-19 data, and examine data sets in order to draw a particular conclusion? Or possibly evaluate a theory, that may or not may not be true. Such analytics could potentially shed light on the impacts of various factors, and you can apply them to a variety of problems.   
Maybe you'd like to see the impact of temperature and humidity on the spread of covid-19 in different countries?  

This is a multipart workshop series on building, 
deploying and managing microservices applications with Kubernetes and openshift. 

Our workshop series is around covid-19 data retrieval, parsing and analytic. This is a series of 7 x hands-on workshops, teaching you how to retrieve covid-19 data from an authentic source, make them securely available through REST APIS on kubernetes and Openshift.  
The primary applications are developed in Java Spring Boot, but we will add more features and apply analytical services on the data in the form of microservices written in different programming languages. 

### Watch the full series on YouTube!


| [![Watch Part 1 on YouTube!](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part1-youtube.png)](https://youtu.be/80IaX6bNjQg)   | [![Watch Part 2 on YouTube!](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part2-youtube.png)](https://youtu.be/WczXDqxjNLQ)          |
| :-------------: |:-------------:|
| `40 Minutes` | `50 Minutes` |
| [![Watch Part 3 on YouTube!](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part3-youtube.png)](https://youtu.be/t8iKnYV3E94)     | [![Watch Part 4 on YouTube!](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part4-youtube.png)](https://youtu.be/MTXPUHbnvL0)    |
| `80 Minutes` | `125 Minutes` |
| [![Watch Part 5 on YouTube!](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part5-youtube.png)](https://youtu.be/Ok16HYkoKac)     | Coming Soon  |
| `45 Minutes` | `30 Minutes` |

We highly recomnmend that you follow the workshops by watching the videos as they are hands-on and much more comprehensive than the instructions given here. All videos are available from the links above or directly from this YouTube [playlist](https://www.youtube.com/playlist?list=PLKBDkjUynCxj_whjUozzjlKitYLzUQQfs)

In this workshop series, we will firstly take a look at the key features of our application and how it was developed in microsevices architecture. We'll then explore ways to contianerise our application with Docker. in Lab 3, We'll deploy and manage our application with Kubernetes. In Part 4, we'll deploy our application onto Openshift on IBM Cloud using OpenShift CLI tool and Web Console. In Lab 6, we'll set up a CodeReady Workspace to share an instance of workspace with others with ero configuration on the recipient side. In Lab 7, We'll build and test out application on a local version of Openshift Cluster, CodeReady containers. Finally, in part 8 we'll automate our CI/CD pipeline to push our code into production with zero downtime.

As a reminder, all the steps taught in this course are generic and applicable to 
application developed in any programming languages or platforms. but to simplify 
our journey and making it more use-case oriented, our course is designed around a 
covid-19 data analytic application. 

At the beginning of every part, we take a quick look at our application. This is to 
showcase the end result of what we do together in every part with respect the primary subject of each part.

Our application also comes with a frontend <User Interface>(https://github.com/mohaghighi/Covid19-UI.git) that connects to our parsers and invokes the API endpoints to display data and showcase the power of microservices running as conainers on Kubernetes and Openshift.  


This application has been designed as a template for designing your own analytical microservices and deploying onto Kubernetes. 

## Table Of Contents

This workshop series will be focused on: 

[Part 1: Cloud Native Development, Microservices and the Architecture of our Covid-19 Data Parser](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-1-cloud-native-development-microservices-and-the-architecture-of-our-covid-19-data-parser)  
[Part 2: Build your Microservice container with Docker](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-2-build-your-microservice-container-with-docker)  
[Part 3: Deploy and manage your application with Kubernetes](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-3-deploy-run-and-maange-your-docker-containers-with-kubernetes)  
[Part 4: Deploy and manage your application with OpenShift on IBM Cloud](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-4-build-deploy-and-manage-your-microservices-application-with-openshift)   
[Part 5: Build, Deploy and Share with CodeReady Workspaces](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-5-build-deploy-and-share-your-applications-with-codeready-workspaces)  
[Part 6: Build and Test your application with CodeReady Containers](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-6-build-and-test-your-applications-with-codeready-containers)  
[Part 7: Build your CI/CD pipelines with Jenkins and Tekton](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#part-7-build-your-cicd-pipelines-with-jenkins-and-tekton)  


Here is what you will learn by the end of this workshop series:  
  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide2.png)
--- 
## Part 1: Cloud Native Development, Microservices and the Architecture of our Covid-19 Data Parser  

<div align="center">
      <a href="https://youtu.be/80IaX6bNjQg">
         <img src="https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part1-youtube.png">
      </a>
</div>

### Agenda  

In this section you will learn:
- Introduction to this workshop series 
- Cloud Native Application Development
  - Advantages
- Microservices
  - Why microservices?
  - Monolithic Applications
- An overview of Covid-19 data analytic web application
  - Quick summary
  - Data source & format
  - Data Parser
  - REST APIs endpoints
- Application Demo  

Before we embark on this long journey together, you are probably interested to know who we are, and what we do? 
I head up IBM's developer ecosystems across Europe and fortunate to be working with an awesome team of developer advocates who are passionately 
engaging developers in various clients and open source communities all around the world!

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide2.png)

As developer advocates working for IBM, the pioneer of many technologies and inventions with a history of over a century, we have certain messages that we must get to the world as a whole, and that means to all developers all around the globe as much as possible using a special methodology known as IBM Developer Way: Code, Content, Community. check out https://www.ibm.com/opensource/story/ to learn more.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide3.png)

We do that by being out there speaking at various developer conferences, major tech events, digital 
channels and contributing to many open source projects.  At the same time, not only we do the 
outbound, but also the inbound. We have to be out there talking to users, who's got their hands on 
the technology, to get their feedback and pain points, and bring that information back to product 
management and engineering teams to better improve the product, so the user experience becomes vastly 
superior to what it was. So that combination of outbound and inbound activities defines who we are, and keeps us 
enthusiastic to make even better and deeper impact.  

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide4.png)

Our agenda for this workshop seroes, is literally ***The Pillars of Cloud-Native Development*** - and the ultimate 
goal of this series is to teach you: how to automate the entire application development process, so, 
you as a developer, only focus on coding and eventually let openshift take care of all the heavy-
lifting and tedious tasks.  
Or to put it in the developers' context, all you will need to do is **"Commit"** and **"Push"**.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide6.png)

Further to simplify our learning journey and make it use-case oriented, these workshops are 
designed around an application of a popular topic. Our application combines multiple containerised 
microservices for parsing covid-19 time-series data, for the number of positive cases and mortality 
rates in different countries and regions.So you get to experiment with a variety of tools and technologies around a use-case.

Here is a quck overview of our journey into the world cloud-native development: 

- In this introductory part, we'll learn about cloud native application development, the 
benefits of microservices architecture, and the motivations behind their vast adoption. 
We'll then take a quick tour of our covid-19 application and how it's been designed. 

- In part 2, you'll learn how to use Docker as the de-facto standard to containerise and 
test your applications.
- In part 3, you'll learn about containers orchestration, and how to deploy and scale 
your application on Kubernetes. -
- In Part 4, we'll experience how openshift simplifies and secures your orchestration tasks 
by automating the steps taken with Kubernetes. We'll firstly use the CLI tool to 
deploy and scale our built containers. And later use Openshift web console to deploy 
our application only using its source-code with a few clicks. That powerful feature for 
developers is called S2I or Source-to-image. 
- In Part 5, we'll explore how codeready workspaces helps teams build with speed, 
Agility, security and most notably code: in production from anywhere. 
- In part 6, you'll skip managed openshift, and instead use CodeReady Containers to 
build and test out your openshift deployment locally on your machine. 
- And finally, in Part 7, we will go even further with automation to set up CI/CD or 
continuous Integration and Continuous delivery to let openshift completely take care 
of the entire process from development to production. 

As I have mentioned earlier, every lab in this series focuses on an essential step for building cloud native microservices 
applications.  
Well, you may ask what is cloud native, how is that related to microservices, and more 
importantly why developers should educate themselves on those?

### Cloud Native 

Cloud native refers to how an application is built and deployed, rather than where the 
application resides.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide6.png)

It basically defines that the application must be built, delivered and operated in a way that 
the it is not hard-wired to any infrastructure.

When we speak with engineers and IT execs in the top firms in financial services, manufacturing, automotive, defence, medical, public services, 
etc, almost all of them host their development/production solutions in multiple clouds (private, public or hybrid). 

For those firms, seamless 
migration from one cloud platform to another, being able to update their solutions 
with the latest technology and innovation and scaling on demand, with zero-
downtime whilst maintaining the highest security measures at every level are their 
top priorities.
As you can see, those priorities are around the application itself rather than where it 
resides. And Cloud Native development provides all those benefits if implemented 
in the right way and using the right tools.
  
For application developers and IT execs, here are the key drivers in adopting cloud 
native application development:
- **Performance Improvement :** Improving application performance and Reducing application downtime and associated costs.
- **Flexibility and Speed :** Quicker development and roll-out of application enhancements/new features, Easier application management, Greater flexibility to 
scale app resources up or down automatically to meet real-time changes in demand.
- **Widespread Adoption :** Over half of new applications to be developed in the next year will be on cloud. Among current adopters of the model, 53 percent of applications are cloud-native.  

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide8.png)

But more importantly IT execs consider cloud-native app development as the key driver for cultural 
transformation for their tech teams:
•	Small teams own specific components of the overall application
•	Collaboration between application developers and IT operations experts
•	Continuously and centrally integrating source code updates across the team
•	A pipeline that deploys apps in development, test, staging and production environments

***Now how does cloud native development make those happen?*** By relying on microservices architecture.  

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide9.png)

Microservices architecture is the building block and most essential ingredient of cloud native 
applications.  
 
- A cloud native application consists of discrete, reusable components known as microservices that are designed to integrate into any cloud environment.  
In its core, the microservice architecture advocates partitioning large monolithic applications into smaller independent services that communicate with each other by using HTTP and messages.  

If you take look at the conversion of this monolithic business application into a number of Microservices according to their business capabilities, you'll notice several points:

- These microservices act as building blocks and are often packaged in containers.  
- Microservices work together as a whole to comprise an application, yet each can be independently scaled, continuously improved, and quickly iterated through automation and orchestration processes.  
- The flexibility of each microservice adds to the agility and continuous improvement of cloud-
native applications.  

### Monolithic Application

Before we dive deeper into microservices, let's take a look at the type of application 
Used to be developed in the traditional way or as we call it: ***Monolithic application***  


In the old days when agility, time to market and rapid application deployment 
weren't as vital as they are today, developers built a product, and add features to it 
over time. As new features were added, the application size grew bigger and bigger 
in size and complexity. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide11.png)

Applications were built to run on VMs, with a massive operating system, libraries, 
dependencies and a single database attached to the entire application. As demand 
grew higher, scaling the application was literally spinning up new VMs and adding more machine to the infrastructure. Different services in the monolithic 
applications were tightly integrated and failing one part of the application caused 
the entire application to become unresponsive or unusable for clients. 
Failures aside, when making updates, performing maintenance or adding a new 
service, the entire application must have been rebuilt and deployed again. 
 If new updates happened to cause the application 
to fail over time, the entire application had to brought down in order to fix the 
problem. Identifying and fixing the error was a tedious process and never 
guaranteed to succeed in a short amount of time.  

On the other hand, developers who worked on a project often had to program in the 
same programming language and use common platforms and tools to keep their 
individual parts compatible with others. 

Scaling a single part of monolithic application in most cases wasn't possible unless deployed on a separate VM. That required the entire application to be updated with additional resources for the entire application instead of individual services. 
That is not all.. Monolithic application also disrupted teamwork and prevented 
collaboration between developers and operation engineers. There always existed a 
massive tension between the two teams, pointing fingers every time something 
went wrong. Developers used to blame operation engineers for not having a 
thorough understanding of the architecture and causing their code to break, and 
operation engineers blamed devs for delivering something, which was not scalable, 
ready for production and demands too much underlying resources.

When you look at it from developers' perspective, they often spend their 
days building something new or debugging something that's broken, which is why 
they want a solution that simplifies the development process, making it faster and 
easier. The faster they can improve existing apps or find errors in the code, the 
more time they have to learn new skills.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide12.png)

The benefits of microservices - agility, shorter development time, flexibility - help 
developers build something more robust faster and with fewer problems. The 
challenge some developers face, though, whether due to the culture or ingrained 
processes within an organization, is making the shift to building in a microservices 
architecture.

And that's why we've designed this course for you to learn the essential knowledge 
to get started with Microservices, containerization and orchestration platforms.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/ExSlide/Slide13.png)

This is how our course is going to teach you the steps involved in cloud native development. 
I've already broken down the application into several Microservices --> off the slide -- 

Before we view the application, here is a quick summary of the architecture and 
components. 

  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide4.png)
Our application has been developed in Java and Spring Boot framework. It provides 
us with a number of API endpoints for retrieving covid-19 data per region, country, 
dates and periods. 
It comes with a number of containerised microservices, 
including 2 x data parsers for positive cases and mortality rates per country, and a User 
Interface for displaying data, as well as invoking those APIs through a number of sample 
functions. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/UI.png)

As you can see from the slide, data is fetched from Johns Hopkins University's repo (which is an authentic source of covid-19), and is stored in our local data repository.  
Here is a list of sample API endpoints as we'll test them out shortly. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide19.png)




## Prerequisites

Spring Boot v2.2 - https://spring.io/guides/gs/spring-boot/ 

OpenJDK v11 - https://openjdk.java.net/install/ 

(Optional) Apache Netbeans IDE v12 - https://netbeans.apache.org/download/ 

Node.js v14 - https://nodejs.org/en/download/ 

Docker Latest - https://docs.docker.com/engine/install/ 

Minikube Latest - https://kubernetes.io/docs/tasks/tools/install-minikube/ 

CodeReady Containers - https://developers.redhat.com/products/codeready-containers 

(Optional) OpenShift v4.3 on IBM Cloud - https://www.ibm.com/cloud/openshift 


By the end of this series, you'll have 4 x containerised microservices deployed and running on Kubernetes, OpenShift cluster, CodeReady Containers, CodeReady Workspaces. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide17.png)  

Those Microservices are:

- Data Parser written in Java. 
- UI frontend written in Java to generate HTML and Node.js. 
- Analytical application wrtittn in Python Flask.  
- Data Visulization application written in Node.js  



[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)  
--- 
## Part 2: Build your Microservice container with Docker.  

<div align="center">
      <a href="https://youtu.be/WczXDqxjNLQ">
         <img src="https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part2-youtube.png">
      </a>
</div>

Here's a quick look at what you're going to learn throughout this workshop series - 
and how Docker fits into our learning jouIn this lab you'll learn about containers, the basics of containerising microservices 
with Docker, how to run and connect docker containers and best practices for 
building docker images based on your application services' requirements.  

rney as a prerequisite for diving deep into Kubernetes and openshift.   
In this lab, we'll containerise our application's microservices with Docker, and in 
The next lab, we'll deploy and manage them with Kubernetes. Later we'll use 
openshift to automate the entire process of containerising, deployment, scaling and 
management with a few clicks from the openshift web console.  
  
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

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide26.png)
  
In the previous labs, we broke down our application into several microservices 
based on their functionalities and purposes, and in this lab we'll containerise them 
with Docker, and use docker to run them. 
Therefore, we convert our monolithic 
application into a multi-container application.
If you want to review how this application has been designed and how 
microservices architecture optimised it, please refer to the previous workshop. 

You may ask why Docker? 
Well, Modern application development and app modernisation techniques consist of three important stages of Build, Deploy and Manage.
Docker plays a vital role in the build stage, and even partially the deployment phase. 
As you can see from this slide, for stages we're going to follow in this workshop series, Docker is responsible for all initial steps. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide32.png)
  
Let's start by clining the repos and packaging our Java application with Maven:

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
Now we've ogot our application ready to be containerised with Docker. Before we dive deeper into Docker, let's explore what containers are and how docker fits in containerisation technology.  

#### What is a container? 
> Containers are executable units of software in which application code is packaged, along with its libraries and dependencies, in common ways so that they can be run anywhere, whether it be on desktop, traditional IT, or the cloud.

### What is Docker?
> “Docker is the de facto standard to build and share containerized apps - from desktop, to the cloud”
You may ask why Docker?  
Modern application development and app modernisation techniques consist of three important stages of Build, Deploy and Manage.
Docker plays a vital role in the build stage, and even partially the deployment phase. 
As you can see from this slide, for stages we're going to follow in this workshop series, Docker is responsible for all initial steps. 

### Technology vs. Toolkit
containers have been around for quite some time, and developers can create 
containers without Docker --  but Docker makes it easier, simpler, and safer to 
build, deploy, and manage containers. Docker is essentially the first toolkit that due 
to its simplicity, enabled all developers to build, deploy, run, update, and stop 
containers using simple commands and work-saving automation. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide35.png)

### Docker Image vs. Docker Container
> Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings. (only interacting with designated resources)

> Container ****<ins>images become containers at runtime</ins>**** and in the case of Docker containers - images become containers when they run on Docker.  

So let's get started and build our first container image with Docker. 
> The first step is to craft our dockerfile and the Dockerfile is essentially the build instructions to build the image. 



![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide36.png)
#### What is a Dockerfile?
A set of build instructions to build the image in a file called "dockerfile".  
#### Craft your Dockerfile
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide40.png)

The first part is the FROM command, which tells docker what image to base this off 
of. The FROM instruction sets the Base Image for subsequent instructions. It'll start 
by pulling an image from the Public Repositories.  

ARG defines instructions to define variables. ENV is similar to ENV but mainly meant 
to provide default values for your future environment variables. ARG values are not 
available after the image is built.  

The COPY instruction copies new files or directories from <src> and adds them to 
the filesystem of the container at the path <dest>.It can copy a file (in the same 
directory as the Dockerfile) to the container.  

The ADD instruction copies new files, directories or remote file URLs from <src> and 
adds them to the filesystem of the image at the path <dest>.  

The ENV instruction sets the environment variable <key> to the value <value>.  

This is what runs within the container at build time. The RUN instruction will 
execute any commands in a new layer on top of the current image and commit the 
results.  

An ENTRYPOINT allows you to configure a container that will run as an executable. 
[should add '&' to run in the background]

[Entry Point/CMD] ENTRYPOINT instruction allows you to configure a container that 
will run as an executable. It looks similar to CMD, because it also allows you to 
specify a command with parameters. The difference is ENTRYPOINT command 
and parameters are not ignored when Docker container runs with command line 
parameters.

The EXPOSE instruction informs Docker that the container listens on the specified 
network ports at runtime. The EXPOSE instruction does not actually publish the 
port. It functions as a type of documentation between the person who builds the 
image and the person who runs the container, about which ports are intended to be 
published.

In the case of our Data Parser Spring Boot application: 
```
FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

```
Dockerfile for Node.js application:
```
FROM node:12
COPY package*.json ./
RUN npm install
ENTRYPOINT [”node",”app.js"]
```
Dockerfile for Python application:
```
FROM python:3
COPY package.py ./
RUN pip install pystrich
ENTRYPOINT [”python",”./app.py"]
```
save the file as <ins>dockerfile</ins> with no file extension.

### Building Docker Image from the Dockerfile
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
Here's the command for running the docker container
```
docker run -p [PortHost:PortContainer] [imageName] -d --rm 
```
Now let's go ahead and run our container on port 8082:
```
docker run -p 8082:8082 myapp:v1 -d 
```
-d and --rm flags will respectively run the docker in detached, mode and replace an existing docker image of the same name with the name one.  
We can ping the application by invoking the /hello/ REST endpoint:
```
curl localhost:8082/hello/ 
```
#### Build and Run the UI App

The UI application can be retrieved from here:
<https://github.com/mohaghighi/Covid19-UI.git>

Now let's build the UI app and call it myui:v1
Dockerfile is the same as the one we used for Data Parser app but changing the name to ***"myui"***
```bash
docker build -t myui:v1 .
```
> in case you haven't run the maven build and packaged the UI App, run this where mvnm file is located
```
./mvnm clean install 
```
Now let's run the UI app on port 8081:
```
docker run -p 8082:8082 myapp:v1 -d 
```
Open your browser and navigate to 
```
localhost:8081
```
From the UI, click on connect on the top left hand corner and enter:
```
http://localhost:8082
```

As you may have seen, you got an error indicating that the server is not responding. 
There reason is, we can connect to containers directly thorugh Docker, but docker containers cannot discover or comunicate with each other.
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide45.png)

now let's try to ssh into our one of the docker containers and try to connect to the other one to identify the problem.
To simulate the issue that we've just expereinced with the UI app, let's ssh into our UI and try to connect to our data parser from within that container. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide46.png)

```docker exec [container name/ID] -it
```
Here how we ssh into UI app
```
docker exec -it myui:v1 /bin/bash 
```
Now let's connect from within the container and see if it works
```
curl localhost:8082/hello/ 
```
As you can see that doesn't work either.  
> containers need to be connected to the same network in order to communicate with each other

You can inspect your container to investigate the matter by looking for the network wihtin both containers.

```
docker inspect [container name]
```
As you can see our UI and Parser apps are not part of the same network. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide48.png)

Let's create a network and instruct our containers to connect to it
```docker network create test 
```
let's stop our docker containers:
```docker stop [container id]
```
Let's run our containers again, this time instructing them to join the new network we've just created
```docker run -p [PortHost:PortContainer] [imageName] --net=test
```
Run UI application on test network:
```docker run -p 8081:8081 myui:v1 --net=test
```
Run parser application on test network:
```docker run -p 8082:8082 myapp:v1 --net=test
```
Let's inspect our containers again and get their IP addresses based on thier new network
```docker inspect [container name/ID]
```

if we try to ping our applications again, they should work fine.  
Go ahead and connect to the parser form the UI app to verify that. 

In the next part we will be using minikube to spin up a single node kubernetes cluster. If we build all our images on your host docker machine, it'd be quite difficult to transfer your images from your host into minikube.  
one solution is to use minikube's docker daemon to build your docker images.  
> you need to set your environmental parameter to use miinkube docker. This command will let you do that:
```
eval $(minikube docker-env) 
```
This step is not needed here, is intended to let you know what we will use minikube's docker.
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide55.png)


[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)  
--- 
## Part 3: Deploy, Run and Maange your Docker Containers with Kubernetes.  
  
<div align="center">
      <a href="https://youtu.be/t8iKnYV3E94">
         <img src="https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part3-youtube.png">
      </a>
</div>  
  
### Agenda
In this section you will learn:
- Why Kubernetes
- Kubernetes concepts/components
- Deploy on Kubernetes 
  - Minikube
  - Pulling image from registry
  - Create deployment
  - Expose deployment
  - Create services
- Manage with Kubernetes
  - Replicasets
  - Rolling out updates
  - Autoscaling
---
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide60.png)

### Kubernetes

Kubernetes is Greek for helmsman or pilot, hence the helm in the Kubernetes logo. 
Imagine a ship full of containers like in this photo, and the helmsman is to make 
sure the ship sails smoothly through the oceans, and despite all the tides and 
waves, it makes it to the destination safely. the helmsman orders his crew to evenly 
distribute the containers around the ship in a way that, proper balance is struck, no 
one side is abnormally heavier, containers won't fall off, and the ship sails smoothly 
throughout the journey. 
Just like the helmsman, Kubernetes looks after a large number of containerised 
applications, by orchestrating them according to the load, and the available 
underlying resources, making sure our system achieves minimum zero downtime 
and our applications are always up and running. 
In the first and second labs we learned about the advantages and motivations for 
moving away from Monolithic applications and adopting microservices architecture. 

### Quick reminder about Microservices architecture 
Microservices architecture addresses all of the liabilities that are inherent in monolithic applications. 
microservices architecture allows

1. Different parts of our application to evolve on different timelines, 
2. They can be deployed separately, 
3. You choose your technology stack for each Microservice as it best fits the purpose, 
4. You can scale your services dynamically at runtime. Or let's say you can create individual instances of each individual service. 

But the most obvious advantage here is, if any part of the application fails, the whole application will not necessarily become unavailable/unresponsive to the customer, because they are not designed and operated as a single entity like in monolithic architecture.

### Microservices and Kubernetes

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide67.png)
In the previous labs, we broke down our application into several microservices and then containerised them with Docker and let docker run them. So we converted our application into a multi-container application in order to remove that single point of failure. But here 's the problem: Docker is running on a single host. 

### Moving from Docker to Kubernetes
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide69.png)

And here we discuss why we need a containers orchestration platform like 
Kubernetes when moving from development to production. 

a multi-container application must run on a multi-host environment in order to 
eliminate that single point of failure. If one host went down our orchestration tool 
can switch the load to another host. 
We need to be able to create new instances of our individual microservices 
containers to scale accordingly.
When one or more of our services need to be updated, or let's say we are adding a 
new service to our mix, the orchestration platform must be able to automatically 
schedule new deployments and create new instances of our containers with zero 
downtime. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide73.png)

Kubernetes scales and manages our containers according to the available 
underlying resources on the host. Docker has a good view of what's happening to 
our containers, but not our host machine.  
Last but not least, Kubernetes checks our container continually to make sure 
they're healthy, and in case of any failure, it'll take actions to reinstate our 
deployment, create new instances or restore the services.

### Understanding Deployment Scenario in Kubernetes
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide70.png)

Now let's take a look at a deployment scenario on a high level, how we are going to deploy our application onto Kubernetes.

We broke down our application, built docker containers, deploying each docker container will spin up a pod with its docker container in there. Based on our deployment scenario, and the load, each pod gets replicated (and that way we're making new instances of the docker containers) -these pods are inside a worker, which we are showing them for simplicity. so we first created a deployment, and then  scale our deployment accordingly. Next step is to create a service, which allows our applications communicate with each within the cluster and also exposes our application to the internet and external networks. If the service type is a load balancer, Traffic coming to our application will be directed to the pods accordingly through the load-balancer service.  

### Kubernetes Concepts/Resources:

**Pod**:Group of one or more containers with shared storage/network and a specification for how to run the containers in a shared context.
**Deployment**:A set of multiple, identical Pods with no unique identities. It runs multiple replicas of your application, and automatically replaces any failed instances. 
**Node**:A virtual or a physical machine with multiple pods, where Master node automatically handles scheduling the pods across the Worker nodes in the cluster. 
**Service**:An abstraction which defines a logical set of Pods and a policy by which to access them. Service enables external access to a set of Pods. 
**Label**:Labels are key/value pairs that are attached to objects, such as pods. 
**Namespace**:Logical isolation/partitioning of resources in kubernetes cluster. 
  
Now that we know the key components, let's revisit our deployment scenario, this 
time in more details to see what's happening under the hood.
### Deployment under the hood
Firstly, we'll use KUBECTL CLI tool to interact with Kubernetes cluster. The kubectl 
lets you control Kubernetes clusters and its resources. 
Think of kubectl as your magic keyword to instruct Kubernetes from your terminal. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide72.png)
  
### Kubernetes Features: 

- Automated rollouts and rollbacks
- Automatic scaling and load balancing
- Self-healing
- Service discovery 
- Storage orchestration

Automated rolling out changes to a deployment and the ability to pause, resume 
and rollback to previous version if needed. 
Automatic scaling and load balancing: When traffic to a container spikes, 
Kubernetes can employ load balancing and scaling to distribute it across the 
network to maintain stability. 
Self-healing: When a container fails, Kubernetes can restart or replace it 
automatically; it can also take down containers that don't meet your health-check 
requirements. 
Service discovery: Kubernetes can automatically expose a container to the internet 
or to other containers using a DNS name and IP address.  
And finally, provisioning local or cloud storage for your containers as needed. 

### Prerequisites:
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide76.png)
In this part we are going to use minikube to spin up a single-node kubernetes cluster locally.
Here's the link to minikube on your machine:
```
https://kubernetes.io/docs/tasks/tools/install-minikube/
```
### What is minikube?
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide77.png)

#### Spin up a Kubernetes cluster
```
minikube start 
```
#### Start minikube by limiting the resources' utilization
```
minikube start --memory=8192 --cpus=3 --kubernetes-version=v1.17.4 --vm-driver=virtualbox 
```
#### Get cluster information
```
kubectl cluster-info  
```
#### Get cluster configuration
```
kubectl config view 
```
### Useful commands thorugh this section:

#### Get the list of Pods
```
kubectl get pods 
```
#### Get the list of Deployments
```
kubectl get deployment  
```
#### Pause minikube
```
kubectl pause minikube 
```
#### Stop minikube
```
kubectl stop minikube  
```
#### Starting Kubernetes dashbaord
```
kubectl minikube dashboard
```

### set minikube docker daemon 
```
eval $(minikube docker-env)   
```
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide80.png)
#### Verify you're using minikube's docker by looking up the images
```
docker get images
```
### Useful Commands for Docker

#### Getting the list of containers
```
docker container List  
```
#### Getting running docker containers
```
docker ps  
```
### Deploying an Application

#### Creating deployment with an image
```
kubectl create deployment [label] --image= [Image Name]
```
#### Getting details on deployment
```
kubectl describe deployment/[deployment] 
```
#### Getting logs for deployment 
```
kubectl get events 
```
### Scaling Applications

#### creating instances of the application by setting the replicas

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide81.png)

#### Creating replicas and the processes under the hood

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide82.png)

#### Scale deployment and setting replicas

```
kubectl scale deployment [Deployment Name] --replicas=4
```
#### Enabling application to automatically scale 

```
kubectl autoscale deployment [deployment] --min=1 --max=8 --cpu-percent=80  
```
#### Getting Info on Horizontal Pod Autoscaler 
```
kubectl get hpa
```
### Exposing an application
```
kubectl expose deployment [deployment Name] [--port=8082 ]  --type=NodePort
```
#### Getting list of services
```
kubectl get services
```
#### Pinging the application
```
curl [Master IP]:[NodePort]/hello/ 
```
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide84.png)
#### ssh into kubernetes cluster to ping the pod from within the cluster
```
minikube ssh  
```
#### Ping the container 
```
curl [Pod IP]:[container port]/hello/  
```
### Different types of Services for exposing applications

**ClusterIP**: This default type exposes the service on a cluster-internal IP. You can reach the service only from within the cluster. 

**NodePort**: This type of service exposes the service on each node’s IP at a static port. A ClusterIP service is created automatically, and the NodePort service will route to it. From outside the cluster, you can contact the NodePort service by using “<NodeIP>:<NodePort>”.

**LoadBalancer**: This service type exposes the service externally using the load balancer of your cloud provider. The external load balancer routes to your NodePort and ClusterIP services, which are created automatically

### Different types of ports for accessing application from within the cluster, from outside the node and form outside the cluster.

**NodePort**: This setting makes the service visible outside the Kubernetes cluster by the node’s IP address and the port number declared in this property. The service also has to be of type NodePort (if this field isn’t specified, Kubernetes will allocate a node port automatically).

**Port**: Expose the service on the specified port internally within the cluster. That is, the service becomes visible on this port, and will send requests made to this port to the pods selected by the service.

**TargetPort**: This is the port on the pod that the request gets sent to. Your application needs to be listening for network requests on this port for the service to work.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide86.png)

### Exposing application with type LoadBalancer
```
kubectl expose deployment [deployment Name] [--port=8082 ] --type=LoadBalancer
```
#### Getting the Cluster-IP for the Kubernetes Cluster
```
kubectl cluster-info  
```
#### This command doesn't work as Minikube doesn't allocate the external IP address
```
curl [LoadBalancer External IP]:[Node Port]/hello/ 
```
(minikube is a single node cluster. therefore its IP address is the same node IP)
#### Pinging the container using minikube cluster IP instead worker node IP and NodePort
```
curl [kubernetes Cluster-IP]:[Node Port]/hello/ 
```
#### Now let's try to access the pod from within the cluster
```
minikube ssh 
```
#### Using the Load Balancer IP and container Port
```
curl [LoadBalancer Cluster IP(internal)]:[Port]/hello/ 
```

### Rolling out updates

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide91.png)

Rolling updates allow Deployments' update to take place with zero downtime by incrementally updating Pods instances with new ones. Performing updates without affecting application availability.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide139.png)

In this part we're going to update our image to the parser for covid-19 mortality data, which reflects the number of death in every country country and region.  
```
kubectl set image deployment/[deployment name]  [container]=[new image]
```

Make sure you use the container name in the above command to update the image in it. 
To get the container name, use: 
```
kubectl get deployment -o wide
```
verify the deployment is updated by pinging the app
```
curl ip:port/hello/
curl ip:port/get/country/data/germany/
```

To rollback to the previous version use:
```
kubectl rollout undo deployment/[deployment Name] 
```
optional: You can add --to-revision=n in order to rollback to a specific verison
```
kubectl rollout undo deployment/[deployment Name] --to-revision=2
```
checkout the rollout status 
```
kubectl rollout status deployment/[deployment Name]
```
### What is YAML?
YAML is a human-readable, data serialization standard for specifying configuration-type information. 
YAML can be used for common use cases such as:

- Configuration files
- Inter-process messaging
- Cross-language data sharing

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide95.png)

Kubernetes resources are represented as objects and can be expressed in **YAML** or **JSON** format
Examples: 
Print deployment as Yaml
```
kubectl get deployment –o yaml [json]
```
Print services as Yaml
```
kubectl get services –o yaml
```
## Using YAML to create resources 
  
A sample YAML file to create a ***Pod*** with a specific container from the specified image  (i.e. my-app:v2) listening on Port 80:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide97.png)  
A sample YAML file to create a ***Deployment*** with 2 replicas:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide98.png)  
A sample YAML to create a NodePort ***Service*** and letting Kubernetes asign the ports automatically by leaving the ports config blank  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide99.png)  
A sample YAML to create ***Replicaset*** with 3 Replicas  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide100.png)  
A sample YAML to update the ***Replicaset*** to 6 Replicas
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide101.png)  

### Once the YAML file is crafted, here is how to apply it:
```
kubectl apply -f [fileName].yaml
```
#### Get logs of applying YAML file
```
kubectl log –l app=[container name]
```
Here the summary of what we have learnt in this section:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide103.png)

[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)  
--- 
## Part 4: Build, Deploy and Manage your Microservices Application with OpenShift.
  
<div align="center">
      <a href="https://youtu.be/MTXPUHbnvL0">
         <img src="https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part4-youtube.png">
      </a>
</div>    
  
### Agenda
In this section you will learn:
- Why OpenShift?
- Kubernetes vs. OpenShift
- Developer productivity
- Deploy on OpenShift via CLI
  - Pushing image to registry
  - Create deployment
  - Expose 
- Deploy on OpenShift via Console
  - OpenShift Console
  - Builder Images
  - S2I (Source to Image)
--- 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide108.png)

### What is OpenShift Container Platform?
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide114.png)
OpenShift is built on top of Kubernetes, and brings 
along all the brilliant features of Kubernetes, but it bundles Kubernetes with all the Essential features that will ultimately provide the best experience to both developers and 
Operation engineers. 
But how does it achieve that?
Through a number of automated workflows, which are not available in Kubernetes. 
Those automated workflows are the results of these components that are drawn in this diagram. 
Kubernetes is wrapped around an enterprise-grade linux operating system (RHEL/CoreOS), Networking, monitoring, registry, 
And more importantly, authentication and authorisation. 

### 3 x key features of OpenShift over Kubernetes. Automation, Agility and Security. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide115.png)

### what are the automated workflows?

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide116.png)

- As a developer you want to get started on coding as quickly as possible, rather than 
spending time learning about different platforms, tools and services, and how to 
refactor your application based on them. 

Pre-created quick start application templates to build your application, based on your favourite languages, frameworks, and databases, with one click.

- As a developer you want to focus on coding and not worrying about what's going to happen in the background.

Deploying to OpenShift is as easy as clicking a button or entering a **git push** command, **enabling continuous integration**, managing builds, and allows you to fully control the deployment lifecycle.

- As a developer you want to build and test your application locally, without worrying about the openshift cluster your application will end up running in.

Develop container-based applications in the cloud or locally using the Red Hat CodeReady Containers to create a fully-functioning OpenShift instance **on your local machine**. Then, deploy your work to any OpenShift cluster.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide117.png)

As this figure shows developers can focus on coding, and the rest of the process is taken care of by OpenShift's S2I or Source to Image. Building your image, deploying, and as you will later in part 7, continues integration. 

### Three major differences between Kubernetes and OpenShift

#### CLI vs. Console
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide118.png)

One of the most distinctive features of OpenShift is its amazing web console that allows to implements almost all tasks from a simple graphical interface. As you saw in the previous lab, Kubernetes dashboard is only good for displaying the status of your resources. You can't deploy, control or manage your applications, networking or any of those form Kubernetes dashboard.  Obviously, managed Kubernetes on different cloud platforms, come with different set of functionalities as add-ons.  But with Openshift container platfomr, the offered functionalities through the openshift console are vast. You can build, deploy, expose, update, and almost implement any task in two separate perspectives of developer and administrator. We'll go through that later in this lab.  

#### Project vs. Product
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide119.png)

Kubernetes is an opensource project, where as Openshift is a product based on an open source project, which is Kubernetes Origin Distribution or OKD. [next] Comparing Kubernetes with OpenShift is like that classical example of comparing an engine with a car. You can't do much with an engine, and you need to assemble it with other components in order to get from A to B and become productive. What you get with OpenShift includes enterprise support, ecosystem certification And most importantly, regular releases and security updates at every level of the container stack and throughout the application lifecycle. That is an opinionated integration of features to simplify and secure your applications.

#### Cloud Platforms Offerings
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide121.png)

Kubernetes offerings differ from one platform to another. Almost every major cloud provider offers a different flavour of Kubernetes. You get different sets of add-ons, plug-in and set of instructions for connecting your application to your cloud resources, which in most cases are only applicable to that particular platform. With openshift container platform, your experience and the way you interact with with the platform, let's say the openshift console, stays the same. Therefore, building, deploying and managing applications with Openshift container platform is truly: build it once and deploy it anywhere. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide122.png)

In this lab we're going to use managed openshift on IBM Cloud. Before continuing, 
let's get started by provisions an OpenShift cluster on IBM Cloud.  
Red Hat® OpenShift on IBM Cloud™ is a fully managed OpenShift service that leverages the enterprise scale and security of IBM Cloud, so you can focus on growing applications, not scaling the master. 
IBM has added unique security and productivity capabilities designed to eliminate substantial time spent on updating, scaling and provisioning.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide123.png)

Once you've signed up on IBM Cloud and sign into your account by visiting cloud.ibm.com, you need to navigate through ibm cloud dashboard and choose OpenShift. Then go ahead and create your cluster. Once your cluster is provisioned and ready, it'll be listed in this table. 

### Download and Install prerequisites

Install IBM CLI tools
```
curl -sL https://ibm.biz/idt-installer | bash
```
Download OC CLI based on local OS and OpenShift version
```
https://mirror.openshift.com/pub/openshift-v4/clients/oc/
```
Download kubectl
```
https://storage.googleapis.com/Kubernetesrelease/release/v1.17.7/bin/darwin/amd64/kubectl
```
Set your environmental parameters for OC
```
mv /<filepath>/oc /usr/local/bin/oc
```
Set your environmental parameters for kubectl
```
mv /<filepath>/kubectl/usr/local/bin/kubectl
```
### Login to IBM Cloud and check your installed plugins

Login to IBM Cloud
```
ibmcloud login
```
if using a federated account
```
ibmcloud login --sso
```
List IBM Cloud plugins
```
ibmcloud plugin list
```
List IBM Cloud Openshift clusters
```
ibmcloud oc cluster ls
```
Initialize OC CLI Client
```
ibmcloud oc init
```
Log your local Docker daemon into the IBM Cloud Container Registry
```
ibmcloud cr login
```
Test your OC CLI
```
ibmcloud oc
```
Test your Container Registry
```
ibmcloud cr 
```
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide126.png)

### Push Image to IBM Container Registry

Create a new namespace in IBM Cloud Container Registry
```
ibmcloud cr namespace-add [namespace]
```

Tag the image
```
docker tag [image name] us.icr.io/[namespace]/[image name]
```

Push the image to container registry
```
docker push us.icr.io/[namespace]/[image name]
```

List images in IBM Cloud Continer Registry
```
ibmcloud cr image-list 
```

### OC commands
The developer OC CLI allows interaction with the various objects that are managed by OpenShift Container Platform. 

Here is the format of OC commands, almost identical with Kubectl
```
oc <action> <object_type> <object_name>
```
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide128.png)

View existing projects
```
oc projects 
```

Switch to a project
```
oc project [project name]
```

Create a new project
```
oc new-project [name project]
```

### Some useful OC commands

Get the full list of OC commands and parameters
```
oc --help
```

In-depth look into the values to be set
```
oc explain [resource]
```

Edit the desired object type
```
oc edit <object_type>/<object_name>
```

Updates one or more fields of an object (The changes is a JSON or YAML expression containing the new fields and the values)
```
oc patch <object_type> <object_name> -p <changes>
```
### Create Deployment using an image from IBM Cloud Container Registry

Create a deployment by instructing the OpenShift cluster to pull an image from ICR
```
oc create deployment [dep name] --image=us.icr.io/covid-test/myapp:v1
```
   
Get the list of deployments (same as Kubectl)
```
oc get deployment
```  

Get the list of pods (same as Kubectl)
```
oc get pods
``` 

### Expose the current deployment to the Internet

Expose the deployment on container port 8082 with LoadBalancer service type
```
oc expose deployment/mytestservice --port=8082 --type=LoadBalancer
```

Get the list of services
```
 oc get services
```
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide131.png)

Every OpenShift project has a Kubernetes service account that is named **default**. Within the project, you can add the image pull secret to this service account to grant access for pods to pull images from your registry. 

### Pull Images from ICR into non-Default Projects

- Create an IBM Cloud IAM service ID for your cluster that is used for the IAM policies and API key credentials in the image pull secret. 
- Create a custom IBM Cloud IAM policy for your cluster service ID that grants access to IBM Cloud Container Registry.
- Create an API key for the service ID
- Create an image pull secret to store the API key credentials in the cluster project
- Store the registry credentials in a Kubernetes image pull secret and reference this secret from your configuration file.
- Add the image pull secret to your default service account.

Create an IBM Cloud IAM service ID 
```
ibmcloud iam service-id-create cluster-project-id --description "service ID for cluster-project"
```
Create a custom IBM Cloud IAM policy for your cluster service ID 
```
ibmcloud iam service-policy-create iam-service-id --roles Manager --service-name container-registry 
```
Create an API key for the service ID 
```
ibmcloud iam service-api-key-create [api-key-name] [service-policy-id] --description "API Key"
```
Create an image pull secret to store the API key & store the registry credentials in K8s image pull secret
```
oc --namespace [project] create secret docker-registry [secret name] --docker-server=us.icr.io --docker-username=iamapikey --docker-password=[API-key] --docker-email=[]
```
Get all secrets in project 
```
oc get secrets --namespace [project]
```

Get secrets in 'default' serviceaccount in project [] 
```
oc describe serviceaccount default -n [project]
```
Add the image pull secret to your default service account
```
oc patch -n <project_name> serviceaccount/default --type='json' -p='[{"op":"add","path":"/imagePullSecrets/-","value":{"name":"<image_pull_secret_name>"}}]'
```

Check the secrets again to verify the secret has been added the default serviceaccoun. 

Get secrets in 'default' serviceaccount in project [] 
```
oc describe serviceaccount default -n [project]
```
### Verify that the new project can pull images from ICR

Create a deployment by pulling an image from ICR into the new peoject
```
oc create deployment [new project] --image=us.icr.io/covid-test/myapp:v1
```

verify that image has been pulled and deployed successfully
```
oc get deployment
```
Expose the deployment
```
oc expose deployment/mytestservice --port=8082 --type=LoadBalancer
```
Verify the service is up and running
```
oc get services
```
### Scale and Replicas

in this section we will create replicas of our deployed application. Openshift will considers the instructed number of instances as the desired state. If any pod fails or destroyed, OpenShift will bring that back up to keep the number of instances intact in order to meet the load.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide136.png)

Sclae the application by creating 3 more instances 
```
oc scale --replicas=4 deployment/[deployed resource]
```
Get the replicas
```
oc get rs
```
Verify the number of running pods (reflecting the number of instances)
```
oc get pods –o wide
```
### Rolling out updates and Rolling back
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide138.png)

Rolling updates allow Deployments' update to take place with zero downtime by incrementally updating Pods instances with new ones. Performing updates without affecting application availability.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide139.png)

In this part we're going to update our image to the parser for covid-19 mortality data reflect the number of death in every country country and region.  
```
oc set image deployment/[deployment name]  [container]=[new image]
```

Make sure you use the container name in the above command to update the image in it. 
To get the container name, use: 
```
oc get deployment -o wide
```
verify the deployment is updated by pinging the app
```
curl ip:port/hello/
curl ip:port/get/country/data/germany/
```

To rollback to the previous version use:
```
oc rollout undo deployment/[deployment Name] 
```
optional: You can add --to-revision=n in order to rollback to a specific verison
```
oc rollout undo deployment/[deployment Name] --to-revision=2
```
checkout the rollout status 
```
oc rollout status deployment/[deployment Name]
```

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide141.png)

[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)  
--- 
## Part 5: Build, Deploy and Share Your Applications with CodeReady Workspaces. 

<div align="center">
      <a href="https://youtu.be/Ok16HYkoKac">
         <img src="https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Part5-youtube.png">
      </a>
</div>

In this lab we'll explore one of the most exciting features of OpenShift for developers. We'll explore how codeready workspaces helps teams build with speed, Agility, security and most notably code: in production from anywhere. And by anywhere, it truly means anywhere as we'll find out shortly.  

First We'll take a look at the key features of CodeReady Workspaces and we'll show you how to install code ready workspace in your OpenShift cluster. We'll discuss Operators and the operatorhub. Then we'll dive into our workspace to create a sample application from the in-browser IDE, and share the workspace with our team.  

Here's a quick revision of what we've learnt together so far - and how that fits into 
our learning journey throughout this course. We containerised our application with 
Docker, deployed and managed with Kubernetes and later with OpenShift CLI and Console. And now we're going to make it even easier to get started with coding from a browser. If you haven't watched the previous workshops, I highly encourage you to go ahead and review them. You get a clear idea about microservices, containerisation, orchestration, how openshift automates tedious tasks, and ultimately why codeready workspaces is such a fabulous solution for developers.

### Agenda
In this section you will learn:
- What is CodeReady workspaces?
- Install CodeReady Workspaces
  - Operators in OpenShift
  - OperatorHub
  - Install CRW Operator
  - Create CheCluster
- Your first workspace
  - Sample stacks
  - Import from Git
  - In-browser IDE
  - Compile/Run/Expose
- Workspace admin
- Share your Workspace


![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide168.png)
Developers often spend too much time configuring their development environment, adding their libraries, dependencies and so forth.  It becomes even a bigger problem when developers are collaborating on a project. Let's say you develop an application on your machine, and it runs perfectly. but when others try to run it, all sorts of errors start showing up. And if you're working in a team, despite having kept your team well-aware of all the dependencies and libraries, collaborating on a project becomes a nightmare.  
You know that old saying : It works on my machine!!!

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide169.png)
CodeReady workspace offers a shared development environment for rapid cloud application development using Kubernetes and containers to provide a consistent and pre-configured developers environment to your teams.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide170.png)
It is a cloud-native application environment that allows you to share an instance of your workspace, including all the libraries, dependencies and tools . 
All you need to do is: add your libraries and dependencies, create a workspace instance and share that with your team members.. 
It is as easy as sharing a URL - called factory - with the rest of your team. clicking the URL will spin up a new workspace. This way your team will share the same runtime and same development environment ..
But that's not all.. CodeReady Workspaces includes a powerful in-browser IDE, with all the features of modern IDEs including version control system and even keyboard shortcuts. You can also access it from any operating system, browser or IDE, including extension for VS code. 

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide171.png)

Now let's explore Operators and the OperatorHub:
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide173.png)

### what is an operator?

updating and maintaining containerised applications should be an automated process. The same applies to your containerised development environment. Operators are small programs in your cluster that monitor your applications continuously and make sure they are running according to your instructions. When an operator detects a difference between the actual and the ideal states, it will act to correct it.   
If you recall from workshop 3, we discussed how  Kubernetes master node continuously reconciles the expressed desired state and the current state of an object. And that is a controller in Kubernetes. Controller is a core concept in Kubernetes and is implemented as a software loop that runs continuously on the Kubernetes master node. 
An Operator is essentially a custom controller.
The Operator is a piece of software running in a Pod on the cluster, interacting with the Kubernetes API server.

### What is the OperatorHub:

Operators are offered as pre-packaged modules from the operatorhub. OpenShift 4 introduced the OperatorHub, and that is a catalog of applications that can be installed by the administrator and added to individual projects by developers.

![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide174.png)

As we mentioned, Codeready workspaces is offered as a dedicated operator from the openshift Operatorhub.
Regardless of where you have your open shift cluster running, Codeready workspace runs as a pod inside your cluster. 
therefore workspaces are maintained and updated by an operator and you can rest assured that your development environment is always available and running according to your requirement. 

Underneath each workspace is a stack, a container image that includes language runtimes, compilers, tools, and utilities. Red Hat CodeReady Workspaces ships with stacks for many different languages. Stacks can go beyond just language support, however. A stack can contain multiple containers, allowing you to code in a replica of your production environment.

### Install CodeReady Workspaces

Please follow the video to install CodeReady Workspaces. Here are the screenshots to install codeready workspaces from the operatorhub on your openshift web concole.  

Installing CodeReady Workspaces in your OpenShift cluster is as simple as looking up its dedicated operator and installing from the OperatorHub within the OpenShift Console. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide172.png)   
The first step is to subscribe to the "CodeReady Workspaces" operator  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide175.png)  
locate the "Installed Opeators" from the opeartor tab. Subscribed/installed operators will appear in this list:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide176.png)  
Click on the CodeReady Worksapces operator from the list and locate the "CodeReady Workspaces Cluster" on the right hand side:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide177.png)  
Click on Create Che Cluster:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide178.png)  
Here you need to create a CheCluster using the YAML template. Let's not make any changes and click on create to go ahead with the default configuration:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide179.png)  
Wait for the CheCluster to be built and become ready. You can click on the CheCluster whilst is being built to view some details about its status and its reosurces.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide180.png)
Several reosurces will be created in the background inlcuding new Pods, Services and Deployments. It can be viewed from the resources tab:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide181.png)  
Navigate back to the "Overview" tab to get access to the workspaces URL on the right hand side. The URL only become available when the workspace is ready.   
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide182.png)  
Since this is your first time accessing the workspaces, you need to resgistr/sign up as a new user:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide183.png)
After signinig up, you can use one of the templates to initiate your IDE with a sample project. There are plenty of options to choose from including Java, Node, Python and Go sample applications. You import your own project from Github (i.e. the Covid-19 application), choose "custome workspace" next to "Get Started" tab.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide184.png)
It takes a few minutes for the workspace IDE to initialised.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide185.png)  
Here is your in-browser IDE with the sample project. you can view the files and resources from the left hand side.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide186.png)  
Make sure to check out the video for the extra steps and how we can make changes in the code and see the end result in production.  
Here's the summary of what we have learnt through this lab. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide187.png)
And here's the summary of what we have learnt togehter so far:  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide188.png)  

[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)  

---
## Part 6: Build, and Test Your Applications with CodeReady Containers.  
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide193.png)
CodeReady Containers brings a minimal, preconfigured OpenShift 4.x to your local laptop or desktop computer for development and testing purposes. CodeReady Containers is delivered as a Red Hat Enterprise Linux virtual machine that supports native hypervisors for Linux, macOS, and Windows 10.  
CodeReady Containers is the quickest way to get started building OpenShift clusters. It is designed to run on a local computer to simplify setup and testing, and emulate the cloud development environment locally with all the tools needed to develop container-based apps. 
  
### Agenda
In this section you will learn:
- What is CodeReady Containers?
  - Install & Setup
  - Start CodeReady Containers
- Build on CodeReady Containers
  - From Git
  - From Templates
  - From Containers
  - From Dockerfile
- Deploy with Source to Image from the console
- View our resources from the CLI  

Download CodeReady Containers (CRC) from this link after signing up for a Red Hat Developer account. 
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide194.png)
  
Once CRC is downloaded, set it up by following these commands:
 
 ```
 crc setup
 ```
Then start your CRC:
 ```
 crc start
 ```
You will be asked to enter your **pull secret**. Retreive it form your Red Hat account:
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide195.png)

Once CRC starts, you will be provided with dedicated URLs to log into your CRC webconsole as an admin or developer:
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide198.png)

You will need the username and password in order to log into the web console.
![alt text](https://github.com/mohaghighi/Covid19-Web-Application/raw/master/images/Labs/Slide199.png)

If you want to carry on using the CLI tool, make sure you've set your environmental parameters to interact with CRC using OC commands:
 ```
 eval $(crc oc-env)
 ```
 some extra options to include in your CRC:  
 
 You can define your allocated resources by adding options to control the nuber CPU cores, memory and the Hypervisor used by CRC
 ```
 crc start --cpus [cpu cores] --memory [mib] --vm-driver [vm]   
 ```
 by default CRC loads this way
 ```
 crc start --cpus [4] --memory [8192] --vm-driver [hyperkit]   
 ```
 To stop CRC
 ```
 crc stop
 ```
 

[ Back to the table of content ⇪](https://github.com/mohaghighi/Covid19-Web-Application/blob/master/README.md#table-of-contents)   

--- 
## Part 7: Build your CI/CD pipelines with Jenkins and Tekton. 
  
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
    
  
