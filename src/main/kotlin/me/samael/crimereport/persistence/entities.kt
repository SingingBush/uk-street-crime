package me.samael.crimereport.persistence

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy=GenerationType.AUTO) val id: Long? = null,
                  @Column(name = "username", unique = true, length = 20, nullable = false) val username: String,
                  @Column(name = "firstname", length = 20, nullable = true) val firstname: String? = null,
                  @Column(name = "lastname", length = 20, nullable = true) val lastname: String? = null,
                  @Column(name = "email", unique = true, length = 80, nullable = false) val email: String,
                  @Column(name = "created") val created: LocalDateTime = LocalDateTime.now())
