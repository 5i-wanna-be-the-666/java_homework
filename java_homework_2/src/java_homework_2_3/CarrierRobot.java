package java_homework_2_3;

@SuppressWarnings("serial")
public class CarrierRobot extends AbstractRobot {

	CarrierRobot()
	{
		super();
	}
	
	CarrierRobot(String name,float a,int b,float c)
	{
		super(name,a,b,c);
	}
	void greet() //实现的greet函数
	{
		
		this.talk("Welcom to CarrierRobot");
		
	}
	
	void carry(float capacity)//实现的carry函数
	{
		if(capacity>this.weight)
		{
			System.out.println("负重过重，机器人承受不了");
		}
	}
    
}
