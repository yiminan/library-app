package com.group.libraryapp.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun addTest() {
        val calculator = Calculator(5)

        calculator.add(3)

        assertEquals(Calculator(8), calculator)
    }

    @Test
    fun subtractTest() {
        val calculator = Calculator(5)

        calculator.subtract(3)

        assertEquals(Calculator(2), calculator)
    }
}
