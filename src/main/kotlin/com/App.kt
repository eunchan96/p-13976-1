package com

import com.wiseSaying.entity.WiseSaying

class App {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val cmd = readLine()

            when (cmd) {
                "종료" -> return
                "등록" -> create()
                "목록" -> list()
            }
        }
    }

    private fun create() {
        print("명언 : ")
        val content = readLine()
        print("작가 : ")
        val author = readLine()

        val wiseSaying = WiseSaying(++lastId, content ?: "", author ?: "")
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
}