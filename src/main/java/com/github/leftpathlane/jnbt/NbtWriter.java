package com.github.leftpathlane.jnbt;

import com.github.leftpathlane.jnbt.types.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class NbtWriter {
	private final DataOutputStream out;

	public NbtWriter(NbtType nbt, OutputStream outputStream) throws IOException {
		this.out = new DataOutputStream(outputStream);
		writeNbt(nbt, false);
		out.flush();
	}

	private void writeNbt(NbtType nbt, boolean list) throws IOException {
		if (!list) out.write(nbt.getId().ordinal());
		if (!list) writeString(nbt.getName());
		switch (nbt.getId()) {
			case NBT_TAG_BYTE:
				out.write(((NbtByte) nbt).getValue());
				break;
			case NBT_TAG_SHORT:
				out.writeShort(((NbtShort) nbt).getValue());
				break;
			case NBT_TAG_INT:
				out.writeInt(((NbtInt) nbt).getValue());
				break;
			case NBT_TAG_LONG:
				out.writeLong(((NbtLong) nbt).getValue());
				break;
			case NBT_TAG_FLOAT:
				out.writeFloat(((NbtFloat) nbt).getValue());
				break;
			case NBT_TAG_DOUBLE:
				out.writeDouble((((NbtDouble) nbt).getValue()));
				break;
			case NBT_TAG_BYTE_ARRAY:
				out.writeInt(((NbtByteArray) nbt).getValue().length);
				out.write(((NbtByteArray) nbt).getValue());
				break;
			case NBT_TAG_STRING:
				writeString(((NbtString) nbt).getValue());
				break;
			case NBT_TAG_LIST:
				out.write(((NbtList) nbt).getType().ordinal());
				out.writeInt(((NbtList) nbt).getValue().size());
				for (NbtType type : ((List<NbtType>)((NbtList) nbt).getValue())) {
					writeNbt(type, true);
				}
				break;
			case NBT_TAG_COMPOUND:
				for (NbtType type : ((NbtCompound) nbt).getValue().values()) {
					writeNbt(type, false);
				}
				out.write(NbtTag.NBT_TAG_END.ordinal());
				break;
			case NBT_TAG_INT_ARRAY:
				out.writeInt(((NbtIntArray) nbt).getValue().length);
				for (int value : ((NbtIntArray) nbt).getValue()) {
					out.writeInt(value);
				}
				break;
			case NBT_TAG_LONG_ARRAY:
				out.writeInt(((NbtLongArray) nbt).getValue().length);
				for (long value : ((NbtLongArray) nbt).getValue()) {
					out.writeLong(value);
				}
				break;
		}
	}

	private void writeString(String string) throws IOException {
		if (string == null || string.isEmpty()) {
			out.writeShort(0);
			return;
		}
		out.writeShort(string.length());
		out.write(string.getBytes());
	}
}
