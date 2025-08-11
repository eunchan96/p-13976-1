package com.ll

import com.ll.domain.standard.util.TestUtil

object AppTestRunner {
    fun run(input: String): String {
        TestUtil.setInToByteArray("${input}\n종료")
        val output = TestUtil.setOutToByteArray()
        App().run()

        return output.toString().trim()
            .also { TestUtil.clearSetOutToByteArray(output) }
    }
}