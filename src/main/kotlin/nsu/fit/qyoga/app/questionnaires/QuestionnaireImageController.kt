package nsu.fit.qyoga.app.questionnaires

import nsu.fit.qyoga.core.images.api.ImageService
import nsu.fit.qyoga.core.questionnaires.api.errors.ElementNotFound
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/therapist/questionnaires")
class QuestionnaireImageController(
    private val imageService: ImageService
) {
    /**
     * Получение изображение по id
     */
    @GetMapping("/image/{id}")
    @ResponseBody
    fun getImage(
        @PathVariable id: Long
    ): ResponseEntity<InputStreamResource> {
        val image = imageService.getImage(id)
            ?: throw ElementNotFound("Изображение не найдено")
        return ResponseEntity.ok()
            .contentLength(image.size)
            .contentType(MediaType.parseMediaType(image.mediaType))
            .body(InputStreamResource(image.data.inputStream()))
    }
}
