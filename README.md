Banking System

We need to design a website for banking system using MVC design pattern (layer for classes/orm, layer for services, layer for beans).
Design your Class UML with relationships using any application for drawing.
Your application should provide Arabic and English Language.
You can use Primefaces library.
We will simplify the system to be only 5 modules (Tables):
Client (Id, Name, Password, User Name, Birthdate, Net Salary, Address, Mobile, Mail)
Bank Employee (ID, Name, Position).
Account (ID, Amount, Client ID)
Transaction (ID, Transaction Date, Description, From Account ID, To Account ID)
Bank (ID, client ID, Account ID, Branch Address)
When system is loaded, there will be a default created/retrieved object for one bank.
Page 1:
It enables the client or Employee to register  for the first time with the following restrictions:
🡪 Password with regex of 1 capital letter, 1 symbol and at least 5 characters
🡪 Type (Select One Menu) options will be Client or Bank Employee
🡪 Mobile which does accept any typing character.
🡪 Mail with regex of a valid mail
🡪 Register Button (will redirect the user Login Page)

Page 2: 
It enables the user to login with this information:
🡪  User Name
🡪  Password
🡪 Login Button (will redirect the user to the Account page if he is a client or redirect to Bank page if he is an employee)


Page 3 Account Page: 
User can create only one account and edit it.
Confirmation pop up for saving edited stuff.
User can make a transaction from his balance to any client available in the bank, this transaction has to be approved by Bank Employee to be deposited from user’s account.
User can view all made transactions and their status (Approved, Pending, and Rejected) and download a generated report (English & Arabic) for them.
Page 4 Transaction:
Bank Employee can accept or reject any transaction was made by user.
Accepted transaction will effect on (from, to) accounts.
Rejected Transactions will be shown to the user in account page.
