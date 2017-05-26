# **Personal Expenses Management Application overview**

It is simple command-line application that allows users to track how much money have they spent.

# **Following commands which supported by application**

`add 2017-04-25 12 USD Jogurt`
 adds expense entry to the list of user expenses. Expenses for various dates could be added in any order. Command accepts following parameters: -- 2017-04-25 — is the date when expense occurred -- 12 — is an amount of money spent -- USD — the currency in which expense occurred -- Jogurt — is the name of product purchased

`list`
shows the list of all expenses sorted by date

`clear 2017-04-25`
removes all expenses for specified date, where "2017-04-25" is the date for which all expenses should be removed

`total PLN`
this command should take a list of exchange rates from http://fixer.io, calculate the total amount of money spent and present it to user in specified currency, where "PLN" — is the currency in which total amount of expenses should be presented.

# **How to build and run an application?**
Settings for IntelliJ IDEA 

**_Building_**

Do one of the following:
- On the main menu choose **Build | Build Project 'PersonalExpensesManagementApp'**.
- Press Ctrl+Shift+F9.

**_Running_**
1) On the main menu choose **Run | Edit Configurations**;
2) Click **Add New Configuration** or (**Alt + Insert**) end select **Application**;
3) Enter or select name of **Main Class** "com.mariazgoba.Main" and **Name** "ExpensesManagementApp" ;
4) click **Apply**;
5) Do one of the following:
  - On the main menu choose **Run | Run Project 'ExpensesManagementApp'**.
  - Press Shift+F10.

# **Technologies**
- Java  8
- JDBC - access DB
- MySQL - DB Server
- Maven - Build system