package com.techmania.jalsahay.models

class User {
    var name: String = ""
    var email: String = ""
    var password: String = ""

    constructor()
    constructor(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
    }

}