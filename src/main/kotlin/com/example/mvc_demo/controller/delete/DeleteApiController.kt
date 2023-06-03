package com.example.mvc_demo.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    //1. path variable
    //2. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @jakarta.validation.constraints.NotNull(message = "age값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return _name + " " + _age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name")
        @Size(min = 2, max = 5, message = "name의 길이는 2-5")
        @jakarta.validation.constraints.NotNull(message = "age값이 누락되었습니다.")
        _name: String,
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int): String {
        println(_name)
        return _name + " " + _age
    }
}