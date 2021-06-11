package com.example.quizapp

import android.accounts.AccountManager.get

class QuizModal(
    _question: String,
    _option1: String,
    _option2: String,
    _option3: String,
    _option4: String,
    _answer: String
) {

    var question: String
    var option1: String
    var option2: String
    var option3: String
    var option4: String
    var answer: String

    init {
        this.question = _question
        this.option1 = _option1
        this.option2 = _option2
        this.option3 = _option3
        this.option4 = _option4
        this.answer = _answer
    }

    var q: String = this.question
    get() = field
    set(value) {
        field = value
    }

    var o1: String = this.option1
        get() = field
        set(value) {
            field = value
        }

    var o2: String = this.option2
        get() = field
        set(value) {
            field = value
        }

    var o3: String = this.option3
        get() = field
        set(value) {
            field = value
        }

    var o4: String = this.option4
        get() = field
        set(value) {
            field = value
        }

    var a: String = this.answer
        get() = field
        set(value) {
            field = value
        }
}