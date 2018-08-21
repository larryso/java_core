package annotation;

public class SuppressWarningsAnnotationDemo01 {
	@SuppressWarnings(value={})
	public static void main(String[] args){
		Demo<String> d = new Demo<String>();
		d.setVar("content");
		System.out.println(d.getVar());
	}
}

@Deprecated
class Demo<T> {
	private T var;

	public T getVar() {
		return this.var;
	}

	public void setVar(T var) {
		this.var = var;
	}

}
