package com.github.leftpathlane.jnbt.types;

public class NbtShort extends NbtType<Short> {
	private final short value;

	public NbtShort(String name, short value) {
		super(name, NBT_TAG_SHORT);
		this.value = value;
	}


	@Override
	public Short getValue() {
		return value;
	}
}
