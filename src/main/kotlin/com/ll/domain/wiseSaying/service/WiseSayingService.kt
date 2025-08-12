package com.ll.domain.wiseSaying.service

import com.ll.domain.wiseSaying.entity.WiseSaying
import com.ll.domain.wiseSaying.repository.WiseSayingRepository

class WiseSayingService {
    private val wiseSayingRepository = WiseSayingRepository()

    fun create(content: String, author: String): WiseSaying {
        val wiseSaying = WiseSaying(content, author)
        return wiseSayingRepository.save(wiseSaying)
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun delete(id: Int): Boolean {
        val wiseSaying = wiseSayingRepository.findById(id) ?: return false
        return wiseSayingRepository.delete(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, content: String, author: String) {
        wiseSaying.content = content
        wiseSaying.author = author

        wiseSayingRepository.save(wiseSaying)
    }

    fun findForList(keywordType: String, keyword: String): List<WiseSaying> {
        if (keywordType == "all") return wiseSayingRepository.findAll()
        return when (keywordType) {
            "content" -> wiseSayingRepository.findForListByContent(keyword)
            "author" -> wiseSayingRepository.findForListByAuthor(keyword)
            else -> wiseSayingRepository.findForListByContentOrAuthor(keyword)
        }
    }
}