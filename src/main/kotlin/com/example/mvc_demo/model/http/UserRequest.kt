package com.example.mvc_demo.model.http

import com.example.mvc_demo.annotation.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(
    @field:Size(min =2, max = 8)
    var name:String?=null,
    @field:PositiveOrZero
    var age:Int?=null,
    @field:Email
    var email:String?=null,
    @field:NotBlank
    var address:String?=null,
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") //정규식검증
    var phoneNumber: String?=null,
    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String?=null //yyyy-MM-dd HH:mm:ss ex)2020-10-02 13:00:00
){
//    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다")
//    private fun isValidCreatedAt(): Boolean {
//        return try {
//            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            return true
//        } catch(e: Exception){
//            return false
//        }
//    }
}

//{
// "result_code": "OK",
// "result_message":"성공",
// "description": "~~~~",
// "user": [
//    {"name": "", "age": "", "email": ""},
//    {"name": "", "age": "", "email": ""},
//    {"name": "", "age": "", "email": ""},
// ]
