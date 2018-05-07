
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Command {
	public static int quenumber;
	public static int min;
	public static int max;
	public static int optnum;
	public static int isMulDiv=0;
	public static int isBracket=0;
    public static void main(String[] args) {
       
       int ifQuenum=0;
       int ifMaxmin=0;
       for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-n")) {
				ifQuenum = 1;
				try {
					quenumber = Integer.parseInt(args[i + 1]);
					if (quenumber <= 0 || quenumber > 10000) {
						System.out.println("n的取值不合法，请重新输入[1,10000]:");
						return;
					}
				} catch (Exception e) {
					System.out.println("n的格式不合法,请重新输入：");
				}
			}
			if (args[i].equals("-m")) {
				ifMaxmin = 1;
				try {
					min = Integer.parseInt(args[i + 1]);
					max = Integer.parseInt(args[i + 2]);
					if (min <= 0 || min > 100) {
						System.out.println("下限取值不合法，请重新输入[1,100]:");
						return;
					}
					if (max < 50 || max > 1000) {
						System.out.println("上限取值不合法，请重新输入[50,1000]:");
						return;
					}
				} catch (Exception e) {
					System.out.println("m的格式不合法,请重新输入:");
				}
			}
			if (args[i].equals("-o")) {
				try {
					optnum = Integer.parseInt(args[i + 1]);
					if (optnum <= 0 || optnum > 10) {
						System.out.println("o的取值不合法，请重新输入[1,10]:");
						return;
					}
				} catch (Exception e) {
					System.out.println("o的格式不合法,请重新输入:");
				}
			}
			
			if (args[i].equals("-b")) {
				isBracket = 1;// 括号
			}
			if (args[i].equals("-c")) {
				isMulDiv = 1;// 乘除
			}
		}
		if (ifQuenum == 0) {
			System.out.println("缺少题量参数n:");
			return;
		}
		if (ifMaxmin == 0) {
			System.out.println("缺少范围参数m:");
			return;
		}
		try {
			PrintStream ps = new PrintStream("../result.txt");// 生成文件
			System.setOut(ps);
		} catch (Exception e) {
			System.out.println("文件生成错误");// 提示
		}
		
       /*Scanner input=new Scanner(System.in);
       System.out.print("请输入题量：");
 	   int quenumber=input.nextInt();
 	   System.out.print("请输入范围：");
 	   int range=input.nextInt();
 	   System.out.print("请输入符号数量：");
 	   int optnum=input.nextInt();
 	   System.out.print("是否有乘除运算：");
 	   int isMulDiv=input.nextInt();
 	   System.out.print("是否带有括号：");
 	   int isBracket=input.nextInt();*/
 	   
       int range=max-min;
 	   if(isMulDiv==0&&isBracket==0)
          Simple(quenumber,range,optnum);
 	   
 	   if(isMulDiv==1&&isBracket==0)
 	      OnlyMD(quenumber,range,optnum);
 	   
 	   if(isMulDiv==0&&isBracket==1)
 		   OnlyBra(quenumber,range,optnum);
 	   
 	   if(isMulDiv==1&&isBracket==1)
 		   BothMDBra(quenumber,range,optnum);
       }

//Simple
public static void Simple(int n,int Range,int Optnum)
{
	int type;
    int sum=0;
    char[] opt={'+','-'};
    type=(int)(Math.random()*2);
    for(int i=0;i<n;i++)
    {
    int s1=(int)(Math.random()*Range);
    int s2=(int)(Math.random()*Range);
    String str1=null;
    if(opt[type]=='+')
    {
        sum=s1+s2;
    }
    if(opt[type]=='-')
    {
        sum=s1-s2;
    }   
    str1=s1+""+opt[type]+""+s2;
    
    for(int j=1;j<Optnum;j++)
    {
        int typ=(int)(Math.random()*2);;
        int s = (int)(Math.random()*Range);
        	if (opt[typ] == '+')
                sum = sum + s;
        	if (opt[typ] == '-')
        	{
                sum = sum - s;
        	}  
            str1 = str1 + "" + opt[typ] + "" +s;
    }
    if(sum>Range||sum<-Range)
    	i--;
    else
    //System.out.println(str1+"="+sum);
    System.out.println(str1);
    }
}
    
