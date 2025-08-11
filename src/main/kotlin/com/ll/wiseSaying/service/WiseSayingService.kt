package com.ll.wiseSaying.service

import com.ll.wiseSaying.entity.WiseSaying
import com.ll.wiseSaying.repository.WiseSayingRepository

class WiseSayingService {
    private val wiseSayingRepository = WiseSayingRepository()

    fun create(content: String, author: String): WiseSaying {
        val wiseSaying = WiseSaying(content, author)
        wiseSayingRepository.save(wiseSaying)

        return wiseSaying
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun delete(wiseSaying: WiseSaying): Boolean {
        return wiseSayingRepository.delete(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, content: String, author: String) {
        wiseSaying.content = content
        wiseSaying.author = author

        wiseSayingRepository.save(wiseSaying)
    }
}