package com.ll.domain.system.controller

import kotlin.system.exitProcess

class SystemController {
    fun exit() {
        println("프로그램을 종료합니다.")
        exitProcess(0)
    }
}