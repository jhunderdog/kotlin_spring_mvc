package com.example.mvc_demo.controller.put

import com.example.mvc_demo.model.http.Result
import com.example.mvc_demo.model.http.UserRequest
import com.example.mvc_demo.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        //0. UserResponse
        return UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "~~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber = "010-9165-6591"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber = "010-2558-6591"
            })
            this.userRequest = userList
        }
        //1.Result

        //2.Description
        //3.user Mutable List

    }
}