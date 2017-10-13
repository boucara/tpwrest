package api_rest

class Bibliotheque {
    String nom
    String adresse
    Integer anneConstructor
    static hasMany = [livres:Livre]
    static constraints = {
        nom blank:false
        adresse blank:false
        anneConstructor nullable:false


    }
}
