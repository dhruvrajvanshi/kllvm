package dev.supergrecko.kllvm.llvm

import dev.supergrecko.kllvm.contracts.Disposable
import dev.supergrecko.kllvm.enumerations.Initializations
import org.bytedeco.llvm.global.LLVM

public class KLLVM {
    private val disposablePool: MutableList<Disposable> = mutableListOf()
    private val routines: MutableList<Initializations> = mutableListOf()

    public fun with(routine: Initializations) {
        if (!routines.contains(routine)) {
            routines.add(routine)
        }
    }

    /**
     * Let KLLVm track disposable values
     *
     * KLLVM will dispose any un-freed disposables when [shutdown] is called.
     */
    public fun trackDisposables() {}

    public fun shutdown() {
        disposablePool.forEach {
            if (it.valid) {
                it.dispose()
            }
        }

        LLVM.LLVMShutdown()
    }

    // TODO: implement
    public fun initialize(): KLLVM {
        // Initialize registered startup routines
        routines.forEach {
            when (it) {
                Initializations.AllAsmParsers -> LLVM.LLVMInitializeAllAsmParsers()
                Initializations.AllTargetInfos -> LLVM.LLVMInitializeAllTargetInfos()
                Initializations.AllTargets -> LLVM.LLVMInitializeAllTargets()
                Initializations.AllTargetMCs -> LLVM.LLVMInitializeAllTargetMCs()
                Initializations.AllAsmPrinters -> LLVM.LLVMInitializeAllAsmPrinters()
                Initializations.AllDisassemblers -> LLVM.LLVMInitializeAllDisassemblers()
                Initializations.NativeTarget -> LLVM.LLVMInitializeNativeTarget()
                Initializations.NativeAsmParser -> LLVM.LLVMInitializeNativeAsmPrinter()
                Initializations.NativeAsmPrinter -> LLVM.LLVMInitializeNativeAsmPrinter()
                Initializations.NativeDisassembler -> LLVM.LLVMInitializeNativeDisassembler()
            }
        }

        return this
    }
}

public fun initialize(apply: KLLVM.() -> Unit): KLLVM {
    return KLLVM().apply(apply).initialize()
}