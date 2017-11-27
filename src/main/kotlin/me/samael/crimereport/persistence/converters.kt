package me.samael.crimereport.persistence

import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.time.LocalDateTime


@Converter(autoApply = true)
class LocalDateTimeAttributeConverter : AttributeConverter<LocalDateTime, Timestamp> {

    override fun convertToDatabaseColumn(dateTime: LocalDateTime?): Timestamp? = dateTime?.let { Timestamp.valueOf(dateTime) }

    override fun convertToEntityAttribute(timestamp: Timestamp?): LocalDateTime? = timestamp?.toLocalDateTime()
}

@Converter(autoApply = true)
class LocalDateAttributeConverter : AttributeConverter<LocalDate, Date> {

    override fun convertToDatabaseColumn(date: LocalDate?): Date? = date?.let { Date.valueOf(it) }

    override fun convertToEntityAttribute(date: Date?): LocalDate? = date?.toLocalDate()
}
