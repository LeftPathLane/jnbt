package com.github.leftpathlane.jnbt.types;

import java.util.Arrays;
import java.util.StringJoiner;

public class NbtByteArray extends NbtType<byte[]> {
	private final byte[] value;

	public NbtByteArray(String name, byte[] value) {
		super(name, NBT_TAG_BYTE_ARRAY);
		this.value = value;
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public String toJson() {
		StringJoiner joiner = new StringJoiner(",");
		for (byte val : value) {
			joiner.add(Byte.toString(val));
		}
		return name == null || name.isEmpty() ? joiner.toString() : "\"" + name + "\":[" + joiner.toString() + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtByteArray) {
			return Arrays.equals(value, ((NbtByteArray) object).value);
		}
		return false;
	}
}
