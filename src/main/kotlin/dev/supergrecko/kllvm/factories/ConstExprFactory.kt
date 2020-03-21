package dev.supergrecko.kllvm.factories

import dev.supergrecko.kllvm.contracts.Factory
import dev.supergrecko.kllvm.core.LLVMType
import dev.supergrecko.kllvm.core.LLVMValue
import org.bytedeco.llvm.LLVM.LLVMBasicBlockRef

public object ConstExprFactory : Factory<LLVMValue> {
    //region Core::Values::Constants::ConstantExpressions
    public fun alignOf(type: LLVMType): LLVMValue { TODO() }
    public fun sizeOf(type: LLVMType): LLVMValue { TODO() }

    public fun getConstNeg(value: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoSignedWrapNeg(value: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoUnsignedWrapNeg(value: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatNeg(value: LLVMValue): LLVMValue { TODO() }

    public fun getConstNot(value: LLVMValue): LLVMValue { TODO() }

    public fun getConstAdd(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoSignedWrapAdd(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoUnsignedWrapAdd(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatAdd(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstMul(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoSignedWrapMul(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstNoUnsignedWrapMul(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatMul(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstUnsignedDiv(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstExactUnsignedDiv(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstSignedDiv(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstExactSignedDiv(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatDiv(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstUnsignedRem(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstSignedRem(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatRem(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstAnd(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstOr(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstXor(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstIntCmp(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstFloatCmp(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstShl(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstLogicalShr(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }
    public fun getConstArithmeticShr(lhs: LLVMValue, rhs: LLVMValue): LLVMValue { TODO() }

    public fun getConstGEP(type: LLVMType, value: LLVMValue, indices: List<LLVMValue>): LLVMValue { TODO() }
    public fun getConstInBoundsGEP(type: LLVMType, value: LLVMValue, indices: List<LLVMValue>): LLVMValue { TODO() }
    public fun getConstTrunc(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }

    public fun getConstSignExt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstZeroExt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }

    public fun getConstFloatingPointTrunc(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstFloatingPointExt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstUnsignedIntToFloatingPoint(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstFloatingPointToUnsignedInt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstFloatingPointToSignedInt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstPointerToInt(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }

    public fun getConstBitCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstAddrSpaceCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstZeroExtOrBitCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstSignEXtOrBitCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstTruncOrBitCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstPointerCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstIntCast(value: LLVMValue, type: LLVMType, signed: Boolean): LLVMValue { TODO() }
    public fun getConstFloatingPointCast(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }

    public fun getConstSelect(value: LLVMValue, type: LLVMType): LLVMValue { TODO() }
    public fun getConstExtractElement(vector: LLVMValue, index: LLVMValue): LLVMValue { TODO() }
    public fun getConstInsertElement(vector: LLVMValue, element: LLVMValue, index: LLVMValue): LLVMValue { TODO() }
    // TODO: replace vectorBConstant, maskConstant
    public fun getConstShuffleVector(vector: LLVMValue, vectorBConstant: LLVMValue, maskConstant: LLVMValue): LLVMValue { TODO() }
    public fun getConstExtractValue(aggregate: LLVMValue, indices: List<Int>, index: Int): LLVMValue { TODO() }
    public fun getConstInsertValue(aggregate: LLVMValue, element: LLVMValue, indices: List<Int>, index: Int): LLVMValue { TODO() }

    // TODO: replace BasicBlockRef
    public fun blockAddress(value: LLVMValue, block: LLVMBasicBlockRef): LLVMValue { TODO() }
    //endregion Core::Values::Constants::ConstantExpressions
}