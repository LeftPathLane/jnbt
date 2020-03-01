package com.github.leftpathlane.jnbt.types;

public class NbtByte extends NbtType<Byte> {
	private byte value;

	public NbtByte(String name, byte value) {
		super(name, NBT_TAG_BYTE);
		this.value = value;
	}

	public boolean asBoolean() {
		return value == 1;
	}

	@Override
	public Byte getValue() {
		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtByte) {
			return value == ((NbtByte) object).value;
		}
		return false;
	}
}
