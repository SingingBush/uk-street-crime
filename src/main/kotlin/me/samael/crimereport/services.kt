package me.samael.crimereport

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI
import javax.ws.rs.NotFoundException

@Service
class UkPoliceApi(@Autowired val template: RestTemplate) {

    private val LOG = LoggerFactory.getLogger(UkPoliceApi::class.java)

    private val API_BASE = "https://data.police.uk/api"


    fun streetCrimeByLocation(latitude: String, longitude: String): List<Crime> {
        val uri = URI.create("$API_BASE/crimes-street/all-crime?lat=$latitude&lng=$longitude&date=2017-08")
        return getCrimes(uri)
    }

    fun streetCrimeByPoliceForce(policeForce: String): List<Crime> {
        val uri = URI.create("$API_BASE/crimes-no-location?category=all-crime&force=$policeForce&date=2017-08")
        return getCrimes(uri)
    }

    private fun getCrimes(uri: URI): List<Crime> {
        val response = template.exchange(RequestEntity<Any>(HttpMethod.GET, uri), typeRef<List<Crime>>())

        if(HttpStatus.OK == response.statusCode) {
            val crimes = response.body
            LOG.info("found ${crimes.size} crimes")
            return crimes
        } else {
            LOG.error("police API returned ${response.statusCode}")
        }
        throw NotFoundException()
    }
}

inline fun <reified T: Any> typeRef(): ParameterizedTypeReference<T> = object: ParameterizedTypeReference<T>(){}
