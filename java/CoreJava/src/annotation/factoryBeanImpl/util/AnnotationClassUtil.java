package annotation.factoryBeanImpl.util;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import annotation.factoryBeanImpl.Entity;
import annotation.factoryBeanImpl.bean.User;

public class AnnotationClassUtil {
	/**
	 * load class from package, package name like
	 * "annotation.factoryBeanImpl.bean"
	 * 
	 * @param packageName
	 * @return
	 * @throws Exception
	 */
	public static Set<Class<?>> getClassSet(String packageName) throws Exception {
		Set<Class<?>> retSet = new HashSet<Class<?>>();
		// scan all the packaged class and add them into set
		Set<Class<?>> classSet = loadClass(packageName);
		for (Class<?> clazz : classSet) {
			if (clazz.isAnnotationPresent(Entity.class)) {
				retSet.add(clazz);
			}
		}
		return retSet;
	}

	private static Set<Class<?>> loadClass(String packageName) throws Exception {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		String[] pathStringArray = packageName.split("\\.");
		String packagePath = "";
		for (String s : pathStringArray) {
			packagePath += s + File.separator;
		}
		String classPath = new AnnotationClassUtil().getClass().getClassLoader().getResource("").getFile();
		File classDir = new File(classPath + packagePath);
		File[] classFiles = classDir.listFiles();
		for (File file : classFiles) {
			if (file.isFile()) {
				classSet.add(Class.forName(packageName + "." + file.getName().split("\\.")[0]));
			}
		}
		return classSet;
	}

}
