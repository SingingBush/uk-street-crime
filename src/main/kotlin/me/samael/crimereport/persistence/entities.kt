package me.samael.crimereport.persistence

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy=GenerationType.AUTO) val id: Long? = null,
                  @Column val username: String,
                  @Column val firstname: String,
                  @Column val lastname: String,
                  @Column val email: String? = null,
                  @Column val created: LocalDateTime = LocalDateTime.now())
