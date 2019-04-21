package com.github.leftpathlane.jnbt;

import com.github.leftpathlane.jnbt.types.*;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NbtWriter {
	private final DataOutputStream out;
	private final ByteArrayOutputStream outputBytes;

	public NbtWriter() {
		out = new DataOutputStream(outputBytes = new ByteArrayOutputStream());
	}

	public byte[] write(NbtCompound nbt) throws IOException {
		writeNbt(nbt, false);
		return outputBytes.toByteArray();
	}

	private void writeNbt(NbtType nbt, boolean list) throws IOException {
		if (!list) out.write(nbt.getId());
		if (!list) writeString(nbt.getName());
		switch (nbt.getId()) {
			case NbtType.NBT_TAG_BYTE:
				out.write(((NbtByte)nbt).getValue());
				break;
			case NbtType.NBT_TAG_SHORT:
				out.writeShort(((NbtShort)nbt).getValue());
				break;
			case NbtType.NBT_TAG_INT:
				out.writeInt(((NbtInt)nbt).getValue());
				break;
			case NbtType.NBT_TAG_LONG:
				out.writeLong(((NbtLong)nbt).getValue());
				break;
			case NbtType.NBT_TAG_FLOAT:
				out.writeFloat(((NbtFloat)nbt).getValue());
				break;
			case NbtType.NBT_TAG_DOUBLE:
				out.writeDouble((((NbtDouble)nbt).getValue()));
				break;
			case NbtType.NBT_TAG_BYTE_ARRAY:
				out.writeInt(((NbtByteArray)nbt).getValue().length);
				out.write(((NbtByteArray)nbt).getValue());
				break;
			case NbtType.NBT_TAG_STRING:
				writeString(((NbtString)nbt).getValue());
				break;
			case NbtType.NBT_TAG_LIST:
				out.write(((NbtList)nbt).getType());
				out.writeInt(((NbtList)nbt).getValue().size());
				for (NbtType type : ((NbtList) nbt).getValue()) {
					writeNbt(type, true);
				}
				break;
			case NbtType.NBT_TAG_COMPOUND:
				for (NbtType type : ((NbtCompound)nbt).getValue().values()) {
					writeNbt(type, false);
				}
				out.write(NbtType.NBT_TAG_END);
				break;
			case NbtType.NBT_TAG_INT_ARRAY:
				out.writeInt(((NbtIntArray)nbt).getValue().length);
				for (int value : ((NbtIntArray)nbt).getValue()) {
					out.writeInt(value);
				}
				break;
			case NbtType.NBT_TAG_LONG_ARRAY:
				out.writeInt(((NbtLongArray)nbt).getValue().length);
				for (long value : ((NbtLongArray)nbt).getValue()) {
					out.writeLong(value);
				}
				break;
		}
	}

	private void writeString(String string) throws IOException {
		out.writeShort(string.length());
		out.write(string.getBytes());
	}
}
