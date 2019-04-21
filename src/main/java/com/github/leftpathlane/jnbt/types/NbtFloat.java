package com.github.leftpathlane.jnbt.types;

public class NbtFloat extends NbtType<Float> {
	private final float value;

	public NbtFloat(String name, float value) {
		super(name, NBT_TAG_FLOAT);
		this.value = value;
	}

	@Override
	public Float getValue() {
		return value;
	}
}
