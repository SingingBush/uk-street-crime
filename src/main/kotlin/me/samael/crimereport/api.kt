package me.samael.crimereport

import me.samael.crimereport.persistence.Person
import me.samael.crimereport.persistence.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestEndpoints(@Autowired val service: UkPoliceApi, @Autowired val repo: PersonRepository) {

    private val LOG = LoggerFactory.getLogger(RestEndpoints::class.java)

    // http://localhost:8080/ukcrime/api/crimesbylocation?latitude=52.629729&longitude=-1.131592
    @RequestMapping(value = ["/crimesbylocation"],
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCrimesForLocation(@RequestParam("latitude") latitude: String,
                                @RequestParam("longitude") longitude: String): List<Crime> {
        LOG.info("request made for crimes near $latitude $longitude")
        return service.streetCrimeByLocation(latitude, longitude).take(50)
    }

    // http://localhost:8080/ukcrime/api/crimesbyforce?force=leicestershire
    @RequestMapping(value = ["/crimesbyforce"],
    method = [RequestMethod.GET],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCrimesForForce(@RequestParam("force") force: String): List<Crime> {
        LOG.info("request made for crimes within $force without location info")
        return service.streetCrimeByPoliceForce(force).take(20)
    }

    @RequestMapping(value = ["/people"],
    method = [RequestMethod.GET],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPeople(): List<Person> {
        LOG.info("request made getting people from a db using JPA")
        //repo.saveAndFlush(Person(null, "testuser", "Test", "User", "t.u@domain.com"))
        return repo.findAll()
    }
}
