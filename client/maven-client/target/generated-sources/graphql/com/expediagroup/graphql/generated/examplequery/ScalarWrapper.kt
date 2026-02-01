package com.expediagroup.graphql.generated.examplequery

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.generated.ID
import com.expediagroup.graphql.generated.scalars.AnyToULocaleConverter
import com.expediagroup.graphql.generated.scalars.AnyToUUIDConverter
import com.expediagroup.graphql.generated.scalars.ULocaleToAnyConverter
import com.expediagroup.graphql.generated.scalars.UUIDToAnyConverter
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.databind.`annotation`.JsonDeserialize
import com.fasterxml.jackson.databind.`annotation`.JsonSerialize
import com.ibm.icu.util.ULocale
import java.util.UUID
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Wrapper that holds all supported scalar types
 */
@Generated
public data class ScalarWrapper(
  /**
   * A signed 32-bit nullable integer value
   */
  @get:JsonProperty(value = "count")
  public val count: Int? = null,
  /**
   * Custom scalar of UUID
   */
  @JsonSerialize(converter = UUIDToAnyConverter::class)
  @JsonDeserialize(converter = AnyToUUIDConverter::class)
  @get:JsonProperty(value = "custom")
  public val custom: UUID,
  /**
   * List of custom scalar UUIDs
   */
  @JsonSerialize(contentConverter = UUIDToAnyConverter::class)
  @JsonDeserialize(contentConverter = AnyToUUIDConverter::class)
  @get:JsonProperty(value = "customList")
  public val customList: List<UUID>,
  /**
   * ID represents unique identifier that is not intended to be human readable
   */
  @get:JsonProperty(value = "id")
  public val id: ID,
  /**
   * UTF-8 character sequence
   */
  @get:JsonProperty(value = "name")
  public val name: String,
  /**
   * A nullable signed double-precision floating-point value
   */
  @get:JsonProperty(value = "rating")
  public val rating: Double? = null,
  /**
   * Either true or false
   */
  @get:JsonProperty(value = "valid")
  public val valid: Boolean,
  /**
   * Custom scalar of Locale
   */
  @JsonSerialize(converter = ULocaleToAnyConverter::class)
  @JsonDeserialize(converter = AnyToULocaleConverter::class)
  @get:JsonProperty(value = "locale")
  public val locale: ULocale,
  /**
   * List of custom scalar Locales
   */
  @JsonSerialize(contentConverter = ULocaleToAnyConverter::class)
  @JsonDeserialize(contentConverter = AnyToULocaleConverter::class)
  @get:JsonProperty(value = "listLocale")
  public val listLocale: List<ULocale>,
)
