package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.model.entry.QuestionnairesCompleting
import nsu.fit.qyoga.core.questionnaires.web.dto.ClientAnswersDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/questionnaires/results")
class ViewQResults {
    @GetMapping("")
    fun saveNewQuestionnaires(model: Model): String{
        val list: List<QuestionnairesCompleting> = emptyList()
        model.addAttribute("results", list)
        model.addAttribute("questionnaire", Questionnaire(title = "questionnaire title"))
        return "QuestionnairePages/Questionnaire"
    }

    @GetMapping("/test")
    fun test(model: Model): String{
        model.addAttribute("generatedLink", "generated link new")
        return "QuestionnairePages/QuestionnaireGenerateLink"
    }

    @GetMapping("/generateLinkModal/{questionId}")
    fun generateLinkPage(@PathVariable questionId: String, model: Model): String{
        model.addAttribute("questionId", 10)
        model.addAttribute("generatedLink", "generated link")
        val clients = emptyList<Int>()
        model.addAttribute("clients", clients)
        return "QuestionnairePages/QuestionnaireGenerateLink"
    }

    @GetMapping("/generateLink/{questionId}/{clientId}")
    fun generateLink(model: Model, @PathVariable clientId: String, @PathVariable questionId: String): String{
        model.addAttribute("generatedLink", "generated link new")
        return "QuestionnairePages/QuestionnaireGenerateLink::generateLink"
    }


}