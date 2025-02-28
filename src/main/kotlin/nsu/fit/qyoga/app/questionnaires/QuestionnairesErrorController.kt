package nsu.fit.qyoga.app.questionnaires

import jakarta.servlet.http.HttpServletResponse
import nsu.fit.platform.errors.ResourceNotFound
import nsu.fit.qyoga.core.questionnaires.api.errors.ElementNotFound
import nsu.fit.qyoga.core.questionnaires.api.errors.QuestionnaireException
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class QuestionnairesErrorController {

    @ExceptionHandler(QuestionnaireException::class)
    fun handleQuestionnaireException(
        exception: QuestionnaireException,
        model: Model
    ): String {
        model.addAttribute("errorText", exception.message)
        return "error-page"
    }

    @ExceptionHandler(
        ElementNotFound::class
    )
    fun handleQuestionException(
        exception: ResourceNotFound,
        httpServletResponse: HttpServletResponse,
        model: Model
    ): String {
        httpServletResponse.addHeader("HX-Retarget", "#errors")
        httpServletResponse.addHeader("HX-Reswap", "innerHTML")
        model.addAttribute("message", exception.message)
        return "fragments/error-window::error"
    }
}
