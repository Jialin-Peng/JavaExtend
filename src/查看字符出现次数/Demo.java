package �鿴�ַ����ִ���;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�����ַ���
		System.out.print("������һ���ַ�����");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		//����map����
		//Map<Character,Integer> map=new HashMap<Character,Integer>();  �������
		Map<Character,Integer> map=new TreeMap<Character,Integer>();  //�������
		/*
			���ַ�����map���ϣ����ж�
			��������в����ڸ��ַ������ڸü����д�����ַ�
			����������Ѿ����ڸ��ַ������ڸü����н����ַ���ֵ+1
		*/
		for(int i=0;i<s.length();i++) {
			char key=s.charAt(i);
			Integer value=map.get(key);
			if(map.get(key)==null) {
				map.put(key, 1);
			}else {
				value++;
				map.put(key, value);
			}
		}
		//����map����
		System.out.print("�ַ�(���ִ���)��");
		for(Character key:map.keySet()) {
		String result=key+"("+map.get(key)+")";
		System.out.print(result);
		}
		sc.close();
	}

}
