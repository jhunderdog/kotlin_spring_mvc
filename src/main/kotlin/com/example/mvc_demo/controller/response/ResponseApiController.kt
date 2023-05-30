package com.example.mvc_demo.controller.response

import com.example.mvc_demo.model.http.UserRequest
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    //1. get 4xx
    //GET http://localhost:8080/api/response
    @GetMapping("/get-mapping")
    fun getMapping(@RequestParam age : Int?): ResponseEntity<String> {

        age?.let {
            //age not null
            if(it < 20) {
                return ResponseEntity.status(400).body("age 값은 20보다 커야 합니다.")
            }
            return ResponseEntity.ok("ok")
        }?: kotlin.run {
            return ResponseEntity.status(400).body("age값이 누락되었습니다.")
        }

//        // 0. age == null -> 400 Error
//        if (age == null){
//            return ResponseEntity.status(400).body("age값이 누락되었습니다.")
//        }
//        // 1. age > 20 -> 400 Error
//        if (age < 20) {
//            return ResponseEntity.status(400).body("age 값은 20보다 커야 합니다.")
//        }
//        return ResponseEntity.ok("ok")
    }
    //2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(200).body(userRequest)
    }

    @PutMapping("")
    fun putMaaping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        //기존 데이터가 없어서 새로 생성했따.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Nothing> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
    //3. put 201
    //4. delete 500
}