package api_rest

import grails.converters.JSON
import grails.converters.XML

class ApiController {

    def livre() {
        switch(request.getMethod()){
            case "POST":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"cannot attach a book to a non existant bu(${params.bibliotheque.id})")
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


                            response.status = 200
                    }
                }
                else
                    response.status =   400
                break;
            case "GET":
                def livreInstance = Livre.get(params.id)
                if(livreInstance!=null){
                    switch (request.getHeader('Accept')){
                            case 'JSON':
                                render livreInstance as JSON
                                break;
                            case 'XML':
                                render livreInstance as XML
                                break;
                                response.status = 200
                    }
                }
                else
                    response.status = 400
                break;
            case "PUT":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"cannot attach a book to a non existant bu(${params.bibliotheque.id})")
                    return
                }
                def livreInstance=Livre.get(params.livre.id)
                if( livreInstance!=null) {
                    if(params.nom!=null && params.dateApparution==null && params.isbn==null && params.auteur==null  ) {
                        livreInstance.nom = params.nom
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
                    }
                     if(params.nom==null && params.dateApparution!=null && params.isbn==null && params.auteur==null  ) {
                        livreInstance.dateApparution = params.dateApparution
                        if (livreInstance.save(flush:true) ){
                            switch (request.getHeader('Accept')) {
                                case 'JSON':
                                    render livreInstance as JSON
                                    break;
                                case 'XML':
                                    render livreInstance as XML
                                    break;
                                    response.status = 200
                            }
                        } else
                            response.status = 400
                    }
                    if(params.nom==null && params.dateApparution==null && params.isbn!=null && params.auteur==null  ) {
                        livreInstance.isbn = params.isbn
                        if (livreInstance.save(flush:true) ){
                            switch (request.getHeader('Accept')) {
                                case 'JSON':
                                    render livreInstance as JSON
                                    break;
                                case 'XML':
                                    render livreInstance as XML
                                    break;
                                    response.status = 200
                            }
                            response.status = 200
                        } else
                            response.status = 400
                    }
                     if(params.nom==null && params.dateApparution==null && params.isbn==null && params.auteur!=null  ) {
                        livreInstance.auteur = params.auteur
                        if (livreInstance.save(flush: true)) {
                            response.status = 200
                            switch (request.getHeader('Accept')) {
                                case 'JSON':
                                    render livreInstance as JSON
                                    break;
                                case 'XML':
                                    render livreInstance as XML
                                    break;
                                    response.status = 200
                            }
                        } else
                            response.status = 400
                    }
                    if(params.nom!=null && params.dateApparution!=null && params.isbn!=null && params.auteur!=null  ) {
                        livreInstance.auteur = params.auteur
                        livreInstance.dateApparution= params.dateApparution
                        livreInstance.isbn=params.isbn
                        livreInstance.auteur=auteur
                        if (livreInstance.save(flush: true)) {
                            switch (request.getHeader('Accept')) {
                                case 'JSON':
                                    render livreInstance as JSON
                                    break;
                                case 'XML':
                                    render livreInstance as XML
                                    break;
                                    response.status = 200
                            }
                            response.status = 200
                        } else
                            response.status = 400
                    }
                }
                break ;
                case "DELETE":
                    if(!Bibliotheque.get(params.bu.id)){
                        render (status: 400, text:"cannot attach a book to a non existant bu(${params.bibliotheque.id})")
                        return
                    }
                    Bibliotheque bibliothequeInstance = Bibliotheque.get(params.bu.id);
                    if(!Livre.get(params.livre.id)){
                        render (status: 400, text:"ce  livre n'existe pas (${params.livre.id})")
                        return
                    }
                    def livreInstance = Livre.get(params.livre.id)
                    bibliothequeInstance.getLivres().remove(livreInstance)
                    livreInstance.delete(flush:true)
                        response.status = 200
                    render "livre bien supprimé"
                    break;



            default:
                response.status = 405
                break;
        }

    }
    def bibliotheque(){
        switch(request.getMethod()) {
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

            case "GET":
                def buInstance = Bibliotheque.get(params.id)
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
                else
                    response.status = 400
                break;
            case "PUT":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"cannot attach a librairie to a non existant bu(${params.bibliotheque.id})")
                    return
                }
                def bibliothequeInstance = Bibliotheque.get(params.bu.id);
                if(params.nom!=null && params.adresse == null && params.anneConstructor == null){
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
                }
                if(params.nom==null && params.adresse!= null && params.anneConstructor == null){
                    bibliothequeInstance.adresse=params.adresse
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
                }
                if(params.nom==null && params.adresse == null && params.anneConstructor != null){
                    bibliothequeInstance.anneConstructor= Integer.parseInt(params.anneConstructor)
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
                }

                break;
            case"DELETE":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"cannot attach a librairie to a non existant bu(${params.bibliotheque.id})")
                    return
                }
               def  bibliothequeInstance = Bibliotheque.get(params.bu.id)
                bibliothequeInstance.delete(flush:true)
                    response.status = 200
                    render"La bibliotheque a été bien supprimer"


            default:
                response.status = 405
                break;
        }
    }
    def ressourcesLies(){
        switch(request.getMethod()){
            case"GET":
                if(!Bibliotheque.get(params.bu.id)){
                    render (status: 400, text:"cannot attach a librairie to a non existant bu(${params.bibliotheque.id})")
                    return
                }
                def bibliothequeInstance = Bibliotheque.get(params.bu.id)
                def livreInstance =bibliothequeInstance.getLivres()
                    if(livreInstance!=null){
                    switch (request.getHeader('Accept')) {
                        case 'JSON':
                            render  livreInstance as JSON
                            break;
                        case 'XML':
                            render  livreInstance as XML
                            break;

                    }

                }

        }
    }
}
