package nsu.fit.qyoga.core.questionnaires.web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("/questionnaires")
class QuestionnaireController {

    @GetMapping("/")
    fun getAllQuestionnaires(): String{
        return "QuestionnairePages/QuestionnaireList"
    }

    @GetMapping("/test")
    fun default():String{
        println("Hi test")
        return "testPage"
    }

    @GetMapping("/sort")
    fun sort(@RequestParam("make") make: String): String{
        println(make)
        return ""
    }


}