package com.github.leftpathlane.jnbt.types;

public class NbtInt extends NbtType<Integer> {
	private final int value;

	public NbtInt(String name, int value) {
		super(name, NBT_TAG_INT);
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
