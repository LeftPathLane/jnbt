
# JNBT  
JNBT is a simple library for creating reading and writing to the NBT (Named Binary Tag) format.    
JNBT supports all 12 tags in version 19133 of the NBT format.    
  
## Usage  
[Examples](#examples)    
[Reading](#reading-nbt-from-file)    
[Writing](#writing-nbt-to-file)  
  
### Examples  
  
##### Creating a compound  
Creating a new NbtCompound is simple.    
To add tags to a NbtCompound you can either add them with a name and value, or just add a NbtType.  
```java  
NbtCompound nbt = new NbtCompound();  
  
nbt.addNbt("shortTest", (short) 32767);  
nbt.addNbt(new NbtShort("shortTest2", (short) 32767));  
  
nbt.addNbt("longTest", 9223372036854775807L);  
nbt.addNbt(new NbtLong("longTest2", 9223372036854775807L));  
  
nbt.addNbt("floatTest", 0.49823147F);  
nbt.addNbt(new NbtFloat("floatTest", 0.49823147F));  
  
nbt.addNbt("intTest", 2147483647);  
nbt.addNbt(new NbtInt("intTest2", 2147483647));  
```  
  
  
To get a tag from a compound you use the `getNbt(String)` method that will return a `NbtType` object,  
you can then use the `asString()` `asInt()` `asLong()` /ie methods to cast them to that tag or return null if it doesent exist or is not of that type.  
```java  
short shortTest = nbt.getNbt("shortTest").asShort().getValue();  
  
NbtLong longTest = nbt.getNbt("longTest").asLong();  
  
float floatTest = nbt.getNbt("floatTest").asFloat().getValue();  
  
NbtInt intTest = nbt.getNbt("intTest").asInt();  
```  
  
### Reading NBT from file  
To read a NBT file you just need to create a `NbtReader` object and give it the InputStream/file  
```java  
NbtReader reader = new NbtReader(file);  
NbtCompound nbt = reader.readAll();  
```  
  
  
### Writing NBT to file  
To write a NBT object to file you need to create a `NbtWriter` object and give it the NbtType and OutputStream to write to.  
```java  
NbtCompound nbt = new NbtCompound();  
nbt.addNbt("apple", 1);  
nbt.addNbt("pear","pear");  
try (FileOutputStream out = new FileOutputStream(new File("fruit.nbt"))) {  
 new NbtWriter(nbt, out);
}  
```