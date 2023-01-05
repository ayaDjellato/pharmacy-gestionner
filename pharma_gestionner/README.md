## Pharmacy gestionner 

this structure helps with the gestion of a pharmacy

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `bin`: the folder to maintain dependencies

the compiled output files will be generated in the `bin` folder by default.

> `src` contains three main folders:
    `controlers`: the folder who maintains all the different controllers of the interface 
    `models`: contains the models of the project such as patient vente and stock
    `sample`: contains the graphic interfaces build through scene builder presented in fxml format
>mainprint represent the main class of this work

## getting started
this work we have main functionalities:
* adding and deleting elements from stock and patients
* login interface 
* admin dashboard interface with add user (vendors) as additional functionality from random users
* user (vendor) dashboard interface 
* login:
        *enter the username and password and hit login button you will automatically being recognized as a user or admin and the specific dashboard will               appear
* patient dashboard :
        *displays the patients in the database through a table with their id name and lastname last purshases and phone numbers
        * a search bar to search for a specific patient in the database with their id or name in search bar and hit go
        * to delete an element search for the id in search bar and hit go then if the user exist he will appear in the table then hit delete and refresh for            a full display
        * a refresh button to redisplay all the patients in table
        * an add user space to add a user when needed by entering the name and lastname, phone number of the patient and hit add button 
        * an error message can be displayed to the user.



## tools used in this project
we used vscode an IDE
php devserver for the database
scene builder for the design interfaces 

