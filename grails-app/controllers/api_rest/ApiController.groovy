package api_rest

import grails.converters.JSON
import grails.converters.XML
import grails.web.servlet.mvc.GrailsParameterMap
import jdk.nashorn.internal.ir.RuntimeNode

class ApiController {

    def livre() {
        switch(request.getMethod()){
            case "GET":
                def livreInstance = Livre.get(params.livreid)
                if(livreInstance!=null){
                    switch (request.getHeader('Accept')){
                            case 'JSON':
                                render livreInstance as JSON
                                break;
                            case 'XML':
                                render livreInstance as XML
                                break;
                                render (status: 200, text:"requéte traitée avec succés")
                    }
                }
                else
                    render (status: 404, text:"La ressource livre demandé n'existe pas")
                break;
            case "PUT":
                if(!Livre.get(params.livreid)){
                    render (status: 404, text:"Livre inexistant")
                    return
                }
                def livreInstance=Livre.get(params.livreid)
                if(params.auteur!=null)
                        livreInstance.auteur = params.auteur
                if(params.dateApparution!=null)
                        livreInstance.dateApparution= Date.parse("dd-MM-yy",params.dateApparution.toString())
                if(params.isbn!=null)
                        livreInstance.isbn=params.isbn
                if(params.nom!=null)
                    livreInstance.nom=params.nom
                if (livreInstance.save(flush:true) ){
                        response.status = 200
                        switch (request.getHeader('Accept')) {
                            case 'JSON':
                                render livreInstance as JSON
                                break;
                            case 'XML':
                                render livreInstance as XML
                                break;
                        }
                    } else
                        response.status = 400

                break ;
                case "DELETE":
                    if(params.bu.id==null){
                        render(status: 400,text:" Pour effectuer cette operation veuillez préciser l'identifiant de la Bibliothéque  à la quelle le livre  (${params.livreid}) est rattaché")
                        return
                    }
                    if(!Bibliotheque.get(params.bu.id)){
                        render (status: 400, text:"cannot attach a book to a non existant bu(${params.bu.id})")
                        return
                    }
                    Bibliotheque bibliothequeInstance = Bibliotheque.get(params.bu.id);
                    if(!Livre.get(params.livreid)){
                        render (status: 400, text:"Le livre  (${params.livreid}) n'existe pas")
                        return
                    }
                    def livreInstance = Livre.get(params.livreid)
                    bibliothequeInstance.getLivres().remove(livreInstance)
                    livreInstance.delete(flush:true)
                       render(status:204, text:"Requête traitée avec succès mais pas d’information à renvoyer.")
                    break;

            default:
                response.status = 405
                break;
        }

    }
    def livres(){
        switch(request.getMethod()){
            case "POST":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"Tu ne peux pas rattacher un livre à une bibliotheque qui n'existe pas(${params.bibliotheque.id})")
                    return
                }
                def livreInstance = new Livre(params)
                if(livreInstance.save(flush:true)){
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render livreInstance as JSON
                            break;
                        case 'XML':
                            render livreInstance as XML
                            break;
                            render (status: 201, text:"Le livre a bien été crée")
                    }
                }
                else
                    render(status: 400, text:"Revoie la syntaxe de ta requéte , elle est incorrecte")
                break;
            case "GET":
                def livreInstance=Livre.getAll()
                if(livreInstance!=null){
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render livreInstance as JSON
                            break;
                        case 'XML':
                            render livreInstance as XML
                            break;


                            response.status = 200
                    }
                }
                else{
                    response.status=400
                    render " aucun livre"
                }
                break;
            default:
                response.status = 405
                break;
        }

    }
    def bibliotheque(){
        switch(request.getMethod()) {
            case "GET":
                def buInstance = Bibliotheque.get(params.buid)
                if(buInstance!=null){
                    switch (request.getHeader('Accept')){
                        case 'JSON':
                            render buInstance as JSON
                            break;
                        case 'XML':
                            render buInstance as XML
                            break;
                            response.status = 200
                    }
                }
                else{
                    response.status = 404
                    render("La ressource bibliothéque que vous voulez lire n'existe pas")

                }

                break;
            case "PUT":
                if(!Bibliotheque.get(params.buid)){
                    render (status: 404, text:"cannot attach a librairie to a non existant bu(${params.buid})")
                    return
                }
                def bibliothequeInstance = Bibliotheque.get(params.buid);
                if(params.anneConstructor!=null)
                    bibliothequeInstance.anneConstructor= Integer.parseInt(params.anneConstructor)
                if(params.adresse!=null)
                    bibliothequeInstance.adresse=params.adresse
                if(params.nom!=null)
                    bibliothequeInstance.nom=params.nom

                if(bibliothequeInstance.save(flush:true)){
                    response.status=200
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render  bibliothequeInstance as JSON
                            break;
                        case 'XML':
                            render  bibliothequeInstance as XML
                            break;
                            response.status = 200
                    }
                }
                else  response.status = 400

                break;
            case"DELETE":
                if(!Bibliotheque.get(params.buid)){
                    render (status: 400, text:"La bibliothéque(${params.buid}) n'existe pas")
                    return
                }
               def  bibliothequeInstance = Bibliotheque.get(params.buid)
                bibliothequeInstance.delete(flush:true)
                render(status:204, text:"Requête traitée avec succès mais pas d’information à renvoyer.")


            default:
                response.status = 405
                break;
        }
    }
    def bibliotheques(){
        switch (request.getMethod()){
            case "POST":
                def buInstance = new Bibliotheque(params)
                if (buInstance.save(flush: true)) {
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render buInstance as JSON
                            break;
                        case 'XML':
                            render buInstance as XML
                            break;


                            response.status = 200
                    }
                } else
                    response.status = 400
                break;
            case"GET":
                def bibliothequeInstance = Bibliotheque.getAll()
                if(bibliothequeInstance!=null){
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render bibliothequeInstance as JSON
                            break;
                        case 'XML':
                            render bibliothequeInstance as XML
                            break;


                            response.status = 200
                    }
                }
                else {
                    response.status=400
                    render"aucune BU"
                }
                break;
            default:
                response.status = 405
                break;

        }
    }
    def ressourcesLies(){
        switch(request.getMethod()) {
            case"GET":
                def bibliothequeInstance= Bibliotheque.get(params.buid)
                if(bibliothequeInstance==null){
                    render(status: 404, text:"cannot attach a librairie to a non existant bu (${params.bibliotheque.id})")
                    return
                }
                def livreInstance =bibliothequeInstance.livres.find {it.id==Integer.parseInt(params.livreid)}

                if(livreInstance!=null){
                    response.status=200
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render livreInstance as JSON
                            break;
                        case 'XML':
                            render livreInstance as XML
                            break;
                    }
                } else
                    render(status: 404, text: " Le livre (${params.livreid}) n'existe dans la bibliotheque (${params.buid})")


                break;

            case "PUT":
                def bibliothequeInstance= Bibliotheque.get(params.buid)
                if (bibliothequeInstance == null) {
                    render(status: 404, text: "cannot attach a librairie to a non existant (${params.buid})")
                    return
                }

                def livreInstance= Livre.get(params.livreid)
                if (bibliothequeInstance.getLivres().contains(livreInstance)) {
                    if(params.auteur!=null)
                        livreInstance.auteur = params.auteur
                    if(params.dateApparution!=null)
                        livreInstance.dateApparution= Date.parse("dd-MM-yy",params.dateApparution.toString())
                    if(params.isbn!=null)
                        livreInstance.isbn = params.isbn
                    if(params.nom!=null)
                        livreInstance.nom = params.nom
                    if (livreInstance.save(flush: true)) {
                        response.status = 200
                        switch (request.getHeader('Accept')) {
                            case 'JSON':
                                render livreInstance as JSON
                                break;
                            case 'XML':
                                render livreInstance as XML
                                break;
                        }
                    } else render(status: 400, text: "le livre(${params.livreid}) n'a pas pu étre sauvegarder dans la bibliotheque revoyez la requéte(${params.buid})")



                } else
                    render(status: 404, text: "le livre(${params.livreid}) ne se trouve pas dans la bu(${params.buid})")

                break;

            case"DELETE":
                def bibliothequeInstance= Bibliotheque.get(params.buid)
                if(bibliothequeInstance==null){
                    render(status: 400, text:"la bibliothéque (${params.buid}) n'existe pas")
                    return
                }
                def livreInstance = Livre.get(params.livreid)
                if(bibliothequeInstance.getLivres().contains(livreInstance)){
                    bibliothequeInstance.getLivres().remove(livreInstance)
                    livreInstance.delete(flush: true)
                    render(status:204, text:"Requête traitée avec succès mais pas d’information à renvoyer.")
                }
                else{
                    render(status:400, text:"le livre (${params.livreid}) n'existe pas dans la bibliotheque (${params.buid}) .")

                }
                break;
            default:
                response.status = 405
                break;
        }
    }
    def livreBu(){
        switch(request.getMethod()) {
            case "GET":
                def bibliothequeInstance= Bibliotheque.get(params.buid)
                if (bibliothequeInstance == null) {
                    render(status: 404, text: "cannot attach a librairie to a non existant")
                    return
                }

                def livreInstance = bibliothequeInstance.getLivres()
                if (livreInstance != null) {
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render livreInstance as JSON
                            break;
                        case 'XML':
                            render livreInstance as XML
                            break;

                    }


                }
            case"POST":
                def bibliothequeInstance= Bibliotheque.get(params.buid)
                if(bibliothequeInstance==null){
                    render(status: 400, text: "la bibliotheque(${params.buid}) n'existe pas")
                    return
                }
                def livreInstance = new Livre(params)
                if(bibliothequeInstance.addToLivres(livreInstance)){
                    if(bibliothequeInstance.save(flush:true)){

                        response.status=200
                        switch (request.getHeader('Accept')) {
                            case 'JSON':
                                render livreInstance as JSON
                                break;
                            case 'XML':
                                render livreInstance as XML
                                break;
                        }
                    } else
                        response.status=400
                }
                else render("erreur syntaxe")
                break;
            default:
                response.status = 405
                break;


        }


    }


    }






