package java_homework_2_3;



import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Interface_crudRobot extends Robot{
	
	void inser(List<AbstractRobot> A,AbstractRobot []t)//添加
	{
		int i=0;
		for(i=0;i<t.length;i++)
		{
			A.add(t[i]);
			 System.out.println("添加成功");
		}
		if(i==0)
		{
			System.out.println("数组为空，添加失败");
		}
	}
	int find(List<AbstractRobot> A,AbstractRobot t)//查找
	{
		int i=0;
		for (AbstractRobot str : A)
		 {
			 if(str.equals(t))
			 {
				 System.out.println("查找成功，返回位置");
				return i;
			 }
			 i++;
		 }
		System.out.println("查找失败，该机器人不存在");
		return -1;
		
	}
	
	void display(List<AbstractRobot> A)//显示
	{
		
		for (AbstractRobot str : A)
		 {
			 System.out.println(str.toString());
		 }
	}
	
	 @SuppressWarnings("unused")
	void delete(List<AbstractRobot> A,AbstractRobot t)//删除
	{
		 int i=0;
		 int flag=0;
		 Iterator<AbstractRobot> it_b=A.iterator();
		 
			 while(it_b.hasNext()){
		            AbstractRobot a=it_b.next();
		            if (a.equals(t)) {
		                it_b.remove();
		                flag=1;
		            }
		        }
		 
		
		 
		 if(flag==0)
		 {
			 System.out.println("删除失败，不存在这个机器人");
		 }
		 
		 if(flag==1)
		 {
			 System.out.println("删除成功");
		 }
	}
	 
	void update(List<AbstractRobot> A, AbstractRobot t,AbstractRobot n)//更新
	{
		int i=0;
		int flag=0;
		 for (AbstractRobot str : A)
		 {
			 if(str.equals(t))
			 {
				 A.set(i,n);
				 flag=1;
			 }
			 i++;
		 }
		 
		 if(flag==0)
		 {
			 System.out.println("更新失败，不存在这个机器人");
		 }
		 
		 if(flag==1)
		 {
			 System.out.println("更新成功");
		 }
	}
}
