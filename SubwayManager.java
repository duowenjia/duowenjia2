//信1605-3 20163677 多文佳

import java.util.Scanner;
import java.io.*;

public class SubwayManager {
	public static void main(String[] args) throws IOException{
		 FileWriter fw = null;
		 FirstLineSubway c=new FirstLineSubway();
		 ThirdLineSubway d=new ThirdLineSubway();
		 String a[]= {"洨河大道","南村","石家庄东站","火炬广场","留村","白佛","朝晖桥","谈固","北宋","体育场","博物馆","北国商城","平安大街","解放广场","新百广场","烈士陵园","和平医院","长城桥","时光街","西王"};
		 String b[]={"市二中","新百广场","东里","槐安桥","西三教","石家庄站"};
	        try {
	                                                              //创建字符输出流
	            fw = new FileWriter("shijiazhuang-subway.txt");
	            fw.write("一号线\r\n");
	            for(int i=0;i<20;i++) {
	            	fw.write(a[i]+"\r\n");
	            }
	            fw.write("三号线\r\n");
	            for(int i=0;i<6;i++) {
	            	fw.write(b[i]+"\r\n");
	            }
	   
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	                                                               //使用finally块来关闭文件输出流
	            if (fw != null) {
	              fw.close();
	            }       
	        }                                                      //将地铁路线相关信息存入文件中
	        System.out.println("***************************************************************");
	        System.out.println("                     欢迎乘坐石家庄地铁                     ");
	        System.out.println("***************************************************************");
	        System.out.println("                     1·显示具体线路信息                     ");
	        System.out.println("                     2·购票                     ");
	        System.out.println("***************************************************************");//打印菜单
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			int choose=sc.nextInt();
			if(choose==1) {
				c.bianli(a, b);
				d.bianli(a, b);
			}                                                                                    //实现遍历功能
			else {
				System.out.println("***************************************************************");
		        System.out.println("                     欢迎乘坐石家庄地铁                     ");
		        System.out.println("***************************************************************");
			    System.out.println("起始站：");
			    String s=sc1.nextLine();
			    System.out.println("终点站：");
			    String t=sc2.nextLine();
			    c.goupiao(a, b, s, t);                                                           //实现购票功能
			}
	}
	
}

abstract class subway{
	private int num;
	private String name;
	private String infor;
	public void bianli(String a[],String b[]) {
	}
	public void chaxun(String a[],String b[],String s,String t) {
		
	}
	public void goupiao(String a[],String b[],String s,String t) {
		
	}
}                                                                       //虚基类
class FirstLineSubway extends subway{
	public void bianli(String a[],String b[]) {
		int i=0;
		System.out.println("***************************************************************");
		System.out.print("一号线：");
		for(i=0;i<=19;i++) {
			System.out.print("站点"+(i+1)+":"+a[i]+"  ");
		}
		System.out.println();
	}                                                                  //输出一号线信息
	public void chaxun(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		for(int i=0;i<=5;i++)
		{
			if(t.equals(b[i])) {
				flag=false;
				break;
			}
		}
		for(c=0;c<20;c++) {
			if(s.equals(a[c])) {
				break;
			}
		}
		
		if(flag==true) {
			while(!a[c].equals(t)) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
		}
		else {
			while(!a[c].equals("新百广场")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c]);
			System.out.println("换乘三号线");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e]);
		}
		System.out.println("一共有"+zhanshu+"站");                           //通过循环来判断初始地点与目的地是否相等以及计算站数
	}
	public void goupiao(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		int jine=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("购票数量：");
		int d=sc.nextInt();
		for(int i=0;i<=5;i++)
		{
			if(t.equals(b[i])) {
				flag=false;
				break;
			}
		}
		for(c=0;c<20;c++) {
			if(s.equals(a[c])) {
				break;
			}
		}
		
		if(flag==true) {
			while(!t.equals(a[c])) {
				System.out.println(a[c]);
				System.out.println(c);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
		}
		else {
			while(!a[c].equals("新百广场")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
			System.out.println("换乘三号线");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e++]);
		}
		if(zhanshu%3==0){
			jine=zhanshu/3;
		}
		else jine=zhanshu/3+1;
		System.out.println("购票单价：");
		System.out.println(jine);
		jine=jine*d;
		System.out.println("购票金额：");
		System.out.println(jine);                                                    //通过计算出来的站数来计算钱数
	}

}
class ThirdLineSubway extends subway{
	public void bianli(String a[],String b[]) {
		System.out.print("二号线：");
		for(int i=0;i<=5;i++) 
			System.out.print("站点"+(i+1)+":"+b[i]+"  ");
		System.out.println();
	}
	public void chaxun(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		for(int i=0;i<=5;i++)
		{
			if(t.equals(b[i])) {
				flag=false;
				break;
			}
		}
		for(c=0;c<20;c++) {
			if(s.equals(a[c])) {
				break;
			}
		}
		
		if(flag==true) {
			while(!a[c].equals(t)) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
		}
		else {
			while(!a[c].equals("新百广场")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c]);
			System.out.println("换乘三号线");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e]);
		}
		System.out.println("一共有"+zhanshu+"站");
	}
	
	public void goupiao(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		int jine=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("购票数量：");
		int d=sc.nextInt();
		for(int i=0;i<=5;i++)
		{
			if(t.equals(b[i])) {
				flag=false;
				break;
			}
		}
		for(c=0;c<20;c++) {
			if(s.equals(a[c])) {
				break;
			}
		}
		
		if(flag==true) {
			while(!t.equals(a[c])) {
				System.out.println(a[c]);
				System.out.println(c);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
		}
		else {
			while(!a[c].equals("新百广场")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
			System.out.println("换乘三号线");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e++]);
		}
		if(zhanshu%3==0){
			jine=zhanshu/3;
		}
		else jine=zhanshu/3+1;
		System.out.println("购票单价：");
		System.out.println(jine);
		jine=jine*d;
		System.out.println("购票金额：");
		System.out.println(jine);
	}


	
}
