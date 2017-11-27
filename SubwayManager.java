//��1605-3 20163677 ���ļ�

import java.util.Scanner;
import java.io.*;

public class SubwayManager {
	public static void main(String[] args) throws IOException{
		 FileWriter fw = null;
		 FirstLineSubway c=new FirstLineSubway();
		 ThirdLineSubway d=new ThirdLineSubway();
		 String a[]= {"���Ӵ��","�ϴ�","ʯ��ׯ��վ","���㳡","����","�׷�","������","̸��","����","������","�����","�����̳�","ƽ�����","��Ź㳡","�°ٹ㳡","��ʿ��԰","��ƽҽԺ","������","ʱ���","����"};
		 String b[]={"�ж���","�°ٹ㳡","����","������","������","ʯ��ׯվ"};
	        try {
	                                                              //�����ַ������
	            fw = new FileWriter("shijiazhuang-subway.txt");
	            fw.write("һ����\r\n");
	            for(int i=0;i<20;i++) {
	            	fw.write(a[i]+"\r\n");
	            }
	            fw.write("������\r\n");
	            for(int i=0;i<6;i++) {
	            	fw.write(b[i]+"\r\n");
	            }
	   
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally {
	                                                               //ʹ��finally�����ر��ļ������
	            if (fw != null) {
	              fw.close();
	            }       
	        }                                                      //������·�������Ϣ�����ļ���
	        System.out.println("***************************************************************");
	        System.out.println("                     ��ӭ����ʯ��ׯ����                     ");
	        System.out.println("***************************************************************");
	        System.out.println("                     1����ʾ������·��Ϣ                     ");
	        System.out.println("                     2����Ʊ                     ");
	        System.out.println("***************************************************************");//��ӡ�˵�
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			int choose=sc.nextInt();
			if(choose==1) {
				c.bianli(a, b);
				d.bianli(a, b);
			}                                                                                    //ʵ�ֱ�������
			else {
				System.out.println("***************************************************************");
		        System.out.println("                     ��ӭ����ʯ��ׯ����                     ");
		        System.out.println("***************************************************************");
			    System.out.println("��ʼվ��");
			    String s=sc1.nextLine();
			    System.out.println("�յ�վ��");
			    String t=sc2.nextLine();
			    c.goupiao(a, b, s, t);                                                           //ʵ�ֹ�Ʊ����
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
}                                                                       //�����
class FirstLineSubway extends subway{
	public void bianli(String a[],String b[]) {
		int i=0;
		System.out.println("***************************************************************");
		System.out.print("һ���ߣ�");
		for(i=0;i<=19;i++) {
			System.out.print("վ��"+(i+1)+":"+a[i]+"  ");
		}
		System.out.println();
	}                                                                  //���һ������Ϣ
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
			while(!a[c].equals("�°ٹ㳡")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c]);
			System.out.println("����������");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e]);
		}
		System.out.println("һ����"+zhanshu+"վ");                           //ͨ��ѭ�����жϳ�ʼ�ص���Ŀ�ĵ��Ƿ�����Լ�����վ��
	}
	public void goupiao(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		int jine=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("��Ʊ������");
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
			while(!a[c].equals("�°ٹ㳡")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
			System.out.println("����������");
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
		System.out.println("��Ʊ���ۣ�");
		System.out.println(jine);
		jine=jine*d;
		System.out.println("��Ʊ��");
		System.out.println(jine);                                                    //ͨ�����������վ��������Ǯ��
	}

}
class ThirdLineSubway extends subway{
	public void bianli(String a[],String b[]) {
		System.out.print("�����ߣ�");
		for(int i=0;i<=5;i++) 
			System.out.print("վ��"+(i+1)+":"+b[i]+"  ");
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
			while(!a[c].equals("�°ٹ㳡")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c]);
			System.out.println("����������");
			while(!b[e].equals(t)) {
				System.out.println(b[e]);
				e++;
				zhanshu++;
			}
			System.out.println(b[e]);
		}
		System.out.println("һ����"+zhanshu+"վ");
	}
	
	public void goupiao(String a[],String b[],String s,String t) {
		boolean flag=true;
		int zhanshu=0;
		int e=2;
		int c=0;
		int jine=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("��Ʊ������");
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
			while(!a[c].equals("�°ٹ㳡")) {
				System.out.println(a[c]);
				c++;
				zhanshu++;
			}
			System.out.println(a[c++]);
			System.out.println("����������");
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
		System.out.println("��Ʊ���ۣ�");
		System.out.println(jine);
		jine=jine*d;
		System.out.println("��Ʊ��");
		System.out.println(jine);
	}


	
}
