package com.ll

import com.ll.domain.system.controller.SystemController
import com.ll.domain.wiseSaying.controller.WiseSayingController

class App {
    private val WiseSayingController = WiseSayingController()
    private val SystemController = SystemController()

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val rq = readlnOrNull()!!.trim()
            val cmd = rq.split("?")

            when (cmd[0]) {
                "종료" -> SystemController.exit()
                "등록" -> WiseSayingController.create()
                "목록" -> WiseSayingController.list()
                "삭제" -> WiseSayingController.delete(cmd)
                "수정" -> WiseSayingController.modify(cmd)
                else -> println("알 수 없는 명령입니다.")
            }
        }
    }
}