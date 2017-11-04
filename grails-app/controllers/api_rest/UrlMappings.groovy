package api_rest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        /*acces aux livres*/
        "/api/livre/${livreid}/"(controller:"api",action:"livre")
        "/api/livres"(controller:"api",action:"livres")

        /*acces à un ou plusieurs livre dune BU*/

        "/api/bibliotheque/${buid}/livres/"(controller:"api",action:"livreBu")
        "/api/bibliotheque/${buid}/livre/${livreid}/"(controller:"api",action:"ressourcesLies")

        /*acces aux BU*/
        "/api/bibliotheque/${buid}/"(controller:"api",action:"bibliotheque")
        "/api/bibliotheques"(controller:"api",action:"bibliotheques")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
