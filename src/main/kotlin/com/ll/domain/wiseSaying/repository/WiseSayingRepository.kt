package com.ll.domain.wiseSaying.repository

import com.ll.domain.wiseSaying.entity.WiseSaying
import com.ll.standard.page.Page
import com.ll.standard.page.Pageable

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

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    fun delete(wiseSaying: WiseSaying): Boolean {
        return wiseSayings.remove(wiseSaying)
    }

    private fun createPage(items: List<WiseSaying>, pageable: Pageable): Page<WiseSaying> {
        val totalCount: Int = items.size

        return items.reversed()
            .drop(pageable.getSkipCount().toInt())
            .take(pageable.pageSize)
            .let { Page(totalCount, pageable.pageNum, pageable.pageSize, it) }
    }

    fun findAll(pageable: Pageable): Page<WiseSaying> {
        return createPage(wiseSayings, pageable)
    }

    fun findForListByContent(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.content.contains(keyword) }
        return createPage(filtered, pageable)
    }

    fun findForListByAuthor(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.author.contains(keyword) }
        return createPage(filtered, pageable)
    }

    fun findForListByContentOrAuthor(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.author.contains(keyword) || it.content.contains(keyword) }
        return createPage(filtered, pageable)
    }
}