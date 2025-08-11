package com

import com.wiseSaying.entity.WiseSaying

class App {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val rq = readlnOrNull()!!.trim()
            val cmd = rq.split("?")

            when (cmd[0]) {
                "종료" -> return
                "등록" -> create()
                "목록" -> list()
                "삭제" -> delete(cmd)
            }
        }
    }

    private fun create() {
        print("명언 : ")
        val content = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        val wiseSaying = WiseSaying(++lastId, content, author)
        wiseSayings.add(wiseSaying)

        println("${lastId}번 명언이 등록되었습니다.")
    }

    private fun list() {
        println("번호 / 작가 / 명언")
        println("----------------------")
        for (wiseSaying in findAll()) {
            println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}")
        }
    }

    private fun findAll(): List<WiseSaying> {
        return wiseSayings.reversed()
    }

    private fun delete(cmd: List<String>) {
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
}