package com.ll.domain.wiseSaying.controller

import com.ll.domain.wiseSaying.service.WiseSayingService
import com.ll.global.rq.Rq

class WiseSayingController {
    private val wiseSayingService = WiseSayingService()

    fun create() {
        print("명언 : ")
        val content = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        val wiseSaying = wiseSayingService.create(content, author)

        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun list() {
        println("번호 / 작가 / 명언")
        println("----------------------")
        for (wiseSaying in wiseSayingService.findAll()) {
            println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}")
        }
    }

    fun delete(rq: Rq) {
        val id = rq.getParamAsInt("id", null) ?: run {
            println("id를 정확히 입력해주세요.")
            return
        }

        val deleted = wiseSayingService.delete(id)
        if (deleted) println("${id}번 명언이 삭제되었습니다.")
        else println("${id}번 명언은 존재하지 않습니다.")
    }

    fun modify(rq: Rq) {
        val id = rq.getParamAsInt("id", null) ?: run {
            println("id를 정확히 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService.findById(id) ?: run {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${wiseSaying.content}")
        print("명언 : ")
        val content = readlnOrNull()!!.trim()

        println("작가(기존) : ${wiseSaying.author}")
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        wiseSayingService.modify(wiseSaying, content, author)
    }
}