package com

class App {
    var lastId = 0

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val cmd = readLine()

            when (cmd) {
                "종료" -> return
                "등록" -> create()
            }
        }
    }

    private fun create() {
        print("명언 : ")
        val content = readLine()
        print("작가 : ")
        val author = readLine()

        println("${++lastId}번 명언이 등록되었습니다.")
    }
}