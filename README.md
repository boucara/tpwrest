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