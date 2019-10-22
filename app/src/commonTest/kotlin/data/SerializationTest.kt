package data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTest {

    @Serializable
    data class TestClass(val a: String, val b: Int)

    @Test
    fun `Let's test kotlinx serialization`() {
        val json = """{"a":"Hello ruka", "b":42}"""
        val deserializer = Json(JsonConfiguration.Stable)

        val deserializedObject = deserializer.parse(TestClass.serializer(), json)

        assertEquals(deserializedObject.a, "Hello ruka")
        assertEquals(deserializedObject.b, 42)
    }
}