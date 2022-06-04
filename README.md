# UKHN_backend
#### To visit the website: http://www.ukhainan.com/#/
This is the backend code for UK &amp; Hainan Association. 
UK & Hainan Association committed to promoting cooperation in the fields of science and technology, 
finance, business, tourism, education and other fields in the UK and Hainan Province in China, and 
jointly promote the construction and development of Hainan Free Trade Port.
<br/><br/>
<img src='https://ukhn-admin.oss-cn-hongkong.aliyuncs.com/logo.jpg?OSSAccessKeyId=TMP.3KegsxQRMSX5Yp2DhnQwW8grrryKR9J3UonYVPtHuVvSAUvEFxePAJ5KHHV9pk5rXknsSQQfUmcbfQNmUDWrP4F9FybN8v&Expires=1654360475&Signature=s8ZI1VhhSbbawL6bQcI%2BOfnvXcc%3D' width=200px/><br/>

## Tech Stack
* This is a SpringCloud project, using Mybatis to perform database operations.
* Aliyun services such as OSS(Object Storage Service) for files storage, ECS server for cloud hosting, 
RDS cloud database for data storage and management.

## Installation
Use the following command to pull the source code from the remote repository to the local

```
https://github.com/littlelittleJessica/UKHN_backend.git
or
git@github.com:littlelittleJessica/UKHN_backend.git
```

## modules in project
<img src='https://ukhn-admin.oss-cn-hongkong.aliyuncs.com/image-20220503231506917.png?OSSAccessKeyId=TMP.3KegsxQRMSX5Yp2DhnQwW8grrryKR9J3UonYVPtHuVvSAUvEFxePAJ5KHHV9pk5rXknsSQQfUmcbfQNmUDWrP4F9FybN8v&Expires=1654360352&Signature=wQLPliVKoeApj8Z6M29AGRUvfog%3D' width=800px/><br/>
* **business**<br>
The core bussiness module including all business controllers. (spring boot project)
* **doc**<br>
Related documentation, including database initialization script
* **eureka**<br>
Registration Center. (spring boot project, changed registration center to Nacos later in the project)
* **file**<br>
File module, including file upload operations. (spring boot project)
* **gateway**<br>
Routing module, define the gateway of the project. (spring boot project)
* **generator**<br>
Mybatis code generator, run mybatis-generator to generate domain, mapper.xml and mapper for a table
* **server**<br>
Public jar module which business, file, system dependent on (spring boot project)
* **system**<br>
System module，including system operations such as user login. (spring boot project)

## Project initialization
* You should install the following tools: idea, nodejs，jdk1.8, mysql8.0, navicat
* Open the source code with idea
* Refresh the maven dependencies
* Create database and execute database initialization script in /doc/db/all.sql and /doc/db/member.sql


## Run the project
* Install Nacos in local, run nacos.exe and keep the cmd window open while running the project, you can view module registration conditions in http://127.0.0.1:8848/nacos/index.html
* Run the gateway module：GatewayApplication
* Run the system module：SystemApplication
* Run the business module：BusinessApplication
* Run the file module：FileApplication
