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

    @ParameterizedTest
    @CsvSource(
        "5, 3, 2",
        "5, 0, 5",
        "0, 5, -5",
        "0, 0, 0"
    )
    fun subtractTest(operand1: Int, operand2: Int, result: Int) {
        val calculator = Calculator(operand1)

        calculator.subtract(operand2)

        assertEquals(Calculator(result), calculator)
    }

    @ParameterizedTest
    @CsvSource(
        "5, 3, 15",
        "5, 0, 0",
        "0, 5, 0",
        "0, 0, 0"
    )
    fun multiplyTest(operand1: Int, operand2: Int, result: Int) {
        val calculator = Calculator(operand1)

        calculator.multiply(operand2)

        assertEquals(Calculator(result), calculator)
    }

    @ParameterizedTest
    @CsvSource(
        "5, 3, 1",
        "5, 1, 5",
        "0, 5, 0"
    )
    fun divideTest(operand1: Int, operand2: Int, result: Int) {
        val calculator = Calculator(operand1)

        calculator.divide(operand2)

        assertEquals(Calculator(result), calculator)
    }
}
