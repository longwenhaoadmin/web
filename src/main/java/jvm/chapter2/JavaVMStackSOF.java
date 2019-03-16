package jvm.chapter2;
/*
*
*@author longwh
*@since2019��3��16��
*VM Args��-Xss128k
*/
public class JavaVMStackSOF{
	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[]args)throws Throwable{
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length:"+oom.stackLength);
			throw e;
		}
	}
}

