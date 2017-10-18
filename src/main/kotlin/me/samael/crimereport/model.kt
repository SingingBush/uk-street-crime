package me.samael.crimereport

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Crime(@JsonProperty("id") val id: Long,
                 @JsonProperty("category") val category: String,
                 @JsonProperty("location_type") val locationType: String? = null,
                 @JsonProperty("location") val location: Location? = null,
                 @JsonProperty("location_subtype") val locationSubtype: String,
                 @JsonProperty("context") val context: String,
                 @JsonProperty("outcome_status") val outcomeStatus: OutcomeStatus? = null,
                 @JsonProperty("persistent_id") val persistentId: String? = null,
                 @JsonProperty("month") val month: String)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Location(@JsonProperty("latitude") val latitude: String,
                    @JsonProperty("longitude") val longitude: String)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class OutcomeStatus(@JsonProperty("category") val category: String,
                         @JsonProperty("date") val month: String)
