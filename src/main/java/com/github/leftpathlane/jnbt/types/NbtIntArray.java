package com.github.leftpathlane.jnbt.types;

import java.util.Arrays;
import java.util.StringJoiner;

public class NbtIntArray extends NbtType<int[]> {
	private final int[] value;

	public NbtIntArray(String name, int[] value) {
		super(name, NBT_TAG_INT_ARRAY);
		this.value = value;
	}

	@Override
	public int[] getValue() {
		return value;
	}

	@Override
	public String toJson() {
		StringJoiner joiner = new StringJoiner(",");
		for (int val : value) {
			joiner.add(Integer.toString(val));
		}
		return name == null || name.isEmpty() ? joiner.toString() : "\"" + name + "\":[" + joiner.toString() + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtIntArray) {
			return Arrays.equals(value, ((NbtIntArray) object).value);
		}
		return false;
	}
}
