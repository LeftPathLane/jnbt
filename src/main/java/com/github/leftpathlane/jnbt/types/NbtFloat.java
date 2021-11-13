package com.github.leftpathlane.jnbt.types;

public class NbtFloat extends NbtType<Float> {
	private final float value;

	public NbtFloat(String name, float value) {
		super(name, NbtTag.NBT_TAG_FLOAT);
		this.value = value;
	}

	@Override
	public Float getValue() {
		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtFloat) {
			return value == ((NbtFloat) object).value;
		}
		return false;
	}
}
