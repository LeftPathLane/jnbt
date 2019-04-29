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

	public NbtByte asByte() {
		return id == NBT_TAG_BYTE ? (NbtByte) this : null;
	}

	public NbtShort asShort() {
		return id == NBT_TAG_SHORT ? (NbtShort) this : null;
	}

	public NbtInt asInt() {
		return id == NBT_TAG_INT ? (NbtInt) this : null;
	}

	public NbtLong asLong() {
		return id == NBT_TAG_LONG ? (NbtLong) this : null;
	}

	public NbtFloat asFloat() {
		return id == NBT_TAG_FLOAT ? (NbtFloat) this : null;
	}

	public NbtDouble asDouble() {
		return id == NBT_TAG_DOUBLE ? (NbtDouble) this : null;
	}

	public NbtByteArray asByteArray() {
		return id == NBT_TAG_BYTE_ARRAY ? (NbtByteArray) this : null;
	}

	public NbtString asString() {
		return id == NBT_TAG_STRING ? (NbtString) this : null;
	}

	public NbtList asList() {
		return id == NBT_TAG_LIST ? (NbtList) this : null;
	}

	public NbtCompound asCompound() {
		return id == NBT_TAG_COMPOUND ? (NbtCompound) this : null;
	}

	public NbtIntArray asIntArray() {
		return id == NBT_TAG_INT_ARRAY ? (NbtIntArray) this : null;
	}

	public NbtLongArray asLongArray() {
		return id == NBT_TAG_LONG_ARRAY ? (NbtLongArray) this : null;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " Name:\"" + name + "\" Value\"" + (getValue() == null ? "null" : getValue()) + "\"";
	}

	public String toJson() {
		return name == null || name.isEmpty() ? String.valueOf(getValue()) : "\"" + name + "\":" + getValue();
	}
}
