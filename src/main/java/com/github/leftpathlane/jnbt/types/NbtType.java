package com.github.leftpathlane.jnbt.types;

public abstract class NbtType<T> {
	protected final String name;
	protected final NbtTag id;

	public NbtType(String name, NbtTag id) {
		this.name = name;
		this.id = id;
	}

	public abstract T getValue();

	public String getName() {
		return this.name;
	}

	public NbtTag getId() {
		return this.id;
	}

	public NbtByte asByte() {
		return id == NbtTag.NBT_TAG_BYTE ? (NbtByte) this : null;
	}

	public NbtShort asShort() {
		return id == NbtTag.NBT_TAG_SHORT ? (NbtShort) this : null;
	}

	public NbtInt asInt() {
		return id == NbtTag.NBT_TAG_INT ? (NbtInt) this : null;
	}

	public NbtLong asLong() {
		return id == NbtTag.NBT_TAG_LONG ? (NbtLong) this : null;
	}

	public NbtFloat asFloat() {
		return id == NbtTag.NBT_TAG_FLOAT ? (NbtFloat) this : null;
	}

	public NbtDouble asDouble() {
		return id == NbtTag.NBT_TAG_DOUBLE ? (NbtDouble) this : null;
	}

	public NbtByteArray asByteArray() {
		return id == NbtTag.NBT_TAG_BYTE_ARRAY ? (NbtByteArray) this : null;
	}

	public NbtString asString() {
		return id == NbtTag.NBT_TAG_STRING ? (NbtString) this : null;
	}

	public NbtList asList() {
		return id == NbtTag.NBT_TAG_LIST ? (NbtList<?>) this : null;
	}

	public NbtCompound asCompound() {
		return id == NbtTag.NBT_TAG_COMPOUND ? (NbtCompound) this : null;
	}

	public NbtIntArray asIntArray() {
		return id == NbtTag.NBT_TAG_INT_ARRAY ? (NbtIntArray) this : null;
	}

	public NbtLongArray asLongArray() {
		return id == NbtTag.NBT_TAG_LONG_ARRAY ? (NbtLongArray) this : null;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " Name:\"" + name + "\" Value\"" + (getValue() == null ? "null" : getValue()) + "\"";
	}

	public String toJson() {
		return name == null || name.isEmpty() ? String.valueOf(getValue()) : "\"" + name + "\":" + getValue();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object instanceof NbtType) {
			if (((NbtType) object).id != id) return false;
			if (name.length() != ((NbtType) object).name.length()) return false;
			return name.equals(((NbtType) object).name);
		}
		return false;
	}
}
