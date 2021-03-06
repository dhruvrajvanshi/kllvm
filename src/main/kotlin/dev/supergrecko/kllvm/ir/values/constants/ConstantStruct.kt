package dev.supergrecko.kllvm.ir.values.constants

import dev.supergrecko.kllvm.internal.util.toLLVMBool
import dev.supergrecko.kllvm.ir.Context
import dev.supergrecko.kllvm.ir.Value
import dev.supergrecko.kllvm.ir.types.StructType
import dev.supergrecko.kllvm.ir.values.AggregateValue
import dev.supergrecko.kllvm.ir.values.CompositeValue
import dev.supergrecko.kllvm.ir.values.ConstantValue
import org.bytedeco.javacpp.PointerPointer
import org.bytedeco.llvm.LLVM.LLVMValueRef
import org.bytedeco.llvm.global.LLVM

public class ConstantStruct internal constructor() : Value(), ConstantValue,
    AggregateValue, CompositeValue {
    public constructor(llvmValue: LLVMValueRef) : this() {
        ref = llvmValue
    }

    /**
     * @see LLVM.LLVMConstStructInContext
     */
    public constructor(
        values: List<Value>,
        packed: Boolean,
        context: Context = Context.getGlobalContext()
    ) : this() {
        val ptr = ArrayList(values.map { it.ref }).toTypedArray()

        ref = LLVM.LLVMConstStructInContext(
            context.ref,
            PointerPointer(*ptr),
            ptr.size,
            packed.toLLVMBool()
        )
    }

    /**
     * @see LLVM.LLVMConstNamedStruct
     */
    public constructor(type: StructType, values: List<Value>) : this() {
        val ptr = ArrayList(values.map { it.ref }).toTypedArray()

        ref =
            LLVM.LLVMConstNamedStruct(type.ref, PointerPointer(*ptr), ptr.size)
    }
}
