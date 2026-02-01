package com.expediagroup.graphql.generated.scalars

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.examples.client.maven.AnyScalarConverter
import com.fasterxml.jackson.databind.util.StdConverter
import kotlin.Any

@Generated
public class AnyToAnyConverter : StdConverter<Any, Any>() {
  private val converter: AnyScalarConverter = AnyScalarConverter()

  override fun convert(`value`: Any): Any = converter.toScalar(value)
}
