# spring-boot-demo :: NUMBER GENERATOR

This project is developed using spring boot which can be build using maven build and run as maven project to make the application to use.
 We can create a text file with unique name everytime we hit POST Request, this unique name generator is done by UUID class.
Project has two phase given in below.
 ###### 1) We can hit POST request using below JSON Request payoad which will generate a unique field added in response and also a file with unique name will be generated in path given in application.property file.
   #### Request URI::
   http://localhost:8080/api/generate
   #### Request Payload::
   {
      "goal": 27,
      "step": 3
    }
    
   #### Response:
   {
    "goal": 27,
    "step": 3,
    "task": "158147ef-57cb-4b20-ab7a-5cb6e9eece1c"
    }
    
    
  Also a file with unique name will be creted with value "27,24,21,18,15,12,9,6,3,0" at path menntioned in application.property file.
  Then we can hit the other get URI to read the file by using unique file name which was created from the step one.
  
  ###### 2) In second phase we have get URI given in below to read file from the location where we have wrote file with POST request with unique name.The URI we can make by taking th unique ID from task field in response of first POST request
  #### Request URI::
  http://localhost:8080/api/158147ef-57cb-4b20-ab7a-5cb6e9eece1c
  #### Response:
  27,24,21,18,15,12,9,6,3,0
  
  #### Image Reference given in blow::
  
  ![spring-boot-demo](https://user-images.githubusercontent.com/5600689/87074067-f9524980-c23b-11ea-9cf3-c593346e4945.PNG)
  
