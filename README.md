
# UserViewer

## Requirements

* Java 11+
* Maven 3+


## Database

I selected HsqlDB because of performance better than other  embedded RDBMS databases. 

For more information
* https://www.jpab.org/Hibernate/HSQLDB/embedded/Hibernate/SQLite/embedded.html


## Run

* mvn clean run

### Configuration

There is no need any configuration to run.

### Endpoints
There are two endpoint. You must fill "request-user-id" parameter in Header.  

 1. Add New View Information

	Url : http://localhost:8080/user-views
	Method: POST
	Request Body: 
			`{"viewerId" : 1,  viewedUserId" : 2}`
	Body Description:
	   viewerId -> which user view the other user's profile
	   viewedUserId ->  userId is viewed by viewerId

 2.  Get Viewer List
	Url : http://localhost:8080/user-views/{userId}/viewers
	Method: GET
	Response Body: 
		  `{
		   "userViews":[
		      {
		         "viewId":46,
		         "userId":1,
		         "userName":"Emre",
		         "userSurname":"Basri",
		         "viewDate":"2021-07-04T21:15:59.885036"
		      },
		      {
		         "viewId":45,
		         "userId":1,
		         "userName":"Emre",
		         "userSurname":"Basri",
		         "viewDate":"2021-07-04T21:15:59.731492"
		      }
		   ]
		}`

### Questions in Document
1. Do you delete any data from the database?
    **Answer:**  No.  Firstly, This information can be important for use in future. Second, You mentioned in document, every hour we get millions requests.  We use RDBMS database, delete operations will cause latency. Maybe Application will be stop because It won't process other requests. 
     If We need performance , we can use NoSql database like redis or elastic search for last 30 days data. We can retrive data from them. We can delete older data from them. Because deleting data in redis or elastic search more easy then RDBMS.
2. Do you have any periodic task type of batch jobs to maintain data?
   **Answer:** I think no. We can use two periodic tasks in this project. 1. Inserting data, 2. deleting data.
	1. We can add every new view informations in a cache. Then a task insert every data to in a periodic task in one insert query and we clear the cache.
	2. For deleting older data from database.
	
	But I didn't prefer this way. I insert data asynchronously so I don't think need  any other periodic tasks.

3. What type of compromise (for example; tradeoff between“storage on disk” vs “latency in retrieval”) did you see? What was your decision? Why?

   **Answer:**  
	I answered a part  this question  in second question. 
	Also I thought about using cache mechanism for Get View Request. But It may unnecessary, because reading HSQLDB is fast so I didn't do that. Cache may be good for reading but  Managing cache can be hard.
	
	
	
	

