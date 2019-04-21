package com.github.leftpathlane.jnbt.types;

public class NbtDouble extends NbtType<Double> {
	private final double value;

	public NbtDouble(String name, double value) {
		super(name, NBT_TAG_DOUBLE);
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}
}
