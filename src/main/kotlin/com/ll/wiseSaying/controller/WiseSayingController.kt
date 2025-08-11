package com.ll.wiseSaying.controller

import com.ll.wiseSaying.entity.WiseSaying
import com.ll.wiseSaying.service.WiseSayingService

class WiseSayingController {
    private val wiseSayingService = WiseSayingService()

    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun create() {
        print("명언 : ")
        val content = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        val wiseSaying = WiseSaying(++lastId, content, author)
        wiseSayings.add(wiseSaying)

        println("${lastId}번 명언이 등록되었습니다.")
    }

    fun list() {
        println("번호 / 작가 / 명언")
        println("----------------------")
        for (wiseSaying in findAll()) {
            println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}")
        }
    }

    private fun findAll(): List<WiseSaying> {
        return wiseSayings.reversed()
    }

    fun delete(cmd: List<String>) {
        if (cmd.size < 2) {
            println("삭제할 명언의 번호를 입력해주세요.")
            return
        }

        val params = cmd[1].split("=")
        if (params.size < 2 || params[0] != "id" || params[1].isBlank()) {
            println("잘못된 명령입니다.")
            return
        }

        val id = params[1].toIntOrNull()
        val wiseSaying = wiseSayings.find { it.id == id } ?: run {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        wiseSayings.remove(wiseSaying)
        println("${id}번 명언이 삭제되었습니다.")
    }

    fun modify(cmd: List<String>) {
        if (cmd.size < 2) {
            println("수정할 명언의 번호를 입력해주세요.")
            return
        }

        val params = cmd[1].split("=")
        if (params.size < 2 || params[0] != "id" || params[1].isBlank()) {
            println("잘못된 명령입니다.")
            return
        }

        val id = params[1].toIntOrNull()
        val wiseSaying = wiseSayings.find { it.id == id } ?: run {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${wiseSaying.content}")
        print("명언 : ")
        wiseSaying.content = readlnOrNull()!!.trim()

        println("작가(기존) : ${wiseSaying.author}")
        print("작가 : ")
        wiseSaying.author = readlnOrNull()!!.trim()

        println("${id}번 명언이 수정되었습니다.")
    }
}