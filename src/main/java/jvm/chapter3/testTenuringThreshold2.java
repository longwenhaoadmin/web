package jvm.chapter3;

public class testTenuringThreshold2 {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio=8-XX：MaxTenuringThreshold=15
	 * -XX：+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6,
		allocation7;
		
		//allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation1 = new byte[_1MB / 8];
		allocation6 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB / 8];
		// allocation1+allocation2大于survivo空间一半
		
		/*allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation5 = new byte[_1MB / 4];
		allocation4 = new byte[4 * _1MB];*/
		/*allocation4 = null;
		allocation6 = new byte[_1MB / 4];*/
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation7 = new byte[_1MB / 100*1];
		allocation4 = new byte[4 * _1MB];
	}
	public static void main(String[] args) {
		testTenuringThreshold2();
	}

}
