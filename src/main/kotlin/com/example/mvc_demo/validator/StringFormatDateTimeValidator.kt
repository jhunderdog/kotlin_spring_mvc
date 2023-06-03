package com.example.mvc_demo.validator

import com.example.mvc_demo.annotation.StringFormatDateTime
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class StringFormatDateTimeValidator : ConstraintValidator<StringFormatDateTime, String> {

   private var pattern: String?=null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
        super.initialize(constraintAnnotation)
    }
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            return true
        } catch(e: Exception){
            return false
        }
    }
}