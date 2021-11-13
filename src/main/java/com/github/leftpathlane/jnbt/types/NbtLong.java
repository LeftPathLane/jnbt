package com.github.leftpathlane.jnbt.types;

public class NbtLong extends NbtType<Long> {
	private final long value;

	public NbtLong(String name, long value) {
		super(name, NbtTag.NBT_TAG_LONG);
		this.value = value;
	}

	@Override
	public Long getValue() {
		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtLong) {
			return value == ((NbtLong) object).value;
		}
		return false;
	}
}
