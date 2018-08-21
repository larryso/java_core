package main;

import java.io.File;
import java.net.URL;

public class Test {
	public static void main(String[] args){
		Path p = new Path();
	}


}
class Path{
	{
		URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println((new File(xmlpath.getFile()).getParent()));

	}
}
