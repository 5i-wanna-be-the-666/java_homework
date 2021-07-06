package java_homework_2_3;

@SuppressWarnings("serial")
public  class TranslationRobot extends AbstractRobot{

	TranslationRobot()
	{
		super();
	}
	TranslationRobot(String name,float a,int b,float c)
	{
		super(name,a,b,c);
	}
	
	void greet() //实现的greet函数
	{
		this.talk("Welcome to TranslationRobot");
		
	}
	String zhong(String substitute)
	{
		return substitute;
	}
	@SuppressWarnings("unused")
	void translate(String substitute)//翻译
	{
		String phrase=zhong(substitute);
		this.talk(substitute);
	}

	void charge(float amount) //双倍充电
	{
		this.powerLevel+=2*amount;
	}
	
}
