package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import nsu.fit.qyoga.core.questionnaires.model.entry.Question
import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import nsu.fit.qyoga.core.questionnaires.service.interfaces.QuestionnaireService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Controller
@RequestMapping("/questionnaires")
class QuestionnaireController(var questionnaireService: QuestionnaireService) {

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
    fun sortQuestionnaires(@RequestParam("sort-type") make: String): String{
        println(make)
        return "QuestionnairePages/QuestionnaireList :: questionnaires"
    }

    @GetMapping("/search")
    fun searchQuestionnaires(@RequestParam("search-text") text: String): String{
        println(text)
        return "QuestionnairePages/QuestionnaireList :: questionnaires"
    }

    @GetMapping("/new")
    fun newQuestionnaires(model : Model): String{

        val questionnaire = Questionnaire("Unnamed questionnaire", listOf(Question(QuestionType.RANGE, "text", "", listOf(Answer()),0),
            Question(QuestionType.SINGLE, "text", "", listOf(Answer(id=1), Answer(id=2)),1)))
        //questionnaireService.saveQuestionnaire(questionnaire)
        model.addAttribute("questionnaire", questionnaire)
        return "QuestionnairePages/CreateQuestionnaire"
    }

    @PostMapping("/new")
    fun saveNewQuestionnaires(model : Model, @ModelAttribute("questionnaire") questionnaire: Questionnaire): String{
        println("get questionnaire: ${questionnaire.title}")
        return ""
    }

    @GetMapping("/{questionId}/changeType")
    fun changeAnswerType(@RequestParam("question-type") type: String, @PathVariable questionId: String): String{
        println(type)
        return ""
    }

    @GetMapping("/{questionnaireId}/addQuestion")
    fun addNewQuestionToQuestionnaire(@PathVariable questionnaireId: String): String{
        println("New Question!")
        return ""
    }

    @PostMapping("/{questionnaireId}/image")
    fun addImageToQuestionnaire(@RequestParam("file") file: MultipartFile, @PathVariable questionnaireId: String): String{
        println("question image: ${file.size}")
        return ""
    }

    @PostMapping("/answers/{answerId}/image")
    fun addImageToAnswer(@RequestParam("file") file: MultipartFile, @PathVariable answerId: String, ): String{
        println("answer image: ${file.size}")
        return ""
    }

    @PostMapping("/answers/{answerId}/LeftBorder")
    fun answerSetLeftBorder(@RequestParam("range") value: Int, @PathVariable answerId: String): String{
        println("changed left border: $value for answer $answerId")
        return ""
    }


}