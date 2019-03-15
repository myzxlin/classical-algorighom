package Others;
import java.io.*;
import java.util.*;

/**
 * CommonStr 求两个字符串的最长公共子串(不包括空格)，字符串长度<=255
 **/
public class CommonStr {
			
	public static void main(String[] args) {
		CommonStr c = new CommonStr();
		String s1 = "my name is lucia.";
		String s2 = "you are my cute dog";
		System.out.print(c.find(s1,s2));
	}
	
	public String find(String str1, String str2) {
		int max = 0;
		String ans = "";
		String[] s1 = str1.split(" ");
		String[] s2 = str2.split(" ");  
		for(int i=0; i<s1.length; i++)
			for(int j=0; j<s2.length; j++)
				if(s1[i].equals(s2[j]) && s1[i].length()>max) {
					ans = s1[i];
					max = s1[i].length();
				}
		return ans;
	}

}
