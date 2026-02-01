package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.jackson.types.OptionalInput
import com.expediagroup.graphql.client.jackson.types.OptionalInput.Undefined
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.reflect.KClass

public const val HELLO_WORLD_QUERY: String =
    "query HelloWorldQuery(${'$'}name: String) {\n    helloWorld(name: ${'$'}name)\n}"

@Generated
public class HelloWorldQuery(
  override val variables: HelloWorldQuery.Variables,
) : GraphQLClientRequest<HelloWorldQuery.Result> {
  override val query: String = HELLO_WORLD_QUERY

  override val operationName: String = "HelloWorldQuery"

  override fun responseType(): KClass<HelloWorldQuery.Result> = HelloWorldQuery.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "name")
    public val name: OptionalInput<String> = OptionalInput.Undefined,
  )

  @Generated
  public data class Result(
    /**
     * Basic `HelloWorld` Query
     */
    @get:JsonProperty(value = "helloWorld")
    public val helloWorld: String,
  )
}
