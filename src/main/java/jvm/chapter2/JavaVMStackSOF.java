package jvm.chapter2;

import java.sql.Array;
import java.util.List;

/*
*
*@author longwh
*@since2019.3.16
*VM Args:-Xss128k
*/
public class JavaVMStackSOF{
	private int stackLength=1;
	private static int KB = 1024;
	private static int MB = 1024*1024;
	
	public void stackLeak(){
		byte[] a = new byte[KB];
		stackLength++;
		stackLeak();
	}
	
	public void stackLeak1(String s){
		stackLength++;
		String a = s+s;
		stackLeak1(s);
	}
	
	public static void main(String[]args)throws Throwable{
		JavaVMStackSOF oom=new JavaVMStackSOF();
		byte[] a = new byte[KB];
		try{
			String s = "java";
			oom.stackLeak1(s);
		}catch(Throwable e){
			System.out.println("stack length:"+oom.stackLength);
			throw e;
		}
	}
}

