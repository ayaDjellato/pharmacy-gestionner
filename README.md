# Pharmacy gestionner 

this structure helps with the gestion of a pharmacy

### description
* in this work we have the login page as the first element, after login in as a user we enter the dashboard interface
* in patient and stock dashboard we can add delete and search for a patient or stock in the database
* in the add user only avaiable after login in as an admin (user: adm  pwd : 000) adding and deleting a user is possible


### Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `bin`: the folder to maintain dependencies

the folders contained in src:
- `controlers`: the folder who maintains all the different controllers of the interface 
- `models`: contains the models of the project such as patient vente and stock
- `sample`: contains the graphic interfaces build through scene builder presented in fxml format


the compiled output files will be generated in the `bin` folder by default.
mainprint represent the main class of this work

### user guide
this work we have main functionalities:
* adding and deleting elements from stock and patients
* login interface 
* admin dashboard interface with add user (vendors) as additional functionality from random users
* user (vendor) dashboard interface 

* login:
    * enter the username and password and hit login button you will automatically being recognized as a user or admin and the specific dashboard will               appear
    

* patient dashboard :
    * displays the patients in the database through a table with their id name and lastname last purshases and phone numbers
    * a search bar to search for a specific patient in the database with their id or name in search bar and hit go
    * to delete an element search for the id in search bar and hit go then if the user exist he will appear in the table then hit delete and refresh for a full display
     * a refresh button to redisplay all the patients in table
     * by entering the name and lastname, phone number of the patient in text fields and hit add button the patient will be uploaded
     * an error message can be displayed to the user.

* example for patient and login interface:
      ![example video](https://user-images.githubusercontent.com/67550664/210804249-cd5e8f28-5fa5-4755-a6cc-7f5ae19d2f29.mp4)


### tools used in this project
* we used vscode an IDE
* php devserver for the database
* scene builder for the design interfaces 

