package com.group.libraryapp

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Junit Test")
class JunitTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            println("beforeAll")
        }
    }

    @BeforeEach
    fun beforeEach() {
        println("beforeEach")
    }

    @Test
    fun test1() {
        println("test1")
    }

    @Test
    fun test2() {
        println("test2")
    }
}
