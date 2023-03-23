package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService
) {
    @AfterEach
    fun afterEach() {
        userRepository.deleteAll()
    }

    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("Ryan", null)
        // when
        userService.saveUser(request)

        // then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("Ryan")
        assertThat(results[0].age).isNull()
    }

    @Test
    fun getUsersTest() {
        // given
        userRepository.saveAll(
            listOf(
                User("Ryan", null),
                User("John", 20)
            )
        )
        // when
        val results = userService.getUsers()
        // then
        assertThat(results).hasSize(2)
        assertThat(results).extracting("name")
            .containsExactlyInAnyOrder("Ryan", "John")
        assertThat(results).extracting("age")
            .containsExactlyInAnyOrder(null, 20)
    }

    @Test
    fun updateUserNameTest() {
        // given
        val savedUser = userRepository.save(User("Ryan", null))
        val request = UserUpdateRequest(savedUser.id, "John")
        // when
        userService.updateUserName(request)
        // then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("John")
    }
}
