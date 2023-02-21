package com.group.libraryapp.controller.user

import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
  private val userService: UserService,
) {

  @PostMapping("/user")
  fun saveUser(@RequestBody request: UserCreateRequest, @One one: Long) {
    println(one) // 1이었으면 좋겠다. ArgumentResolver
    userService.saveUser(request)
  }

  /**
   * 단점 : controller마다 만들어야함
   * @RestControllerAdvice 로 전체 가능 but, 필터는 타지 않음
   */
  @ExceptionHandler(IllegalArgumentException::class)
  fun handleException() : ResponseEntity<String> {
    return ResponseEntity.ok("sorry");
  }

  class SKTBaseException : RuntimeException()

  enum class ExcetionCode(val message:String) {
    A("Sorry"),
    B("very Sorry"),
    C("call CS center")
  }

  @GetMapping("/user")
  fun getUsers(): List<UserResponse> {
    return userService.getUsers()
  }

  @PutMapping("/user")
  fun updateUserName(@RequestBody request: UserUpdateRequest) {
    userService.updateUserName(request)
  }

  @DeleteMapping("/user")
  fun deleteUser(@RequestParam name: String) {
    userService.deleteUser(name)
  }


}