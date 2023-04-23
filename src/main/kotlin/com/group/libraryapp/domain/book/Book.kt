package com.group.libraryapp.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book(
    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // default 값이 있는 경우 아래에 배열하는 것이 기본 컨벤션
) {
    constructor(name: String) : this(name = name, id = null) // 부 생성자 활용 방법

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Book name must not be blank")
        }
    }

}
