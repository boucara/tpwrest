package api_rest

class BootStrap {

    def init = { servletContext ->
        def bu1=new Bibliotheque(nom:"saintJean",adresse:"Avenue François Mitterrand",anneConstructor:200)
        bu1.addToLivres(new Livre(nom:"toto", dateApparution: new Date(),isbn:"titi",auteur:"Jean"))
        bu1.addToLivres(new Livre(nom:"toto", dateApparution: new Date(),isbn:"titi",auteur:"Jean"))
        bu1.addToLivres(new Livre(nom:"toto", dateApparution: new Date(),isbn:"titi",auteur:"Jean"))
        bu1.addToLivres(new Livre(nom:"toto", dateApparution: new Date(),isbn:"titi",auteur:"Jean"))
        bu1.addToLivres(new Livre(nom:"toto", dateApparution: new Date(),isbn:"titi",auteur:"Jean"))
        bu1.save(flush:true, failOnError:true )

       /* def bu2=new Bibliotheque(nom:"saintJean",adress:"Avenue François Mitterrand",200)
        bu2.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu2.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu2.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu2.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))

        def bu3=new Bibliotheque(nom:"saintJean",adress:"Avenue François Mitterrand",200)
        bu3.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu3.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu3.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu3.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))

        def bu4=new Bibliotheque(nom:"saintJean",adress:"Avenue François Mitterrand",200)
        bu4.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu4.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu4.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu4.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))

        def bu5=new Bibliotheque(nom:"saintJean",adress:"Avenue François Mitterrand",200)
        bu5.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu5.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu5.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
        bu5.add(new Livre("Roman", date:Date.newInstance(),"tata","Mira"))
*/
    }

}
