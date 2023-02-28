package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.model.entry.Answer
import nsu.fit.qyoga.core.questionnaires.model.entry.Question
import nsu.fit.qyoga.core.questionnaires.model.entry.Questionnaire
import nsu.fit.qyoga.core.questionnaires.model.enumeration.QuestionType
import nsu.fit.qyoga.core.questionnaires.web.dto.ClientAnswersDto
import nsu.fit.qyoga.core.questionnaires.web.dto.ClientAnswersDtoList
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/questionnaires/complete")
class CompeteQController {

    @GetMapping("")
    fun getAllQuestionnaires(model : Model): String{
        val questionnaire = Questionnaire("Unnamed questionnaire", listOf(
            Question(QuestionType.RANGE, "text", "", listOf(Answer()),0),
            Question(QuestionType.TEXT, "text", "", listOf(Answer()),3),
            Question(QuestionType.SINGLE, "text", "", listOf(Answer(id=1), Answer(id=2)),1),
            Question(QuestionType.SEVERAL, "text", "", listOf(Answer(id=3), Answer(id=4)),2)
        ))
        model.addAttribute("questionnaire", questionnaire)
        model.addAttribute("answersForm", ClientAnswersDtoList());
        return "QuestionnairePages/CompleteQuestionnaire"
    }

    @PostMapping("")
    fun saveNewQuestionnaires(@ModelAttribute("answersForm") answer: ClientAnswersDtoList): String{
        println("get questionnaire: $answer")
        return ""
    }
}