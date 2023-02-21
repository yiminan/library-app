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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Calculator

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }
}
