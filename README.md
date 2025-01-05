# Bank Account Java

## 🎯 Project's Goal

This project allows the user to Accounts, such as create, list information and close it, using microservices and CQRS architecture. Also, is possible to create transactions to an Account, such as Deposits and Withdraws. This project was made with educational purpose.

## 🔧 Stack

This project was developed using [Java 11.0.10](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) as main and only programming language, [Docker](https://www.docker.com/products/docker-desktop/) as container to the application, [MySQL 8.3.0](https://downloads.mysql.com/archives/community/), [MongoDB 7.0.8](https://www.mongodb.com/try/download/community-edition/releases/archive)as database system and [Kafka 3.4.0](https://kafka.apache.org/downloads) with Zookeper as message management into the Docker container.

## 💻 Endpoints

1. [Accounts](#accounts)
   1. [Open Bank Account](#open-bank-account)
   2. [Close Bank Account](#close-bank-account)
   3. [Get Account by ID](#get-account-by-id)
   4. [List All Accounts](#list-all-accounts)
   5. [Get Account by Holder](#get-account-by-holder)
   6. [List Accounts by Balance](#list-accounts-by-balance)
3. [Transactions](#transactions)
   1. [Deposit to an Account](#deposit-to-an-account)
   2. [Withdraw from an Account](#withdraw-from-an-account)


## 💰Accounts

Endpoints to create, update Accounts status and list accounts.

### Create Account

This endpoint allows the user to register an Account to a Holder. If request is successful, the API will return the Account ID.

Path: `/api/v1/openBankAccount`

HTTP Method: `POST`

Body fields:

`accountHolder`: Holder's name (String);

`accountType`: Account type (String), possible values are SAVINGS or CURRENT;

`openingBalance`: Account inicial balance.

#### Request Body:

```json
{
    "accountHolder": "João",
    "accountType": "SAVINGS",
    "openingBalance": 50.0
}
```

### Delete Account

This endpoint allows the user to delete an Account.

Path: `/api/v1/closeBankAccount/{accountId}`

HTTP Method: `DELETE`

Path Variable: 

`accountId`: Account ID.

### Get Account By ID

This endpoint allows the user to list a single Account by its ID.

Path: `/api/v1/bankAccountLookup/byId/{accountId}`

HTTP Method: `GET`

Path Variable: 

`accountId`: Account ID.

### List All Accounts

This endpoint allows the user to list all Accounts in Database. 

Path: `/api/v1/bankAccountLookup/`

HTTP Method: `GET`

### Get Account By Holder

This endpoint allows the user to list Accounts by Holder.

Path: `/api/v1/bankAccountLookup/byHolder/{holderId}`

HTTP Method: `GET`

Path Variable: 

`holderId`: Holder ID.

### List Accounts Greater or Lesser than Balance

This endpoint allows the user to list all Accounts greater or lesser than by balance path variable.

Path: `/api/v1/bankAccountLookup/withBalance/{equalityType}/{balance}`

HTTP Method: `GET`

Path Variable: 

`equalityType`: Allowed values are GREATER_THAN or LESS_THAN;

`balance`: Inicial or max balance to be listed.

## 💸Transactions

Endpoints to create Deposits, Withdraws, Transfers or list Transactions information.

### Deposit to an Account

This endpoint allows the user to deposit values to an Account.

Path: `/api/v1/depositFunds/{accountId}`

HTTP Method: `PUT`

Path variable:

`accountId`: Account ID (integer) that will receive the deposit, minimum 1;

Body fields:

`amount`: Value (Numeric) to be deposited to the Account ID, minimum 0.01.

#### Request Body:

```json
{
    "amount": 200.50
}
```

### Withdraw from an Account

This endpoint allows the user to withdraw values from an Account.

Path: `/api/v1/withdrawFunds/{accountId}`

HTTP Method: `PUT`

Path variable:

`accountId`: Account ID (integer) that will have the amount withdrawn from the actual balance, minimum 1;

Body fields:

`amount`: Value (Numeric) to be withdrawn from the Account ID, minimum 0.01.

#### Request Body:

```json
{
    "amount": 10.00
}
```

