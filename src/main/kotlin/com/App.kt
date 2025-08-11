package com

class App {
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
    }
}