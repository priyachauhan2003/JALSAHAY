package com.techmania.jalsahay.models

class User {
    var name: String = ""
    var email: String = ""
    var password: String = ""
    var image: String ?= null

    constructor()
    constructor(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
    }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor(name: String, email: String, password: String, image: String?) {
        this.name = name
        this.email = email
        this.password = password
        this.image = image
    }


}