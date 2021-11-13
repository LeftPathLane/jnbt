package com.github.leftpathlane.jnbt.types;

import java.util.Arrays;
import java.util.StringJoiner;

public class NbtLongArray extends NbtType<long[]> {
	private final long[] value;

	public NbtLongArray(String name, long[] value) {
		super(name, NbtTag.NBT_TAG_LONG_ARRAY);
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

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtLongArray) {
			return Arrays.equals(value, ((NbtLongArray) object).value);
		}
		return false;
	}
}
