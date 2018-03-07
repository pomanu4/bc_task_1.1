# bc_task_1.1
в програмі використовується конект до база даних MySQL 
для запуску програми на вашому пристрої створіть базу за допомогою команд : 
create database BC_db; 
use  BC_db;
у файлі за шляхом  Task-1\src\main\resources\META-INF\persistence.xml змініть поля

property name="javax.persistence.jdbc.user" value="** для вашої БД**"

property name="javax.persistence.jdbc.password" value="** для вашої БД**"/

клас Init.java заповнить базу значеннями при старті програми 
перед повторним запуском програми в класі MainClass закоментуйте стрічку init.initDataBase(); 
для уникнення повторного заповнення базу значеннями
