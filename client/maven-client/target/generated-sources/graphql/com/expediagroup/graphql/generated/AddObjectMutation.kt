package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.addobjectmutation.BasicObject
import com.expediagroup.graphql.generated.inputs.BasicObjectInput
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.reflect.KClass

public const val ADD_OBJECT_MUTATION: String =
    "mutation AddObjectMutation(${'$'}newObject: BasicObjectInput!) {\n    addBasicObject(newObject: ${'$'}newObject) {\n        id\n        name\n    }\n}"

@Generated
public class AddObjectMutation(
  override val variables: AddObjectMutation.Variables,
) : GraphQLClientRequest<AddObjectMutation.Result> {
  override val query: String = ADD_OBJECT_MUTATION

  override val operationName: String = "AddObjectMutation"

  override fun responseType(): KClass<AddObjectMutation.Result> = AddObjectMutation.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "newObject")
    public val newObject: BasicObjectInput,
  )

  @Generated
  public data class Result(
    /**
     * Add object to the repository
     */
    @get:JsonProperty(value = "addBasicObject")
    public val addBasicObject: BasicObject? = null,
  )
}
