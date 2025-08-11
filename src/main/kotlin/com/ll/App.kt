package com.ll

import com.ll.domain.system.controller.SystemController
import com.ll.domain.wiseSaying.controller.WiseSayingController

class App {
    private val wiseSayingController = WiseSayingController()
    private val systemController = SystemController()

    fun run() {
        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val rq = readlnOrNull()!!.trim()
            val cmd = rq.split("?")

            when (cmd[0]) {
                "종료" -> {
                    systemController.exit()
                    return
                }
                "등록" -> wiseSayingController.create()
                "목록" -> wiseSayingController.list()
                "삭제" -> wiseSayingController.delete(cmd)
                "수정" -> wiseSayingController.modify(cmd)
                else -> println("알 수 없는 명령입니다.")
            }
        }
    }
}