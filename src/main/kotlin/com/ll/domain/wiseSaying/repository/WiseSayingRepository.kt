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

    fun findAll(pageable: Pageable): Page<WiseSaying> {
        val totalCount = wiseSayings.size

        return wiseSayings.reversed()
            .drop(pageable.getSkipCount().toInt())
            .take(pageable.pageSize)
            .let { Page(totalCount, pageable.pageNum, pageable.pageSize, it) }
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    fun delete(wiseSaying: WiseSaying): Boolean {
        return wiseSayings.remove(wiseSaying)
    }

    fun findForListByContent(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.content.contains(keyword) }
        val totalCount = filtered.size

        return filtered.reversed()
            .drop(pageable.getSkipCount().toInt())
            .take(pageable.pageSize)
            .let { Page(totalCount, pageable.pageNum, pageable.pageSize, it) }
    }

    fun findForListByAuthor(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.author.contains(keyword) }
        val totalCount = filtered.size

        return filtered.reversed()
            .drop(pageable.getSkipCount().toInt())
            .take(pageable.pageSize)
            .let { Page(totalCount, pageable.pageNum, pageable.pageSize, it) }
    }

    fun findForListByContentOrAuthor(keyword: String, pageable: Pageable): Page<WiseSaying> {
        val filtered = wiseSayings.filter { it.author.contains(keyword) || it.content.contains(keyword) }
        val totalCount = filtered.size

        return filtered.reversed()
            .drop(pageable.getSkipCount().toInt())
            .take(pageable.pageSize)
            .let { Page(totalCount, pageable.pageNum, pageable.pageSize, it) }
    }
}