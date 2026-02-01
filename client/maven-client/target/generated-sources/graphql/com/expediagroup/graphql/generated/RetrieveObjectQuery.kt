package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.retrieveobjectquery.BasicObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.reflect.KClass

public const val RETRIEVE_OBJECT_QUERY: String =
    "query RetrieveObjectQuery(${'$'}id: Int!) {\n    retrieveBasicObject(id: ${'$'}id) {\n        id\n        name\n    }\n}"

@Generated
public class RetrieveObjectQuery(
  override val variables: RetrieveObjectQuery.Variables,
) : GraphQLClientRequest<RetrieveObjectQuery.Result> {
  override val query: String = RETRIEVE_OBJECT_QUERY

  override val operationName: String = "RetrieveObjectQuery"

  override fun responseType(): KClass<RetrieveObjectQuery.Result> =
      RetrieveObjectQuery.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "id")
    public val id: Int,
  )

  @Generated
  public data class Result(
    /**
     * Retrieve simple object from the repository
     */
    @get:JsonProperty(value = "retrieveBasicObject")
    public val retrieveBasicObject: BasicObject? = null,
  )
}
