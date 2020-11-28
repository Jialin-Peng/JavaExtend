package 查看字符出现次数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//输入字符串
		System.out.print("请输入一个字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		//创建map集合
		//Map<Character,Integer> map=new HashMap<Character,Integer>();  无序输出
		Map<Character,Integer> map=new TreeMap<Character,Integer>();  //有序输出
		/*
			将字符存入map集合，并判断
			如果集合中不存在该字符，则在该集合中存入该字符
			如果集合中已经存在该字符，则在该集合中将该字符的值+1
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
		//遍历map集合
		System.out.print("字符(出现次数)：");
		for(Character key:map.keySet()) {
		String result=key+"("+map.get(key)+")";
		System.out.print(result);
		}
		sc.close();
	}

}
