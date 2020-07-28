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

--- 
## Part 3: Deploy, Run and Maange your Docker Containers with Kubernetes. 
  
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
  
  
--- 
## Part 4: Build, Deploy and Manage your Microservices Application with OpenShift.
  
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


## Part 5: Build, Share and Deploy Your Applications with OpenShift's CodeReady Workspace.
  
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
  
--- 
## Part 6: Build and Test Your Microservices Application with OpenShift on Your Own Machine with CodeReady Containers
  
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
    
  