//OnlyMD
public static void OnlyMD(int n,int Range,int Optnum)
{
  char[] opt={'+','-','*','÷'};
  int[] nu=new int[15];
  int[] t=new int[15];
  String str1 = null;
  for(int i=0;i<n;i++)
  {
	 for(int j=1;j<=11;j++)
		 nu[j]=(int)(Math.random()*Range);
	 t[1]=(int)(Math.random()*2+2);t[2]=(int)(Math.random()*3);t[3]=(int)(Math.random()*3);
	 t[5]=(int)(Math.random()*3);t[6]=(int)(Math.random()*3);t[7]=(int)(Math.random()*3);
	 t[9]=(int)(Math.random()*3);t[10]=(int)(Math.random()*3);t[4]=3;t[8]=3;
	 if(t[1]==3)
	 {
		 while(nu[2]==0||nu[1]%nu[2]!=0)
			 nu[2]=(int)(Math.random()*Range+1);
	 }
	 nu[5]=(int)(Math.random()*Range+1);
	 nu[9]=(int)(Math.random()*Range+1);
	 
     switch(Optnum)
     {
     case 1:
        str1=nu[1]+""+opt[t[1]]+""+nu[2];
        break;
     case 2:
         str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3];
         break;
     case 3:
         str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4];
         break;
     case 4:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5];
         break;
     case 5:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6];
         break;
     case 6:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6]+""+opt[t[6]]+""+nu[7];
    	 break;
     case 7:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6]+""+opt[t[6]]+""+nu[7]+""+opt[t[7]]+
              ""+nu[8];
    	 break;
     case 8:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6]+""+opt[t[6]]+""+nu[7]+""+opt[t[7]]+
              ""+nu[8]+""+opt[t[8]]+""+nu[9];
    	 break;
     case 9:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6]+""+opt[t[6]]+""+nu[7]+""+opt[t[7]]+
              ""+nu[8]+""+opt[t[8]]+""+nu[9]+""+opt[t[9]]+""+nu[10];
    	 break;
     case 10:
    	 str1=nu[1]+""+opt[t[1]]+""+nu[2]+""+opt[t[2]]+""+nu[3]+""+opt[t[3]]+""+nu[4]+""+
              opt[t[4]]+""+nu[5]+""+opt[t[5]]+""+nu[6]+""+opt[t[6]]+""+nu[7]+""+opt[t[7]]+
              ""+nu[8]+""+opt[t[8]]+""+nu[9]+""+opt[t[9]]+""+nu[10]+""+opt[t[10]]+""+nu[11];
    	 break;
     }
  }
      //str1=str1+"=";
      /*System.out.print(str1);
      MyStack num = new MyStack();
      MyStackChar fuhao = new MyStackChar();
      String digit = "";
      for (int j = 0; j < str1.length(); j++)
      {
      char c = str1.charAt(j);
      if (Character.isDigit(c)) 
      {
          digit += c;
      } 
      else 
      {
          num.push(Integer.parseInt(digit));
          digit = "";
          if (c == '=')
          {
              int after = num.pop();
              int before = num.pop();
              char fu = fuhao.pop();
              int jieguo = yunsuan(after, fu, before);
              num.push(jieguo);
              if(fuhao.getIndex()==-1)
              {
                  System.out.println(num.getTop());
              }
              else
              {
                  int after1 = num.pop();
                  int before1 = num.pop();
                  char fu1 = fuhao.pop();
                  int jieguo1 = yunsuan(after1, fu1, before1);
                  System.out.println(jieguo1);
              }
          } 
          else 
          {
              if (fuhao.getIndex() == -1)
              {
                  fuhao.push(c);
              } 
              else 
              {
                  jisuan(num, fuhao, c);
              }
          }
      }
  }
     }*/
  }

public static void jisuan(MyStack num, MyStackChar fuhao, char c)
{
  if (fuhao.getIndex() == -1)
  {
      fuhao.push(c);
  } 
  else
  {
      char top = fuhao.getTop();
      if (youXianji(c, top))
      {
          fuhao.push(c);
      } 
      else
      {
          int after = num.pop();
          int before = num.pop();
          char fu = (char) fuhao.pop();
          int jieguo = yunsuan(after, fu, before);
          num.push(jieguo);
          jisuan(num, fuhao, c);
      }
  }
}

