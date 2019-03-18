package jvm.chapter3;
/*
*
*@author longwh
*@since2019年3月16日
*/
public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/**
	 * 这个成员属性的唯一意义就是占点内存,以便能在GC日志中看清楚是否被回收过
	 */
	private byte[] bigSize = new byte[2 * _1MB];

	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		// 假设在这行发生GC,objA和objB是否能被回收？
		System.gc();
	}
	
	/**
	*VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails
	-XX：SurvivorRatio=8
	*/
	public static void testAllocation(){
	byte[] allocation1,allocation2,allocation3,allocation4;
	/*allocation1=new byte[2*_1MB];
	allocation2=new byte[2*_1MB];
	allocation4=new byte[5*_1MB];//出现一次Minor GC
*/	}

	
	public static void main(String[] args) {
		//testAllocation();
		//System.gc();
		//System.gc();
	}
}

