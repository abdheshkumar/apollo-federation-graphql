package com.expediagroup.graphql.generated.entitiesquery

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

@Generated
public data class ProductDimension(
  @get:JsonProperty(value = "size")
  public val size: String? = null,
  @get:JsonProperty(value = "weight")
  public val weight: Double? = null,
)
