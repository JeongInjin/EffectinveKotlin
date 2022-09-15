package com.injin.effectivekotlin

/**
 * 정적 팩토리 메서드
 * 이펙티브 자바: 아이템 1: 생성자대신 정적 팩토리 메서드를 사용하라.
 */
class TestUser private constructor(
    val userName: String,
    val email: String
){
    companion object {
        fun of(userName: String, email: String): TestUser {
            return TestUser(userName = userName, email = email)
        }
    }
}

class TestUserCall {
    val user = TestUser.of(userName = "injin", email = "injin@email.com")
    val test = Test(userName = "username", email = "email")
}

class Test(val userName: String, email: String)