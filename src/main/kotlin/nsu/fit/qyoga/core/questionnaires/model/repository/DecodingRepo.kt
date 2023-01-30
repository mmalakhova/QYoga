package nsu.fit.qyoga.core.questionnaires.model.repository

import nsu.fit.qyoga.core.questionnaires.model.entry.Decoding
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface DecodingRepo : CrudRepository<Decoding, Long> {

/*    fun findAllByQuestionnaireId(id: Long): List<Decoding>

    @Query("SELECT * from decoding where questionnaire_id =:id AND :result BETWEEN lower_bound AND upper_bound")
    fun findDecodingByResult(@Param("id")id: Long,@Param("result") result: Long) : Decoding?*/

}