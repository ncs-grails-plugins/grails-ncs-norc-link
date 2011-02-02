package edu.umn.ncs

class BatchLink {

    Batch batch
    Date dateNorcNotified

    static constraints = {
        batch()
        dateNorcNotified(nullable:true)
    }
}
