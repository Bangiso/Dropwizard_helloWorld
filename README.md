# Dropwizard_helloWorld
I have followed a dropwizard tutorial which can be found here: https://www.dropwizard.io/en/stable/getting-started.html for great details. I have implemented post, delete and put http methods. 

To run the application, execute the following commands on terminal:
  
$ mvn package   
 
$java -jar target/HelloWorld-1.0-SNAPSHOT.jar serve hello-world.yml  


Once the application is up and running you can use postman UI https://www.getpostman.com/downloads/ to make your requests.   


POST json format on the path /hello-world   
{ "id": 1,
  "content": John
}       

DELETE  on  /hello-world/{id} by id     


#NB 
The application is running on port 8088, if you have another app using this port change this on hello-world.yml.
