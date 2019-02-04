# Data-Analytics

Data-Analytics is a simple project to process files in a directory.

# How to work

Data-Analytics catch a files from user.home/data/in directory and process them afterward write the output file in user.home/data/out

![alt text](https://i.imgur.com/p3q5n81.png)

## Input Example

Create a file from .dat extension and put them in user.home/data/in:

### File body

001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

## Output Example

after processing, the system writes the output file in directory user.home/data/out with the same name as the input file:

### File body

customersAmounts= 2
salesmanAmounts= 2
mostExpansiveSaleId= 10
worstSalesman= Paulo

# Running project

Go to the project location and run: ./gradlew build

After execute build, execute: java -jar build/libs/{jarname}.jar

# Running tests

If you want running tests, execute: ./gradlew test