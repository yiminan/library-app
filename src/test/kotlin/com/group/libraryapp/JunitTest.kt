package com.group.libraryapp

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Junit Tests")
class JunitTest {

    private companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll() {
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
