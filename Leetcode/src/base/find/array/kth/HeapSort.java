package base.find.array.kth;
/**
 * 堆排序特性求无需数组的第K大元素(小顶堆)
 * 堆结构参考 https://www.cnblogs.com/zhonghuasong/p/6553931.html或者百度一下
 * @author qizy
 * 此方法可求第K，和前K个，但前K无法保证顺序
 */
public class HeapSort {

	public static void main(String[] args) {
		int a [] = {12,17,19,30,50,20,65,60,4,49};
		// 求第4大元素
		// 对数组前4个元素进行堆排序 ，构造小顶堆，原理
		// 逐一从第五个元素
		heapsort(a,4);
		System.out.println(" ");
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		int result = a[0];
		System.out.println();
		System.out.println(result);
	}
	
	/**
	 * 
	 * @param a 要堆排序的数组
	 * @param 要排序堆的大小
	 */
	private static void heapsort(int[] a, int size) {
		// 构建堆 ，堆大小为size
		bulidMinHeap(a,size);
		
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		// 从下表size开始，逐一便利
		for(int i =size;i<a.length;i++) {
			if(a[i]>= a[0]) {
				//与堆顶交换
				swap(a,i,0);
				System.out.println(" swap " + i + " finish ");
				for (int j : a) {
					System.out.print(j);
					System.out.print(" ");
				}
				System.out.println();
				adjustMinHeap(a, 0, size);
				System.out.println(" adjust finish ");
				for (int j : a) {
					System.out.print(j);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
		
	}

	private static void bulidMinHeap(int[] a, int size) {
		// 第一个非叶子节点逐一调整
		for(int i = size/2-1;i>=0;i--) {
			adjustMinHeap(a,i,size);
		}
		
	}

	private static void adjustMinHeap(int[] a, int parent, int length) {
		int temp = a[parent];
		int l = parent*2+1;
		int r = parent*2+2;
		int min = parent;
		if(parent<=length/2-1) {// 叶节点就不用进行调整 
			
			if(l<length&&a[l]<a[parent]) {
				min = l;
			}
			if(r<length&&a[r]<a[min]) {
				min = r;
			}
			if(temp>a[min]) {
				swap(a,min,parent);
				adjustMinHeap(a, min, length);
			}
		}
		
	}

	private static void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j]=a[i];
		a[i]=temp;
		
	}

}
