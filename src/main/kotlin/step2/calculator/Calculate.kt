package step2.calculator

private const val ARITHMETIC_EXCEPTION_ERROR_MESSAGE = "Error occurred during calculate"

fun calculate(expression: String): Int {
    val mathExpression = parseToMathExpression(expression)

    try {
        return calculate(mathExpression)
    } catch (exception: Exception) {
        throw ArithmeticException(ARITHMETIC_EXCEPTION_ERROR_MESSAGE)
    }
}

private fun calculate(mathExpression: MathExpression): Int {
    var result: Int = mathExpression.operands[0].toInt()

    for (i in 0 until mathExpression.operatorsSize) {
        val operator: Operator = mathExpression.operators[i]
        val operand: Operand = mathExpression.operands[i + 1]

        result = elementCalculate(operator, result, operand.toInt())
    }

    return result
}

private fun elementCalculate(operator: Operator, firstOperand: Int, secondOperand: Int): Int {
    return operator.calculate(firstOperand, secondOperand)
}
