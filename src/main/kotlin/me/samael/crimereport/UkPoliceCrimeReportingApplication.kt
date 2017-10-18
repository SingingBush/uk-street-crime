package me.samael.crimereport

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
//@EntityScan(basePackageClasses = arrayOf(
//        UkPoliceCrimeReportingApplication::class,
//        org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters::class // for LocalDateTime from JPA date
//))
class UkPoliceCrimeReportingApplication

fun main(args: Array<String>) {
    SpringApplication.run(UkPoliceCrimeReportingApplication::class.java, *args)
}
