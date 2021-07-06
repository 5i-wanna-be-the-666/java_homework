package java_homework_2_3;

@SuppressWarnings("serial")
public abstract class AbstractRobot extends Robot {
	public AbstractRobot()
	{
		super();
	}
	
	public AbstractRobot(String name,float a,int b,float c)
	{
		super(name,a,b,c);
	}
	

	

	abstract void greet();
   
}
