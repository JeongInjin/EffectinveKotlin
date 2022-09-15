package com.injin.effectivekotlin.chapter_01.item2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Item2Test {

    @Test
    fun `구조 분해 선언 테스트 - destructuring declaration`() {
        updateWeather(4)
    }

    fun updateWeather(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> "cold" to "blue"
            degrees < 23 -> "middle" to "yello"
            else -> "hot" to "red"
        }
        println("description: $description, color: $color")
    }

    @Test
    fun `에라토스체네스의 체 기본`() {
        var numbers = (2..100).toList()
        val primes = mutableListOf<Int>()
        while (numbers.isNotEmpty()) {
            val prime = numbers.first()
            primes.add(prime)
            numbers = numbers.filter { it % prime != 0 }
        }
        println(primes)
    }

    @Test
    fun `에라토스체네스의 체 sequence 이용`() {
        val primes: Sequence<Int> = sequence {
            //2부터 검색하기위해 인수로 2를 주고 1씩 증가하도록 시퀀스 정의
            var numbers = generateSequence(2) { it + 1}

            while (true) {
                val prime = numbers.first()
                yield(prime)
                numbers = numbers.drop(1).filter { it % prime != 0 }
            }
        }

        println(primes.take(10).toList())
    }
}