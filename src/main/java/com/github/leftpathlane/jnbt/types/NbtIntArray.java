package com.github.leftpathlane.jnbt.types;

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
}
