package com.group.libraryapp.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "5, 3, 8",
        "5, 0, 5",
        "0, 5, 5",
        "0, 0, 0"
    )
    fun addTest(operand1: Int, operand2: Int, result: Int) {
        val calculator = Calculator(operand1)

        calculator.add(operand2)

        assertEquals(Calculator(result), calculator)
    }

    @Test
    fun subtractTest() {
        val calculator = Calculator(5)

        calculator.subtract(3)

        assertEquals(Calculator(2), calculator)
    }

    @Test
    fun multiplyTest() {
        val calculator = Calculator(5)

        calculator.multiply(3)

        assertEquals(Calculator(15), calculator)
    }

    @Test
    fun divideTest() {
        val calculator = Calculator(5)

        calculator.divide(3)

        assertEquals(Calculator(1), calculator)
    }
}
