
# Projet Java avancé

Vous allez faire un projet de web api utilisant les technolgies java, spring, jdbc, mysql.
Vous pouvez partir du code fait en cours ou non.

# I- Sujet

## Application 

L'application devra être une API web en micro services. Elle devra utiliser une base de données mysql.
C'est une API REST donc les méthodes http utilisées seront GET/POST/PUT/DELETE.
Vous devez utiliser JDBC ou Spring JDBC pour le requetage, NE PAS utiliser JPA ou HIBERNETE.

## La base de données

La base de données est imposée. Ca structure est la suivante:
TABLE CATEGORY (id(pm, ai), name)
TABLE PRODUCTS (id (pm, ai), type, rating, name, createdAt, categoryId )

## CRUD

Vous dévez impléter pour chaque élément un controller avec les fonctionnalitées CRUD (create, read by id, read all, update, delete).
Vos requetes devront être protégées contre l'injection SQL, utiliser les paramètres de requete.

Create: https://xxxxx.com/products/ en POST avec les données dans le body

Read By ID: https://xxxxx.com/products/4 en GET

Read all: Create: https://xxxxx.com/products/ en GET

Update: Create: https://xxxxx.com/products/7 en PUT avec les données dans le body

Delete: https://xxxxx.com/products/4 en DELETE

## Pagination

Vous allez implémenter la pagination en utilisant le paramètre de requête ?range=0-25 et les Header standards HTTP pour la réponse:  Content-Range & Accept-Range.
Voici comment les links doivent être présent dans le header de retour:
Link: <https://xxxxx.com/products/orders?range=0-7>; rel="first", <https://xxxxx.com/products/orders?range=40-47>; rel="prev",  <https://xxxxx.com/products/orders?range=56-64>; rel="next", <https://api.xxxxx.com/products/orders?range=968-975>; rel="last"

Voici ce que contient également le header dans le cas d'une pagination:
Content-Range: 0-47/48
Accept-Range: product 50

## Tris

Le tri du résultat d’un appel sur une collection de ressources passe par deux principaux paramètres :

sort : contient les noms des attributs, séparés par une virgule, sur lesquels effectuer le trie.
desc : par défaut le tri est ascendant (ou croissant), afin de l’obtenir de façon descendant (ou décroissant), il suffit d’ajouter ce paramètre (sans valeur par défaut). On voudra dans certains cas spécifier quels attributs doivent être traités de façon ascendant ou descendant, on mettra alors dans ce paramètre la liste des attributs descendants, les autres seront donc par défaut ascendants.

Vous devrez inclure un tri sous la forme suivante: https://xxxxx.com/products?asc=rating&desc=name

## Filtres
Vous devrez inclure dans votre librairie un filtre générique sous la forme suivante: http://xxxxx.com/products?type=pizza,pates&rating=4,5&days=sunday
Sur une chaine de caratères:
- l'utilisateur peut rechercher une valeur fixe (type=pizza) 
- l'utilisateur peut rechercher plusieurs valeurs,  ex les produits de type 'pizza' ou 'pates' (type=pizza,pate)

Sur les valeurs numériques:
- l'utilisateur peut rechercher une valeur fixe (rating=4) 
- l'utilisateur peut rechercher plusieurs valeurs,  ex les produits de rating '4' ou '5' (rating=4,5)
- l'utilisateur peut rechercher des fourchettes de valeurs,  ex les produits de rating compris en '4' et '10' (rating=[4,10])
- l'utilisateur peut rechercher des valeurs inférieurs ou égal,  ex les produits de rating inférieur ou egal à '10' (rating=[,10])
- l'utilisateur peut rechercher des valeurs supérieurs ou égal,  ex les produits de rating séperieur ou égal à '4' (rating=[4,])

Sur les valaurs de temps:
- l'utilisateur peut rechercher une valeur fixe (createdat=04-04-2020)
- l'utilisateur peut rechercher plusieurs valeurs,  ex les produits créés le 04/04/2020 ou le 05/05/2020 (createdat=04-04-2020,05-05-2020)
- l'utilisateur peut rechercher des fourchettes de valeurs,  ex les produits créés entre le 04/04/2020 et le 05/05/2020 (createdat=[04-04-2020,05-05-2020])
- l'utilisateur peut rechercher des valeurs inférieurs ou égal,  ex les produits créés avant le 05/05/2020 (createdat=[,05-05-2020])
- l'utilisateur peut rechercher des valeurs supérieurs ou égal,  ex les produits créés après le 04/04/2020 (createdat=[04-04-2020,])

## Recherche

Vous devrez inclure dans votre librairie une recherche générique sous la forme suivante: http://xxxxx/products/search?name=*napoli*&type=pizza,pate&sort=rating,name


## Tests unitaires

Un  test unitaire devra être réalisé pour chaque controller.

## Web API

Vous devrez réaliser la doc de l'API avec SwaggerUI [aide](https://swagger.io/swagger-ui/)



# Groupes et fonctionnement

Le projet est a développé en groupe de 3 ou 4 personnes.
Tous les groupes seront définis en cours.

Au sein d'un groupe, les personnes se répartiront les tâches pour le projet, de façon équitable.  Il est explicitement exigé que chaque membre consacre au moins 50% de son travail à du développement technique. Du code de test est acceptable, tant qu'il ne constitue pas l'intégralité de la réalisation technique du membre du groupe.

Les étudiants sont encouragés (mais pas obligés) à mettre en place un système de contrôle des sources de type Git ou équivalent, afin d'affecter et partager efficacement les fichiers de codes et autres composants numériques du projet (fichiers sources, descripteurs de déploiement, documents de recherche, cas d'utilisation, suites de tests, etc.).

# Soutenance et rendu

La soutenance aura lieux le vendredi 26 novembre 2021.
Les horaires de passage sont définis pour chaque groupe.
Toute absence à la soutenance entrainera un 0 (ZERO) pour le membre du groupe.

Les rendus doivent figurer sur un seul compte par groupe.
Le rendu s'effectu via un repos GIT ou SVN. L'adresse du rendu est envoyé par mail.
Le mail de rendu est vincent.leclerc@edu.esiee-it.fr
Les fichiers rendus doivent contenir
  - L'arborescence du projet, immédiatement exploitable après création des bases de données et exécution des migrations.
  - Un AUTHORS.TXT listant les membres du groupe (prénom, nom), à raison d'un par ligne.  Il liste ensuite les responsabilités effectives de chacun dans le groupe.
Le sujet du mail doit contenir votre section ainsi que le nom du projet.
Les fichiers rendus peuvent aussi comprendre: 
  - Des documents de recherche créés pour le projet et fournissant plus de détails pour l'enseignant.
Pour tout autre type de fichier, veuillez demander à l'enseignant si son inclusion est appropriée.
La soutenance dure 20 minutes durant lesquelles les membres présentent leur travail. Un échange de questions peut se faire entre le professeur et les membres du groupe.


Les horaires de passage des groupes sont les suivants:

- 14h00 =>
- 14h30 =>
- 14h50 =>
- 15h10 =>
- 15h30 =>
- 16h00 =>
- 16h20 =>