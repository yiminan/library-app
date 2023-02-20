package com.group.libraryapp.calculator

class Calculator constructor(
    private var number: Int
) {
    fun add(operand: Int) {
        this.number += operand
    }

    fun subtract(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        this.number /= operand
    }
}
