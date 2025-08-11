package com.ll.wiseSaying.service

import com.ll.wiseSaying.entity.WiseSaying
import com.ll.wiseSaying.repository.WiseSayingRepository

class WiseSayingService {
    private val wiseSayingRepository = WiseSayingRepository()

    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun create(content: String, author: String): WiseSaying {
        val wiseSaying = WiseSaying(++lastId, content, author)
        wiseSayings.add(wiseSaying)

        return wiseSaying
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayings.reversed()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    private fun findIndexById(id: Int): Int {
        return wiseSayings.indexOfFirst { it.id == id }
    }

    fun delete(id: Int): WiseSaying? {
        val index = findIndexById(id)
        return wiseSayings.removeAt(index)
    }

    fun modify(id: Int, content: String, author: String): WiseSaying? {
        val index = findIndexById(id)
        if (index == -1) return null

        val wiseSaying = wiseSayings[index]
        wiseSaying.content = content
        wiseSaying.author = author

        return wiseSaying
    }
}