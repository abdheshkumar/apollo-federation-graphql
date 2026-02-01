package com.expediagroup.graphql.generated.entitiesquery

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.`annotation`.JsonSubTypes
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.As.PROPERTY
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.Id.NAME
import kotlin.String

@Generated
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "__typename",
  defaultImpl = Default_EntityImplementation::class,
)
@JsonSubTypes(value = [com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = Product::class,
    name="Product")])
public interface _Entity

@Generated
public data class Product(
  @get:JsonProperty(value = "sku")
  public val sku: String?,
  @get:JsonProperty(value = "package")
  public val `package`: String?,
  @get:JsonProperty(value = "variation")
  public val variation: ProductVariation?,
  @get:JsonProperty(value = "dimensions")
  public val dimensions: ProductDimension?,
) : _Entity

/**
 * Fallback _Entity implementation that will be used when unknown/unhandled type is encountered.
 */
@Generated
public class Default_EntityImplementation() : _Entity
