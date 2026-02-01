package com.expediagroup.graphql.generated.scalars

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.examples.client.maven.UUIDScalarConverter
import com.fasterxml.jackson.databind.util.StdConverter
import java.util.UUID
import kotlin.Any

@Generated
public class AnyToUUIDConverter : StdConverter<Any, UUID>() {
  private val converter: UUIDScalarConverter = UUIDScalarConverter()

  override fun convert(`value`: Any): UUID = converter.toScalar(value)
}
