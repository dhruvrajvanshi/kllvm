package dev.supergrecko.kllvm.internal.contracts

import org.bytedeco.javacpp.Pointer

public interface ContainsReference<T : Pointer> {
    val ref: T
}
