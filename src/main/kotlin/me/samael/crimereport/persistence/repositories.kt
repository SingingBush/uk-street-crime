package me.samael.crimereport.persistence

import org.springframework.data.jpa.repository.JpaRepository

//@Transactional(Transactional.TxType.MANDATORY)
interface PersonRepository : JpaRepository<Person, Long>
