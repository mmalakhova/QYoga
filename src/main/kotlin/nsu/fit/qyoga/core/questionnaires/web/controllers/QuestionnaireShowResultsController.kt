package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import nsu.fit.qyoga.core.questionnaires.model.entry.ClientsAnswers
import nsu.fit.qyoga.core.questionnaires.model.entry.Question
import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import nsu.fit.qyoga.core.questionnaires.web.dto.QuestionAnswersDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/questionnaires/showResult")
class QuestionnaireShowResultsController {

    @GetMapping("")
    fun getResult(model : Model):String{
        model.addAttribute("questionnaire", Questionnaire("title"))
        model.addAttribute("clientAnswers", listOf(
            ClientsAnswers(
                null,
                null,
                Question(QuestionType.SINGLE, "firstQ",null, listOf(Answer("Q1A1"), Answer("Q1A2"))),
                listOf(Answer("Q1A6"))
            ),
            ClientsAnswers(
                null,
                null,
                Question(QuestionType.SEVERAL, "2QText",null, listOf(Answer("Q1A1"), Answer("Q1A2"))),
                listOf(Answer("Q1A3"), Answer("Q1A4"))
            ),
            ClientsAnswers(
                "Hello world",
                null,
                Question(QuestionType.TEXT, "3QText",null, listOf()),
                listOf(Answer("Q1A3"))
            ),
            ClientsAnswers(
                null,
                3,
                Question(QuestionType.RANGE, "3QText",null, listOf()),
                listOf(Answer("Q1A3"))
            )
        ))
        return "QuestionnairePages/QuestionnaireWatchResultPage"
    }
}