public static int yunsuan(int after, char top, int before) 
{
  int result = 0;
  switch (top) 
  {
  case '+':
      result = before + after;
      break;
  case '-':
      result = before - after;
      break;
  case '*':
      result = before *after;
      break;
  case '÷':
      result = before / after;
      break;
  }
  return result;
}

public static boolean youXianji(char c, char top)
{
  if (top == '*' || top == '÷')
  {
      return false;
  } 
  else if (c == '*' || c == '÷')
  {
      return true;
  } 
  else 
  {
      return false;
  }
}
    
    

//OnlyBra
public static void OnlyBra(int n,int Range,int Optnum)
{
    int type;
    int sum=0;
    char[] opt={'+','-'};
    type=(int)(Math.random()*2);
    for(int i=0;i<n;i++)
    {
    int s1=(int)(Math.random()*Range);
    int s2=(int)(Math.random()*Range);
    String str1=null;
    if(opt[type]=='+')
    {
        sum=s1+s2;
    }
    if(opt[type]=='-')
    {
        sum=s1-s2;
    }                                 
        str1=s1+""+opt[type]+""+s2;
    
    for(int j=1;j<Optnum;j++)
    {
        int typ=(int)(Math.random()*2);;
        int s = (int)(Math.random()*Range);
        if (sum%10!=0||sum%5!=0)
        {
        	if (opt[typ] == '+')
                sum = sum + s;
        	if (opt[typ] == '-')
        	{
                sum = sum - s;
        	}
                str1 = str1 + "" + opt[typ] + "" +s;
         } 
        else 
        {
               str1 = "(" + str1 + ")" + "" + opt[typ] + "" + s;
        }
    }
    if(sum>Range||sum<-Range)i--;
    else
    //System.out.println(str1+"="+sum);
    System.out.println(str1);
    }
}

//BothMDBra
public static void BothMDBra(int n,int Range,int Optnum)   	
{    	  
        int type;
        int sum=0;
        char[] opt={'+','-','*','÷'};
        type=(int)(Math.random()*4);
        for(int i=0;i<n;i++)
        {
        int s1=(int)(Math.random()*Range);
        int s2=(int)(Math.random()*Range);
        String str1=null;
        if(opt[type]=='+')
        {
            sum=s1+s2;
        }
        if(opt[type]=='-')
        {
            sum=s1-s2;
        }                                 
            
        if(opt[type]=='*')
        {
            sum=s1*s2;
        }
        if(opt[type]=='÷')//如果是除法
        {
            while(s2==0||s1%s2!=0)//不能整除或除数为0，重新生成除数
            s2=(int)(Math.random()*Range+1);
            sum=s1/s2;//保证除数合法
            } 
            str1=s1+""+opt[type]+""+s2;
        
        for(int j=1;j<Optnum;j++)
        {
            int typ=(int)(Math.random()*4);;
            int s = (int)(Math.random()*Range);
            if (youxianji(opt[type]) >= youxianji(opt[typ]))
            {
            	if (opt[typ] == '+')
                    sum = sum + s;
            	if (opt[typ] == '-')
            	{
                    sum = sum - s;
            	}
            	if (opt[typ] == '*')
                    sum = sum * s;
            	if (opt[typ] == '÷') 
            	{
               	     while (s==0||sum % s != 0)
                     s =(int)(Math.random()*Range+1);
                     sum = sum /s;
                }
                    str1 = str1 + "" + opt[typ] + "" +s;
             } 
            else 
            {
            	if (opt[typ] == '*')
                    sum = sum *s;
            	if (opt[typ] == '÷')
            	{
                    while (s==0||sum % s != 0)
                    s =(int)(Math.random()*Range+1);
                    sum = sum /s;
                }
                   str1 = "(" + str1 + ")" + "" + opt[typ] + "" + s;
            }
        }
        if(sum>Range||sum<-Range)i--;
        else
        //System.out.println(str1+"="+sum);
        System.out.println(str1);
        }
}

//判断优先级
public static int youxianji(char c)
{
     if (c == '*' || c == '÷')
         return 3;
     if (c == '+' || c == '-')
         return 2;
     if (c == '(')
         return 1;
     return 0;
   }  
}
