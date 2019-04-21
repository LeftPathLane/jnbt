package com.github.leftpathlane.jnbt;

import com.github.leftpathlane.jnbt.types.NbtCompound;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class NbtReaderTest {

	@Test
	public void testReader() throws IOException {
		File file = new File(this.getClass().getClassLoader().getResource("bigtest.nbt").getFile());
		NbtReader reader = new NbtReader(file);
		NbtCompound nbt = reader.readAll();
		assertEquals(32767, nbt.getValue().get("shortTest").asShort().getValue().longValue());
		assertEquals(2147483647, nbt.getValue().get("intTest").asInt().getValue().longValue());
		assertEquals(127, nbt.getValue().get("byteTest").asByte().getValue().longValue());
	}
}