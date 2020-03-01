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

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtShort) {
			return value == ((NbtShort) object).value;
		}
		return false;
	}
}
