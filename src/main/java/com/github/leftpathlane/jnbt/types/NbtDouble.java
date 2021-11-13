package com.github.leftpathlane.jnbt.types;

public class NbtDouble extends NbtType<Double> {
	private final double value;

	public NbtDouble(String name, double value) {
		super(name, NbtTag.NBT_TAG_DOUBLE);
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtDouble) {
			return value == ((NbtDouble) object).value;
		}
		return false;
	}
}
