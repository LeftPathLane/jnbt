package com.github.leftpathlane.jnbt.types;

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
}
