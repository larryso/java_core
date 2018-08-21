package collection.list;

/**
 * 
 * @author dsong
 * 
 *         一、ArrayList的底层是Object类的数组，默认长度是10,超过10后，长度变为原长度的1.5倍。
 * 
 *         二、可以简单的认为是一个动态数组；实际上ArrayList就是用数组实现的，长度不够时，调用Arrays.copyOf方法，拷
 *         贝当前数组到一个新的长度更大的数组。
 * 
 *         三、特点：随机访问速度快，插入和移除性能较差(数组的特点)；
 * 
 *         支持null元素；
 * 
 *         有顺序；
 * 
 *         元素可以重复；
 * 
 *         线程不安全。
 *
 * 
 */
public class MyArrayList {
	private Object[] elementData;
	private int size;

	public MyArrayList() throws Exception {
		this(10);
	}

	public MyArrayList(int initialCapacity) throws Exception {
		if (initialCapacity < 0) {
			throw new Exception();
		} else {
			elementData = new Object[initialCapacity];
		}
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}

}
