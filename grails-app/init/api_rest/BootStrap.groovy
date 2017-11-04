package api_rest

class BootStrap {

    def init = { servletContext ->
        /* definition des bibliotheques*/

        def bu1=new Bibliotheque(nom:"SaintJean",adresse:"Avenue François Mitterrand",anneConstructor:1990)
        def bu2=new Bibliotheque(nom:"Bibliotheque de la sorbone",adresse:"Paris",anneConstructor:1989)
        def bu3=new Bibliotheque(nom:"Cujas",adresse:"Paris",anneConstructor:1970)
        def bu4=new Bibliotheque(nom:"Lettre",adresse:"Nice",anneConstructor:1978)
        def bu5=new Bibliotheque(nom:"Genevieve",adresse:"Paris",anneConstructor:1980)

        /* ajout des livres dans les bibliotheques*/

        bu1.addToLivres(new Livre(nom:"Le monde seffondre", dateApparution: new Date(),isbn:"1231",auteur:"Chinua Achebe"))
        bu1.addToLivres(new Livre(nom:"Contes", dateApparution: new Date(),isbn:"1232",auteur:"Hans Christian Andersen"))
        bu1.addToLivres(new Livre(nom:"Orgueil et prejuges", dateApparution: new Date(),isbn:"1233",auteur:"Jane Austen"))
        bu1.addToLivres(new Livre(nom:"Le Pere Goriot", dateApparution: new Date(),isbn:"1234",auteur:"Honore de Balzac"))
        bu1.addToLivres(new Livre(nom:" Trilogie", dateApparution: new Date(),isbn:"1235",auteur:"Samuel Beckett"))

        bu2.addToLivres(new Livre(nom:"Madame Bovary", dateApparution: new Date(),isbn:"1236",auteur:"Gustave Flauver"))
        bu2.addToLivres(new Livre(nom:"Decameron", dateApparution: new Date(),isbn:"1236",auteur:"Boccace"))
        bu2.addToLivres(new Livre(nom:"Fictions", dateApparution: new Date(),isbn:"1237",auteur:"Jorge Luis Borges"))
        bu2.addToLivres(new Livre(nom:"Les Hauts de Hurlevement", dateApparution: new Date(),isbn:"1238",auteur:"Emily Bronte"))
        bu2.addToLivres(new Livre(nom:"Faust", dateApparution: new Date(),isbn:"1238",auteur:"Johan Wolfgang"))


        bu3.addToLivres(new Livre(nom:"Voyage au bout de la nuit", dateApparution: new Date(),isbn:"1239",auteur:"Louis Ferdinand Céline"))
        bu3.addToLivres(new Livre(nom:"Don Quichotte", dateApparution: new Date(),isbn:"1241",auteur:"Miguel de Cervantes"))
        bu3.addToLivres(new Livre(nom:"Les Contes de Canterbury", dateApparution: new Date(),isbn:"1242",auteur:"Geoffrey Chaucer"))
        bu3.addToLivres(new Livre(nom:"Nostromo", dateApparution: new Date(),isbn:" 1243",auteur:"Joseph Conrad"))
        bu3.addToLivres(new Livre(nom:"Le Tambour", dateApparution: new Date(),isbn:" 1243",auteur:"Gunter Grass"))



        bu4.addToLivres(new Livre(nom:"Divine Comedie", dateApparution: new Date(),isbn:"1243",auteur:"Dante Alighieri"))
        bu4.addToLivres(new Livre(nom:"Les Grandes Esperances", dateApparution: new Date(),isbn:"1244",auteur:"Charles Dickens"))
        bu4.addToLivres(new Livre(nom:"Jacques le fataliste", dateApparution: new Date(),isbn:"1245",auteur:"Denis Diderot"))
        bu4.addToLivres(new Livre(nom:"Berlin Alexanderplatz", dateApparution: new Date(),isbn:"1246",auteur:"ALfred Doblin"))
        bu4.addToLivres(new Livre(nom:"La Faim", dateApparution: new Date(),isbn:"1246",auteur:"Knut Hamsun"))


        bu5.addToLivres(new Livre(nom:"Crime et chatiment", dateApparution: new Date(),isbn:"1247",auteur:"Fiodor Dostoievski"))
        bu5.addToLivres(new Livre(nom:"Lidiot", dateApparution: new Date(),isbn:"1248",auteur:"Fiodor Dostoievski"))
        bu5.addToLivres(new Livre(nom:"Middlemarch", dateApparution: new Date(),isbn:"1249",auteur:"George Eliot"))
        bu5.addToLivres(new Livre(nom:"Medee", dateApparution: new Date(),isbn:"1251",auteur:"Euripide"))
        bu5.addToLivres(new Livre(nom:"Lliade", dateApparution: new Date(),isbn:"1251",auteur:"Homere"))

        /*enregistrement des ressources dans la bases de données*/
        bu1.save(flush:true, failOnError:true )
        bu2.save(flush:true, failOnError:true )
        bu3.save(flush:true, failOnError:true )
        bu4.save(flush:true, failOnError:true )
        bu5.save(flush:true, failOnError:true )

        /*  les utilisateurs ayant accés à des requétes sur  les ressources bibliothéque et Livre*/

        def role = new Authority(authority:"ROLE_USER").save flush:true

        def user1 = new User(username:"toto",password:"pwd1").save flush:true
        def user2 = new User(username:"aicha",password:"0000").save flush:true
        def user3 = new User(username:"traore",password:"0001").save flush:true

        UserAuthority.create(user1,role)
        UserAuthority.create(user2,role)
        UserAuthority.create(user3,role)

    }

}
