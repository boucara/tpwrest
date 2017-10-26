package api_rest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/biblio/${id}/livres" (controller:"api",action:"ressourcesLies")
        "/biblio/${id}/livre/" (controller:"api",action:"ressourcesLies")
        "/biblio/${id}/livres/livre/" (controller:"api",action:"lectureLivreBu")
        "/livre"(controller:"api",action:"livre")
        "/bibliotheque"(controller:"api",action:"bibliotheque")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
