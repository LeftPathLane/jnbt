package com.github.leftpathlane.jnbt.types;

public abstract class NbtType<T> {
	public static final int NBT_TAG_END = 0,
			NBT_TAG_BYTE = 1,
			NBT_TAG_SHORT = 2,
			NBT_TAG_INT = 3,
			NBT_TAG_LONG = 4,
			NBT_TAG_FLOAT = 5,
			NBT_TAG_DOUBLE = 6,
			NBT_TAG_BYTE_ARRAY = 7,
			NBT_TAG_STRING = 8,
			NBT_TAG_LIST = 9,
			NBT_TAG_COMPOUND = 10,
			NBT_TAG_INT_ARRAY = 11,
			NBT_TAG_LONG_ARRAY = 12;

	protected final String name;
	protected final int id;

	public NbtType(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public abstract T getValue();

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " Name:\"" + name + "\" Value\"" + (getValue() == null ? "null" : getValue()) + "\"";
	}
}
