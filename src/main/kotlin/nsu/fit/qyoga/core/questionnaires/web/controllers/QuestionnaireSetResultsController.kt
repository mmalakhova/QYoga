package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.model.entry.Decoding
import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.web.dto.DecodingDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/questionnaires/setResults")
class QuestionnaireSetResultsController {

    @GetMapping("")
    fun getResultsTable(model : Model): String {
        val results = DecodingDto(mutableListOf(
            Decoding("first result",0,1, Questionnaire(id=0),0),
            Decoding("second result",2,4, Questionnaire(id=0),1),
            Decoding("eqweq",5,10, Questionnaire(id=0),2)))
        model.addAttribute("results", results)
        model.addAttribute("offset", 0)
        model.addAttribute("questionnaireId",0)
        return "QuestionnairePages/QuestionnaireSetResult"
    }

    @PostMapping("")
    fun saveResultsTable(@ModelAttribute("results") decoding: DecodingDto): String {
        println(decoding.decoding.size)
        return ""
    }

    @DeleteMapping("/{resultId}")
    fun deleteDecoding(@PathVariable resultId: String, model : Model): String{
        val results = DecodingDto(mutableListOf(
            Decoding("first result",0,1, Questionnaire(id=0),0),
            Decoding("second result",2,4, Questionnaire(id=0),1)))
        model.addAttribute("results", results)
        model.addAttribute("offset", 0)
        println("Deleted row $resultId")
        return "QuestionnairePages/QuestionnaireSetResult"
    }

    @GetMapping("/{questionnaireId}/addResult")
    fun addDecoding(@PathVariable questionnaireId: String, model : Model):String{
        val results = DecodingDto(mutableListOf(
            Decoding("new result",0,1, Questionnaire(id=0),3)))
        model.addAttribute("results", results)
        model.addAttribute("offset", 3)
        println("Added new row")
        return "QuestionnairePages/QuestionnaireSetResult::tableDecoding"
    }
}