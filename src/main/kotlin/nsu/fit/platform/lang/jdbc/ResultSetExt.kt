package nsu.fit.platform.lang.jdbc

import nsu.fit.platform.postgresql.toDuration
import org.postgresql.util.PGInterval
import java.sql.ResultSet
import java.time.Duration

inline operator fun <reified T> ResultSet.get(colName: String): T = when (T::class) {
    Long::class -> this.getLong(colName)
    Int::class -> this.getInt(colName)
    String::class -> this.getString(colName)
    Duration::class -> (this.getObject(colName) as PGInterval).toDuration()
    else -> this.getObject(colName)
} as T