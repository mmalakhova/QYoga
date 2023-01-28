package nsu.fit.qyoga.core.questionnaires.service.implement

import nsu.fit.qyoga.core.questionnaires.exceptions.*
import nsu.fit.qyoga.core.questionnaires.model.entry.Decoding
import nsu.fit.qyoga.core.questionnaires.model.repository.DecodingRepo
import nsu.fit.qyoga.core.questionnaires.service.interfaces.DecodingService
import org.springframework.data.repository.findByIdOrNull

class DecodingServiceImpl(private val decodingRepo: DecodingRepo): DecodingService {

    override fun getDecoding(id: Long): Decoding {
        return decodingRepo.findByIdOrNull(id) ?: throw DecodingNotFoundException(id)
    }

    override fun saveDecoding(decoding: Decoding) {
        try {
            decodingRepo.save(decoding)
        } catch (e: IllegalArgumentException){
            throw BadDecoding()
        }
    }

    override fun deleteDecoding(id: Long) {
        val decoding = decodingRepo.findByIdOrNull(id) ?: throw DecodingNotFoundException(id)
        decodingRepo.delete(decoding)
    }

    override fun getQuestionnaireDecoding(id: Long): List<Decoding> {
        return decodingRepo.findAllByQuestionnaireId(id)
    }

    override fun updateDecoding(decoding: Decoding) {
        if(decodingRepo.findByIdOrNull(decoding.id) == null){
            throw DecodingNotFoundException(decoding.id)
        }else{
            decodingRepo.save(decoding)
        }
    }

    override fun getResultDecoding(id: Long, result: Long): Decoding {
        return decodingRepo.findDecodingByResult(id = id, result = result) ?: throw DecodingNotFoundException(id)
    }
}