package com.expediagroup.graphql.generated.examplequery

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.`annotation`.JsonSubTypes
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.As.PROPERTY
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.Id.NAME
import kotlin.Int
import kotlin.String

/**
 * Very basic union of BasicObject and ComplexObject
 */
@Generated
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "__typename",
  defaultImpl = DefaultBasicUnionImplementation::class,
)
@JsonSubTypes(value = [com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    BasicObject2::class,
    name="BasicObject"),com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    ComplexObject2::class, name="ComplexObject")])
public interface BasicUnion

/**
 * Some basic description
 */
@Generated
public data class BasicObject2(
  @get:JsonProperty(value = "id")
  public val id: Int,
  /**
   * Object name
   */
  @get:JsonProperty(value = "name")
  public val name: String,
) : BasicUnion

/**
 * Multi line description of a complex type.
 * This is a second line of the paragraph.
 * This is final line of the description.
 */
@Generated
public data class ComplexObject2(
  /**
   * Some unique identifier
   */
  @get:JsonProperty(value = "id")
  public val id: Int,
  /**
   * Some object name
   */
  @get:JsonProperty(value = "name")
  public val name: String,
  /**
   * Optional value
   * |Second line of the description
   */
  @get:JsonProperty(value = "optional")
  public val optional: String?,
  /**
   * Some additional details
   */
  @get:JsonProperty(value = "details")
  public val details: DetailsObject,
) : BasicUnion

/**
 * Fallback BasicUnion implementation that will be used when unknown/unhandled type is encountered.
 */
@Generated
public class DefaultBasicUnionImplementation() : BasicUnion
