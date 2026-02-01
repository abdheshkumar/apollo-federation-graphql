package com.expediagroup.graphql.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.jackson.types.OptionalInput
import com.expediagroup.graphql.client.jackson.types.OptionalInput.Undefined
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import com.expediagroup.graphql.generated.enums.CustomEnum
import com.expediagroup.graphql.generated.examplequery.BasicInterface
import com.expediagroup.graphql.generated.examplequery.BasicObject
import com.expediagroup.graphql.generated.examplequery.BasicUnion
import com.expediagroup.graphql.generated.examplequery.ComplexObject
import com.expediagroup.graphql.generated.examplequery.ScalarWrapper
import com.expediagroup.graphql.generated.inputs.SimpleArgumentInput
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.reflect.KClass

public const val EXAMPLE_QUERY: String =
    "query ExampleQuery(${'$'}simpleCriteria: SimpleArgumentInput) {\n    enumQuery\n    scalarQuery {\n        count\n        custom\n        customList\n        id\n        name\n        rating\n        valid\n        locale\n        listLocale\n    }\n    listQuery {\n        id\n        name\n    }\n    complexObjectQuery {\n        id\n        name\n        optional\n        details {\n            id\n            flag\n            value\n        }\n    }\n    interfaceQuery {\n        __typename\n        id\n        name\n        ... on FirstInterfaceImplementation {\n            intValue\n        }\n        ... on SecondInterfaceImplementation {\n            floatValue\n        }\n    }\n    unionQuery {\n        __typename\n        ... on BasicObject {\n            id\n            name\n        }\n        ... on ComplexObject {\n            id\n            name\n            optional\n            details {\n                id\n                flag\n                value\n            }\n        }\n    }\n    inputObjectQuery(criteria: ${'$'}simpleCriteria)\n}"

@Generated
public class ExampleQuery(
  override val variables: ExampleQuery.Variables,
) : GraphQLClientRequest<ExampleQuery.Result> {
  override val query: String = EXAMPLE_QUERY

  override val operationName: String = "ExampleQuery"

  override fun responseType(): KClass<ExampleQuery.Result> = ExampleQuery.Result::class

  @Generated
  public data class Variables(
    @get:JsonProperty(value = "simpleCriteria")
    public val simpleCriteria: OptionalInput<SimpleArgumentInput> = OptionalInput.Undefined,
  )

  @Generated
  public data class Result(
    /**
     * Query that returns enum value
     */
    @get:JsonProperty(value = "enumQuery")
    public val enumQuery: CustomEnum = CustomEnum.__UNKNOWN_VALUE,
    /**
     * Query that returns wrapper object with all supported scalar types
     */
    @get:JsonProperty(value = "scalarQuery")
    public val scalarQuery: ScalarWrapper,
    /**
     * Query returning list of simple objects
     */
    @get:JsonProperty(value = "listQuery")
    public val listQuery: List<BasicObject>,
    /**
     * Query returning an object that references another object
     */
    @get:JsonProperty(value = "complexObjectQuery")
    public val complexObjectQuery: ComplexObject,
    /**
     * Query returning an interface
     */
    @get:JsonProperty(value = "interfaceQuery")
    public val interfaceQuery: BasicInterface,
    /**
     * Query returning union
     */
    @get:JsonProperty(value = "unionQuery")
    public val unionQuery: BasicUnion,
    /**
     * Query that accepts some input arguments
     */
    @get:JsonProperty(value = "inputObjectQuery")
    public val inputObjectQuery: Boolean,
  )
}
