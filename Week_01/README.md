### 作业二：自定义类加载器加载Hello.xclass文件

##### 1. 自定义ClassLoader

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Description：Define a class loader to load the bytecode file Hello.xclass which is compiled from Hello.java
 * <p>
 * Environment jdk1.8.0_231
 *
 * @author Zhang Shiqi
 * @version 1.0
 * @date 2020/10/21
 */
public class HelloClassLoader extends ClassLoader {

	public static void main(String[] args) {
		try {
			Class<?> clz = new HelloClassLoader().findClass("Hello");
			Method hello = clz.getMethod("hello");
			hello.setAccessible(true);
			hello.invoke(clz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException{
		String filePath = HelloClassLoader.class.getResource("/" + className + ".xclass").getPath();
		File file = new File(filePath);
		int length = (int) file.length();
		byte[] bytes = new byte[length];
		try {
			new FileInputStream(file).read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return super.findClass(className);
		}
		// key code
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (255 - bytes[i]);
		}
		return defineClass(className, bytes, 0, bytes.length);
	}
}
```



### 作业三：图解JVM内存及参数关系

![JVM内存图解](/Users/simu/Documents/lesson/JAVA-000/Week_01/JVM内存图解.png)