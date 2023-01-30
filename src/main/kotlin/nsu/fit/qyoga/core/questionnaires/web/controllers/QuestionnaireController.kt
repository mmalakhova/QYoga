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
        val questionnaire = Questionnaire("Unnamed questionnaire", listOf(Question(QuestionType.SINGLE, "text", "", listOf(Answer()))))
        //questionnaireService.saveQuestionnaire(questionnaire)
        model.addAttribute("questionnaire", questionnaire)
        return "QuestionnairePages/CreateQuestionnaire"
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
    fun addiMAGEToQuestionnaire(@RequestParam("file") file: MultipartFile, @PathVariable questionnaireId: String): String{
        println("image! ${file.size}")
        return ""
    }

}