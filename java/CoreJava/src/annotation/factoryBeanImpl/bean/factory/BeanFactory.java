package annotation.factoryBeanImpl.bean.factory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import annotation.factoryBeanImpl.Entity;
import annotation.factoryBeanImpl.EntityProperty;
import annotation.factoryBeanImpl.util.AnnotationClassUtil;

public class BeanFactory {
	private static Map<String, Object> beans = new HashMap<String, Object>();
	private String packageName = "annotation.factoryBeanImpl.bean";
	private static String _END_SUFFIX_ = "_SUFFIX_CLS";

	public void init() throws Exception {
		Set<Class<?>> tempSet = AnnotationClassUtil.getClassSet(packageName);
		for (Class<?> clazz : tempSet) {
			Entity entity = clazz.getAnnotation(Entity.class);
			String entityValue = entity.name();
			boolean isLazyLoad = entity.isLazyLoad();
			System.out.println("Load class: " + clazz.getName() + " with success.");
			if (isLazyLoad) {
				beans.put(entityValue + _END_SUFFIX_, clazz);
			} else {
				beans.put(entityValue, newInstance(clazz));
			}

		}
	}

	private Object newInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(EntityProperty.class)) {
				EntityProperty property = f.getAnnotation(EntityProperty.class);
				f.setAccessible(true);
				f.set(obj, property.value());
				f.setAccessible(false);
			}
		}
		return obj;
	}

	public Object getBean(String name) throws InstantiationException, IllegalAccessException {
		if (beans.containsKey(name)) {
			return beans.get(name);
		} else if (beans.containsKey(name + _END_SUFFIX_)) {
			Class<?> clazz = (Class<?>) beans.get(name + _END_SUFFIX_);
			Object obj = newInstance(clazz);
			beans.remove(name + _END_SUFFIX_);
			beans.put(name, obj);
			return obj;

		}
		return null;
	}
}
