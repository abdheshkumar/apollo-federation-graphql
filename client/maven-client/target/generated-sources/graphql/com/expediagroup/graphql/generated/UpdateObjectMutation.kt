package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.inputs.BasicObjectInput
import com.expediagroup.graphql.generated.updateobjectmutation.BasicObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.reflect.KClass

public const val UPDATE_OBJECT_MUTATION: String =
    "mutation UpdateObjectMutation(${'$'}updatedObject: BasicObjectInput!) {\n    updateBasicObject(updatedObject: ${'$'}updatedObject) {\n        id\n        name\n    }\n}"

@Generated
public class UpdateObjectMutation(
  override val variables: UpdateObjectMutation.Variables,
) : GraphQLClientRequest<UpdateObjectMutation.Result> {
  override val query: String = UPDATE_OBJECT_MUTATION

  override val operationName: String = "UpdateObjectMutation"

  override fun responseType(): KClass<UpdateObjectMutation.Result> =
      UpdateObjectMutation.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "updatedObject")
    public val updatedObject: BasicObjectInput,
  )

  @Generated
  public data class Result(
    /**
     * Update existing object in the repository
     */
    @get:JsonProperty(value = "updateBasicObject")
    public val updateBasicObject: BasicObject? = null,
  )
}
