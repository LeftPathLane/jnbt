package com.github.leftpathlane.jnbt.types;

public class NbtLong extends NbtType<Long> {
	private final long value;

	public NbtLong(String name, long value) {
		super(name, NBT_TAG_LONG);
		this.value = value;
	}

	@Override
	public Long getValue() {
		return value;
	}
}
