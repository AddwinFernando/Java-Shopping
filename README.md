Java_ECommerce
--------------
 
This java console application for E-Commerce has the following sections:
------------------------------------------------------------------------
    1. Login - Existing User and Admin
    2. Register - New User
    3. Home - User
        * View Categories 
            - View products based on category.
        * View Products 
        * View Cart 
            - Add products to cart.
            - Check out products from cart.
        * View Order 
        * Logout
 
-> Java for coding 
-> 'CSV' file for storing and retrieving data.
 
Files used for each sections:
-----------------------------
    1. "User credential" file for storing user data.
    2. "Category data" file for storing categories.
    3. "Product data" file for storing Products.
    4. "Cart data" file for storing user cart details.
    5. "Order data" file for storing user order details.
 
 
Steps used and challenges faced to build this application:-
-----------------------------------------------------------
 
    Steps:
    ------
    1. Used MVC (Model, View, Controller) architecture for developing the console application.
    2. Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
    3. Added user-defined exceptions to catch anf handle the exceptions.
    4. Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
    5. Used "ArrayList" to store and manipulate data according to the user preferrences.
    6. Used "CSV" Files for handling data.
    7. Stored the file path, Scanner class other sensitive information in a separate Utility folder.
    8. Used Singleton pattern to avoid creating objects.
    9. Used "Date" class for handling date for orders.
    10. Handled exceptions for invalid choices.
 
    Challenges:
    -----------
    1. Had a problem while updating the data in the csv file , i used to scan(READ) the file line by line and edit and append the data in that same procces;
		->Solved by loading the data into an array and updating that array and writing that data back to the CSV file
  
 
 
Working on the following sections 
---------------------------------
  1. Logout
	-Add the Logout functionality
  2. Add Back button to all the pages/sections,Fuctionality to go to the previous section
  3. Add email validation
 
Credentials 
-----------
  -> For Login use the following credentials
      *Email = "a" | Password = "a"
	  *Email = "b" | Password = "b"
	  
  
