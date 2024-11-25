package com.example.calculatorapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class CalculatorViewModel: ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

    fun onAction (action: CalculatorActions) {
        when (action) {
            is CalculatorActions.Number -> enterNumber(action.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> _state.value = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(action.operation)
            is CalculatorActions.Delete -> delete()
            is CalculatorActions.Calculate -> calculate()
        }
    }

    private fun calculateResult(equation: String) : String{
        val context : Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable,equation,"Javascript",1,null).toString()
        if(finalResult.endsWith(".0")){
            finalResult = finalResult.replace(".0","")
        }
        return finalResult
    }

    private fun calculate () {
        if (_state.value.display.isNotBlank()) {
            _state.value = _state.value.copy(
                display = calculateResult(_state.value.display)
            )
        }
    }

    private fun enterNumber (number: Int) {
        _state.value = _state.value.copy(
            display = _state.value.display + "$number"
        )
    }

    private fun enterDecimal () {
        if (_state.value.display.isNotEmpty() && _state.value.display.last() != '.'
            && _state.value.display.last() != '*' && _state.value.display.last() != '-'
            && _state.value.display.last() != '+') {
            _state.value = _state.value.copy(
                display = _state.value.display + "."
            )
        }
    }

    private fun enterOperation (operation: CalculatorOperation) {
        if (_state.value.display.isNotEmpty() && _state.value.display.last() != '.'
            && _state.value.display.last() != '*' && _state.value.display.last() != '-'
            && _state.value.display.last() != '+') {
            _state.value = _state.value.copy(
                display = _state.value.display + "${operation.symbol}"
            )
        }
    }

    private fun delete () {
        if (_state.value.display.isNotBlank()) {
            val newDisplay = _state.value.display.dropLast(1)
            _state.value = _state.value.copy(display = newDisplay)
        }
    }
}
