package dev.supergrecko.kllvm.ir.types

import dev.supergrecko.kllvm.internal.util.fromLLVMBool
import dev.supergrecko.kllvm.ir.TypeKind
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.bytedeco.llvm.global.LLVM
import org.junit.jupiter.api.Test

class FunctionTypeTest {
    @Test
    fun `creation of zero arg type works`() {
        val ret = IntType(64)
        val fn = FunctionType(ret, listOf(), true)

        assertEquals(fn.getParameterCount(), 0)
        assertTrue { fn.getReturnType().ref == ret.ref }
    }

    @Test
    fun `variadic arguments work`() {
        val ret = IntType(64)
        val args = listOf(FloatType(TypeKind.Float))
        val fn = FunctionType(ret, args, true)

        assertEquals(fn.isVariadic(), true)
    }

    @Test
    fun `test variadic wrapper works`() {
        val ret = IntType(64)
        val args = listOf(FloatType(TypeKind.Float))
        val fn = FunctionType(ret, args, true)

        assertEquals(
            LLVM.LLVMIsFunctionVarArg(fn.ref).fromLLVMBool(), fn.isVariadic()
        )
    }

    @Test
    fun `test parameter count wrapper works`() {
        val ret = IntType(64)
        val args = listOf(FloatType(TypeKind.Float))
        val fn = FunctionType(ret, args, true)

        assertEquals(LLVM.LLVMCountParamTypes(fn.ref), fn.getParameterCount())
    }

    @Test
    fun `test parameter list matches`() {
        val ret = IntType(64)
        val args = listOf(FloatType(TypeKind.Float))
        val fn = FunctionType(ret, args, true)

        val params = fn.getParameterTypes()

        for (i in args.indices) {
            val x = params[i].ref
            val y = params[i].ref
            assertEquals(x, y)
        }
    }
}
