# Lab - Se connecter à internet

## Installation 


````conf
composer install
npm install
php artisan migrate
php artisan db:seed
npm run build
````

## Création d'API

- Création du projet laravel 

````bash
composer create-project laravel/laravel todolist
php artisan make:migration create_tasks_table 
php artisan make:model Task
````

