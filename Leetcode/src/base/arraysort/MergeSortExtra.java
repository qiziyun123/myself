package base.arraysort;

public class MergeSortExtra {
	/**
	 * ���ù鲢�����еķ���˼�룬���ֲ�ͬ��ֻ�������СûҪ������
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {4, 3, 1, 7, 6};
		//Ҫ�� ����С�ıȽϴ��� ѡ���������ֵ����Сֵ
		
		// �������� 3��4  1��7  6 n/2�Ƚϴ���
		int i =0;
		while(i<a.length-1) {
			if(a[i]>a[i+1]) {
				swap(a,i,i+1);
			}
			i =i+2;
		}
		int max = a[0],min =a[1];
		// ÿ�Ե�һ���Ƚ� n/2
		// ÿ�Եڶ����Ƚ������ n/2
		int length = a.length;
		
		int j =1;
		//3��4  1��7  6
		while(j<a.length-1) {
			min = Math.min(a[j], min);
			max = Math.max(a[j+1], max);
			j=j+2;
		}
		
		if(length%2!=0) {
			int last = a[length-1];
			min = Math.min(last, min);
			max = Math.max(last, max);
		}
		
		System.out.println(min);
		System.out.println(max);
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}

}
