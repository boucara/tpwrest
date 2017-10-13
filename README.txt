TP: API REST
R�alisateur: Traor� A�chatou

Enonc�:
Objectifs
Vous devez construire une API REST compl�te couvrant tous les besoins possibles sur un mod�le de donn�e 
simple, compos� de deux entit�s li�es par une composition
Nous travaillerons sur l�exemple classique�Biblioth�que �Livre�.
La biblioth�que aura pour propri�t�s:Un nom (String), une adresse (String), une ann�e de construction (Int), une collection de livres (Livre)
Le livre aura pour propri�t�s:Un nom (String), une date de parution (Date), un ISBN (String) et un auteur (String) 
Vous devrez traiter les op�rations GET / POST / PUT / DELETE sur les deux entit�s. 
Vous devrez aussi ajouter la gestion de ressources li�es, dans notre cas, donner la possibilit� d�acc�der � un 
livre en passant par la biblioth�que, ce qui pourrait donner une requ�te du genre:GET /biblio/1/books pour r�cup�rer la liste de tous les livres de la biblioth�que ayant l�id 1.
PUT /biblio/2/book/1 pour modifier le livre ayant l�id 1 r�f�renc� dans la biblioth�que ayant l�id 2.
Il va de soi que si le livre avec l�id 1 ne se trouve pas dans la biblioth�que ayant l�id 2, il faudra retourner un code d��tat appropri�.
