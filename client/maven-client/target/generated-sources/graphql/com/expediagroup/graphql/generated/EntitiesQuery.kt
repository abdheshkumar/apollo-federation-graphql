package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.entitiesquery._Entity
import com.expediagroup.graphql.generated.scalars.AnyToAnyConverter
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.databind.`annotation`.JsonDeserialize
import com.fasterxml.jackson.databind.`annotation`.JsonSerialize
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.reflect.KClass

public const val ENTITIES_QUERY: String =
    "query EntitiesQuery(${'$'}representations: [_Any!]!) {\n    _entities(representations: ${'$'}representations) {\n        __typename\n        ...on Product {sku package variation { id } dimensions { size weight }\n        }\n    }\n}"

@Generated
public class EntitiesQuery(
  override val variables: EntitiesQuery.Variables,
) : GraphQLClientRequest<EntitiesQuery.Result> {
  override val query: String = ENTITIES_QUERY

  override val operationName: String = "EntitiesQuery"

  override fun responseType(): KClass<EntitiesQuery.Result> = EntitiesQuery.Result::class

  @Generated
  public data class Variables(
    @JsonSerialize(contentConverter = AnyToAnyConverter::class)
    @JsonDeserialize(contentConverter = AnyToAnyConverter::class)
    @get:JsonProperty(value = "representations")
    public val representations: List<Any>,
  )

  @Generated
  public data class Result(
    /**
     * Union of all types that use the @key directive, including both types native to the schema and
     * extended types
     */
    @get:JsonProperty(value = "_entities")
    public val _entities: List<_Entity?>,
  )
}
