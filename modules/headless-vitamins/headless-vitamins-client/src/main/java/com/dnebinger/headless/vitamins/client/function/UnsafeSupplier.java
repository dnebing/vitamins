package com.dnebinger.headless.vitamins.client.function;

import javax.annotation.Generated;

/**
 * @author Dave Nebinger
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}