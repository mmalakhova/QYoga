package nsu.fit.qyoga.core.questionnaires.web.controllers

import nsu.fit.qyoga.core.questionnaires.web.dto.CalendarDto
import nsu.fit.qyoga.core.questionnaires.web.dto.ClientAnswersDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/calendar")
class CalendarTestController {

    @GetMapping("")
    fun getAllQuestionnaires(model : Model): String{
        model.addAttribute("actions", CalendarDto())
        return "CalendarPages/CalendarTest"
    }
}