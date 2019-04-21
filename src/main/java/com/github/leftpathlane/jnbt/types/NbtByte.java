package com.github.leftpathlane.jnbt.types;

public class NbtByte extends NbtType<Byte> {
	private byte value;

	public NbtByte(String name, byte value) {
		super(name, NBT_TAG_BYTE);
		this.value = value;
	}

	@Override
	public Byte getValue() {
		return value;
	}
}
