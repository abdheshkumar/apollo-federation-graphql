package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.deleteobjectmutation.BasicObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.reflect.KClass

public const val DELETE_OBJECT_MUTATION: String =
    "mutation DeleteObjectMutation(${'$'}id: Int!) {\n    deleteBasicObject(id: ${'$'}id) {\n        id\n        name\n    }\n}"

@Generated
public class DeleteObjectMutation(
  override val variables: DeleteObjectMutation.Variables,
) : GraphQLClientRequest<DeleteObjectMutation.Result> {
  override val query: String = DELETE_OBJECT_MUTATION

  override val operationName: String = "DeleteObjectMutation"

  override fun responseType(): KClass<DeleteObjectMutation.Result> =
      DeleteObjectMutation.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "id")
    public val id: Int,
  )

  @Generated
  public data class Result(
    /**
     * Delete object from repository
     */
    @get:JsonProperty(value = "deleteBasicObject")
    public val deleteBasicObject: BasicObject? = null,
  )
}
