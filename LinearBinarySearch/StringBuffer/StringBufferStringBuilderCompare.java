package stringBuffer;

public class StringBufferStringBuilderCompare {

	public static void main(String args[]) {
		int appendTime = 1000000;
		String appendStr = "Hello ";
		
		StringBuilder strBuilder = new StringBuilder();
		long startBuilderTime = System.nanoTime();
		for(int i=0; i<appendTime; i++) {
			strBuilder.append(appendStr);
		}
		long endBuilderTime = System.nanoTime();
		
		StringBuffer strBuffer = new StringBuffer();
		long startBufferTime = System.nanoTime();
		for(int i=0; i<appendTime; i++) {
			strBuffer.append(appendStr);
		}
		long endBufferTime = System.nanoTime();
		
		long durationBuilder = endBuilderTime - startBuilderTime;
		long durationBuffer = endBufferTime - startBufferTime;
		
		System.out.println("time taken by builder "+ durationBuilder/appendTime +"ms");
		System.out.println("time taken by buffer "+ durationBuffer/appendTime +"ms");
	}
}