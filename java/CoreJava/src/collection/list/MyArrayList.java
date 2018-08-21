package collection.list;

/**
 * 
 * @author dsong
 * 
 *         һ��ArrayList�ĵײ���Object������飬Ĭ�ϳ�����10,����10�󣬳��ȱ�Ϊԭ���ȵ�1.5����
 * 
 *         �������Լ򵥵���Ϊ��һ����̬���飻ʵ����ArrayList����������ʵ�ֵģ����Ȳ���ʱ������Arrays.copyOf��������
 *         ����ǰ���鵽һ���µĳ��ȸ�������顣
 * 
 *         �����ص㣺��������ٶȿ죬������Ƴ����ܽϲ�(������ص�)��
 * 
 *         ֧��nullԪ�أ�
 * 
 *         ��˳��
 * 
 *         Ԫ�ؿ����ظ���
 * 
 *         �̲߳���ȫ��
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
