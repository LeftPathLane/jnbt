package com.github.leftpathlane.jnbt.types;

public class NbtLongArray extends NbtType<long[]> {
	private final long[] value;

	public NbtLongArray(String name, long[] value) {
		super(name, NBT_TAG_LONG_ARRAY);
		this.value = value;
	}

	@Override
	public long[] getValue() {
		return value;
	}
}
