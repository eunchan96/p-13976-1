package com.ll.wiseSaying.entity

class WiseSaying {
    var id: Int = 0
    var content: String = ""
    var author: String = ""

    constructor(content: String, author: String) {
        this.content = content
        this.author = author
    }
}