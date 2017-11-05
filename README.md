# TP: API REST
 ### Réalisateur: Traoré Aïchatou
 ### Encadreur :Gregory Galli

 ## Enoncé:
Objectifs
Vous devez construire une API REST complète couvrant tous les besoins possibles sur un modèle de donnée
simple, composé de deux entités liées par une composition
Nous travaillerons sur l’exemple classique«Bibliothèque –Livre».
La bibliothèque aura pour propriétés:Un nom (String), une adresse (String), une année de construction (Int), une collection de livres (Livre)
Le livre aura pour propriétés:Un nom (String), une date de parution (Date), un ISBN (String) et un auteur (String)
Vous devrez traiter les opérations GET / POST / PUT / DELETE sur les deux entités.
Vous devrez aussi ajouter la gestion de ressources liées, dans notre cas, donner la possibilité d’accéder à un
livre en passant par la bibliothèque, ce qui pourrait donner une requête du genre:GET /biblio/1/books pour récupérer la liste de tous les livres de la bibliothèque ayant l’id 1.
PUT /biblio/2/book/1 pour modifier le livre ayant l’id 1 référencé dans la bibliothèque ayant l’id 2.
Il va de soi que si le livre avec l’id 1 ne se trouve pas dans la bibliothèque ayant l’id 2, il faudra retourner un code d’état approprié.

# Les étapes d'implementation de la sécurité REST
* Modification du fichier build.gradle : ajout dans la section de dependance les  plugins: 
    *  **org.grails.plugins:springsecurity-core:3.2.0.M1**
    *  **org.grails.plugins:springsecurity-rest:2.0.0.M2**
* Création des entités User , authority et leur relation UserAuthority à l'aide de la commande suivante :
    *  **grails s2-quickstart api_rest User Authority**
Leur contenu a été automatiquement généré par spring security core précedemment ajouté dans le fichier build.gradle
* Modification  du fichier "**grails-app/conf/application.groovy**" : ajout des éléments suivants pour configurer le plugin Grails Spring Security Rest
    * grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
      grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
      grails.plugin.springsecurity.rest.token.validation.headerName = 'MyToken'
      grails.plugin.springsecurity.rest.token.storage.memcached.hosts = 'localhost:8080'
      grails.plugin.springsecurity.rest.token.storage.memcached.username = ''
      grails.plugin.springsecurity.rest.token.storage.memcached.password = ''
      grails.plugin.springsecurity.rest.token.storage.memcached.expiration = 86400
    
    * Interdiction d'accés aux services de l'APi sans authentification
       * grails.plugin.springsecurity.**interceptUrlMap** = [
        [pattern: '/api/bibliotheque',    access: [**'isFullyAuthenticated()**']],
        [pattern: '/api/bibliotheques',    access: [**'isFullyAuthenticated()**']],
        [pattern: '/api/livre',    access: ['**isFullyAuthenticated()**']],
        [pattern: '/api/livres',    access: ['**isFullyAuthenticated()**']],
        ]
    
* Modification du fichier  "**grails-app/init/Boostrap**" : ajout de trois utilisateurs pour le test de la sécurité 
