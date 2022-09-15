package com.injin.effectivekotlin.chapter_01.item1

import org.junit.jupiter.api.Test
import kotlin.concurrent.thread
import kotlin.properties.Delegates

internal class Item1KtTest {

    @Test
    fun p6_1() {
        var num = 0
        repeat(1000) {
            thread {
                Thread.sleep(10)
                num += 1
            }
        }
        Thread.sleep(5000)
        println(num) //1000 이 아닐 확률이 매우 높다.
    }

    @Test
    fun p6_3() {
        val lock = Any()
        var num = 0
        repeat(1000) {
            thread {
                Thread.sleep(10)
                synchronized(lock) { num += 1}
            }
        }
        Thread.sleep(1000)
        println(num)
    }

    @Test
    fun p8_1() {
        val list2 = mutableListOf(1, 2, 3)
        list2.add(4)
    }


    var name: String = "InJin"
    var surname: String = "Jeong"
    private val fullName
        get() = "$name $surname" //지우면 안됨

    @Test
    fun p8_2() {
        println(fullName) // Jeong InJin
        name = "Kim"
        println(fullName) // Kim InJin
    }

    @Test
    fun p15_1() {
        var user = User("Jeong", "Injin")
        user = user.copy(surname = "momo")
        println(user)
//        user.name = "asd" 안됨
    }

    @Test
    fun p16_1() {
        val list1: MutableList<Int> = mutableListOf()
        var list2: List<Int> = listOf()

        list1.add(1)
        list2 = list2 + 1

        println(list1)
        println(list2)

        list1 += 1 // list1.plusAssign(1)로 변경
        list2 += 1 // list2 = list2.plus(1)로 변경

        println(list1)
        println(list2)
    }

    @Test
    fun p17_1() {
        var names by Delegates.observable(listOf<String>()) { _, old, new ->
            println("Names changed from $old to $new")
        }

        names += "Fabio" // Names changed from [] to [Fabio]
        names += "Bill" // Names changed from [Fabio] to [Fabio, Bill]
    }

}

data class User(val name: String, val surname: String)
