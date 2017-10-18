package me.samael.crimereport

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestEndpoints(@Autowired val service: UkPoliceApi) {

    private val LOG = LoggerFactory.getLogger(RestEndpoints::class.java)

    // http://localhost:8080/ukcrime/api/crimesbylocation?latitude=52.629729&longitude=-1.131592
    @RequestMapping(value = "/crimesbylocation",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getCrimesForLocation(@RequestParam("latitude") latitude: String,
                                @RequestParam("longitude") longitude: String): List<Crime> {
        LOG.info("request made for crimes near $latitude $longitude")
        return service.streetCrimeByLocation(latitude, longitude).take(20)
    }

    // http://localhost:8080/ukcrime/api/crimesbyforce?force=leicestershire
    @RequestMapping(value = "/crimesbyforce",
    method = arrayOf(RequestMethod.GET),
    produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getCrimesForForce(@RequestParam("force") force: String): List<Crime> {
        LOG.info("request made for crimes within $force without location info")
        return service.streetCrimeByPoliceForce(force).take(20)
    }
}
