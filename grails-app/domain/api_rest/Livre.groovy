package api_rest

class Livre {
    String nom
    Date dateApparution
    String isbn
    String auteur
   static  belongsTo = [bu:Bibliotheque]
    static constraints = {
        nom         blank: false
        isbn        blank:false
        auteur      blank:false
        dateApparution nullable:false
    }
}
