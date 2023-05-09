# Projet validation : Principes de autoformation d'Android en Kotlin
- https://developer.android.com/courses/android-basics-kotlin/course?hl=fr
<details>
<summary>Module 1 : Principes de base du Kotlin </summary>

    - Présentation du Kotlin
    - Créer votre première application
        - Principes de base des tests Android (tests unitaires)
    - Créer une mise en page de base
        - Un élément TextView est un composant d'interface utilisateur permettant d'afficher du texte dans votre application.
        - Un ConstraintLayout est un conteneur pour d'autres éléments d'UI.
        - Les Views doivent être fixées horizontalement et verticalement dans un conteneur ConstraintLayout.
        - Une ImageView est un élément d'interface utilisateur permettant d'afficher des images dans votre application.
    - Ajouter un bouton à une application
        - Introduction au débogage
        - Créer des tests unitaires

</details>
 
<details> 
<summary> Module 2 : Mises en page </summary>

    - Recevoir des entrées utilisateur dans une application : partie 1
        - Classes et héritage 
    - Recevoir des entrées utilisateur dans une application : partie 2
    - Afficher une liste déroulante
        - Créer et utiliser des listes en Kotlin
</details>
<details> 
<summary>Module 3 : Navigation</summary>

     - Naviguer entre les écrans
        - Activités et intents
        - Étapes du cycle de vie d'une activité
            -Les principales méthodes de cycle de vie sont les suivantes : onCreate()onStart()onPause()onRestart()onResume()onStop()onDestroy()
    - Présentation du composant Navigation
        - Les fragments et le composant Navigation
        - Tester les composants Navigation
    - Composants de l'architecture
        - Stocker des données dans ViewModel
        - Utiliser LiveData avec ViewModel
    - Exemples d'application de navigation avancée
        - ViewModel partagé entre plusieurs fragments
        - Navigation et pile "Retour"
        - Tester les ViewModels et LiveData
    - Mises en page adaptatives
        - Créer une mise en page à deux volets
        - Mises en page adaptatives
        - Adopter des mises en page responsives pour votre interface utilisateur
</details>
<details> 
 <summary>Module 4 : Se connecter à Internet</summary>

    - Coroutines
        - Présentation des coroutines
    - Récupérer des données sur Internet
        - Présentation de HTTP/REST
        - Récupérer des données sur Internet
            - Les services Web courants utilisent une architecture REST
        - Charger et afficher des images depuis Internet
            - La bibliothèque Coil simplifie le processus de gestion des images, notamment le téléchargement, la mise en mémoire tampon, le décodage et la mise en cache dans votre application.
        - Déboguer avec des points d'arrêt
        - Projet :application Amphibians
</details>
<details> 
 <summary>Module 5 : Persistance des données</summary>
    
    - Présentation de SQL, Room et Flow
        - Principes de base de SQL
            - Structure d'une base de données relationnelle : tables, colonnes et lignes.
            - Instructions SELECT, y compris les clauses WHERE, ORDER BY, GROUP BY et LIMIT.
            - Insérer, mettre à jour et supprimer des lignes à l'aide de SQ.
        - Présentation de Room et de Flow
    - Utiliser Room pour la persistance des données
        - Persistance des données avec Room
            - Création d'une base de données SQLite et interaction à l'aide de la bibliothèque Room
            - Création d'une entité, d'un DAO et de classes de base de données
            - Utilisation d'un objet d'accès aux données (DAO, Data Access Object) pour mapper des fonctions Kotlin à des requêtes SQL
        - Lire et mettre à jour des données avec Room
        - Schéma de dépôt
        - Preferences DataStore
            - DataStore dispose d'une API totalement asynchrone basée sur des coroutines Kotlin et Flow, ce qui garantit la cohérence des données.
</details>
<details> 
<summary>Module 6 : WorkManage</summary>

    - Planifier des tâches avec WorkManager
        - Présentation des principes de base de WorkManager
        - Présentation de l'implémentation de WorkManager
        - Travail en arrière-plan avec WorkManager – Kotlin
</details>