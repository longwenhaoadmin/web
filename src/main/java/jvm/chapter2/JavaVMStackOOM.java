package jvm.chapter2;
/*
*
*@author longwh
*@since2019年3月16日
*VM Args：-Xss2M(这时候不妨设置大些)
*	注意 特别提示一下，如果读者要尝试运行上面这段代码，记得要先保存当前的工作。
*	由于在Windows平台的虚拟机中，Java的线程是映射到操作系统的内核线程上的[1]，因此上述
*	代码执行时有较大的风险，可能会导致操作系统假死。
*/
public class JavaVMStackOOM {
	private void dontStop() {
		while (true) {
			
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
