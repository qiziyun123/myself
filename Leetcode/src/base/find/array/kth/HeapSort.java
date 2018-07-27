package base.find.array.kth;
/**
 * ��������������������ĵ�K��Ԫ��(С����)
 * �ѽṹ�ο� https://www.cnblogs.com/zhonghuasong/p/6553931.html���߰ٶ�һ��
 * @author qizy
 * �˷��������K����ǰK������ǰK�޷���֤˳��
 */
public class HeapSort {

	public static void main(String[] args) {
		int a [] = {12,17,19,30,50,20,65,60,4,49};
		// ���4��Ԫ��
		// ������ǰ4��Ԫ�ؽ��ж����� ������С���ѣ�ԭ��
		// ��һ�ӵ����Ԫ��
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
	 * @param a Ҫ�����������
	 * @param Ҫ����ѵĴ�С
	 */
	private static void heapsort(int[] a, int size) {
		// ������ ���Ѵ�СΪsize
		bulidMinHeap(a,size);
		
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		// ���±�size��ʼ����һ����
		for(int i =size;i<a.length;i++) {
			if(a[i]>= a[0]) {
				//��Ѷ�����
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
		// ��һ����Ҷ�ӽڵ���һ����
		for(int i = size/2-1;i>=0;i--) {
			adjustMinHeap(a,i,size);
		}
		
	}

	private static void adjustMinHeap(int[] a, int parent, int length) {
		int temp = a[parent];
		int l = parent*2+1;
		int r = parent*2+2;
		int min = parent;
		if(parent<=length/2-1) {// Ҷ�ڵ�Ͳ��ý��е��� 
			
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
