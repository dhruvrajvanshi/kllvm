package dev.supergrecko.kllvm.ir.values

import dev.supergrecko.kllvm.internal.contracts.ContainsReference
import dev.supergrecko.kllvm.ir.Value
import dev.supergrecko.kllvm.ir.values.constants.ConstantInt
import org.bytedeco.javacpp.PointerPointer
import org.bytedeco.llvm.LLVM.LLVMValueRef
import org.bytedeco.llvm.global.LLVM

public interface AggregateValue : ContainsReference<LLVMValueRef> {
    /**
     * Access an address of a sub-element of an aggregate data structure
     * (arrays or structures)
     *
     * [See](https://llvm.org/docs/LangRef.html#getelementptr-instruction)
     * [See](https://llvm.org/docs/GetElementPtr.html)
     *
     * @see LLVM.LLVMConstGEP
     * @see LLVM.LLVMConstInBoundsGEP
     */
    public fun gep(inbounds: Boolean, indices: List<ConstantInt>): Value {
        val ptr = indices.map { it.ref }.toTypedArray()

        val ref = if (inbounds) {
            LLVM.LLVMConstInBoundsGEP(ref, PointerPointer(*ptr), indices.size)
        } else {
            LLVM.LLVMConstGEP(ref, PointerPointer(*ptr), indices.size)
        }

        return Value(ref)
    }

    /**
     * Extract the value of a member field from an aggregate value
     *
     * This instruction is similar to GEP.
     *
     * The major differences to getelementptr indexing are:
     *
     * - Since the value being indexed is not a pointer, the first index is
     *   omitted and assumed to be zero.
     * - At least one index must be specified.
     * - Not only struct indices but also array indices must be in bounds.
     *
     * @see LLVM.LLVMConstExtractValue
     */
    public fun extract(indices: List<Int>): Value {
        val arr = indices.toTypedArray().toIntArray()
        val ref = LLVM.LLVMConstExtractValue(ref, arr, arr.size)

        return Value(ref)
    }

    /**
     * Insert the value into an aggregate value
     *
     * This instruction uses the same navigation system as [extract]
     *
     * @see LLVM.LLVMConstInsertValue
     */
    public fun insert(value: Value, indices: List<Int>): Value {
        val arr = indices.toTypedArray().toIntArray()
        val ref = LLVM.LLVMConstInsertValue(ref, value.ref, arr, arr.size)

        return Value(ref)
    }
}
