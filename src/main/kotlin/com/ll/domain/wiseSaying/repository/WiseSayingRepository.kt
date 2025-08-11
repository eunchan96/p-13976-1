package com.ll.domain.wiseSaying.repository

import com.ll.domain.wiseSaying.entity.WiseSaying

class WiseSayingRepository {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.id == 0) {
            wiseSaying.id = ++lastId
            wiseSayings.add(wiseSaying)
        }
        return wiseSaying
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayings.reversed()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    fun delete(wiseSaying: WiseSaying): Boolean {
        return wiseSayings.remove(wiseSaying)
    }
}