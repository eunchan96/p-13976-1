package com.wiseSaying.entity

class WiseSaying {
    var id: Int = 0
    var content: String = ""
    var author: String = ""

    constructor(id: Int, content: String, author: String) {
        this.id = id
        this.content = content
        this.author = author
    }
}