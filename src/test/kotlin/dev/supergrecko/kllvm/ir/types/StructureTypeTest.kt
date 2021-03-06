package dev.supergrecko.kllvm.ir.types

import dev.supergrecko.kllvm.ir.TypeKind
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class StructureTypeTest {
    @Test
    fun `ref creation of type`() {
        val type = StructType(listOf(IntType(16)), false)
        val second = StructType(type.ref)

        assertEquals(TypeKind.Struct, second.getTypeKind())
    }

    @Test
    fun `is sized works for struct`() {
        val arg = FloatType(TypeKind.Float)
        val type = StructType(listOf(arg), false)

        assertEquals(true, type.isSized())
    }

    @Test
    fun `test element spec matches`() {
        val elements = listOf(IntType(32))
        val struct = StructType(elements, false)

        assertEquals(false, struct.isPacked())
        assertEquals(1, struct.getElementCount())
        assertEquals(true, struct.isLiteral())
        assertEquals(false, struct.isOpaque())

        val (first) = struct.getElementTypes()
        assertEquals(elements.first().ref, first.ref)

        val type = struct.getElementTypeAt(0)
        assertEquals(type.ref, elements.first().ref)
    }

    @Test
    fun `name matches`() {
        val struct = StructType("StructureName")

        assertEquals("StructureName", struct.getName())
    }

    @Test
    fun `test opaque struct`() {
        val struct = StructType("test_struct")

        assertEquals(true, struct.isOpaque())

        val elements = listOf(IntType(32))
        struct.setBody(elements, false)

        val (first) = struct.getElementTypes()
        assertEquals(elements.first().ref, first.ref)
        assertEquals(false, struct.isOpaque())
    }
}
