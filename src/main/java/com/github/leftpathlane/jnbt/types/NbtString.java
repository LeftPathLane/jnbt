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

	@Override
	public String toJson() {
		return name == null || name.isEmpty() ? "\"" + value + "\"" : "\"" + name + "\":\"" + value + "\"";
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtString) {
			if (value.length() != ((NbtString) object).value.length()) return false;
			return value.equals(((NbtString) object).value);
		}
		return false;
	}
}
