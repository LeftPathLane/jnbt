package com.github.leftpathlane.jnbt.types;

import java.util.StringJoiner;

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

	@Override
	public String toJson() {
		StringJoiner joiner = new StringJoiner(",");
		for (long val : value) {
			joiner.add(Long.toString(val));
		}
		return name == null || name.isEmpty() ? joiner.toString() : "\"" + name + "\":[" + joiner.toString() + "]";
	}
}
