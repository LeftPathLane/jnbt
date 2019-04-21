package com.github.leftpathlane.jnbt.types;

public class NbtString extends NbtType<String> {
	private final String value;

	public NbtString(String name, String value) {
		super(name, NBT_TAG_STRING);
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}
