

import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ImmutableValueGraph.Builder;
import com.google.common.graph.ValueGraphBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import java.util.stream.Collectors;
public class Search {


	/**
	 * Lists all nodes values in a given graph.
	 *
	 * @param graph the graph to query the nodes from
	 * @return lists of all the nodes in the given graph
	 */

	static Collection<Integer> listAllNodes(ImmutableValueGraph<Integer, Integer> graph) 
	{
		
	
		Collection<Integer> list = new HashSet<>();//建立为集合
		
		Object[] a =null;//用来实现graph的toarray方法的
		a=new Object[graph.nodes().size()];
		graph.nodes().toArray(a);
		int i=0;
		while(i<a.length)//向列表中添加顶点
		{
			list.add((int)a[i]);
			i++;
		}
		return list;
	}

	/**
	 * Lists all edge values in a given graph.
	 *
	 * @param graph the graph to query the edges from
	 * @return lists of all the edges in the given graph
	 */
	static Collection<Integer> listAllEdges(ImmutableValueGraph<Integer, Integer> graph) 
	{
		Object[] a =null;//用来实现graph的toarray方法的
		a=new Object[graph.nodes().size()];
		graph.nodes().toArray(a);
		Collection<Integer> list = new ArrayList<>();
		int i=0,j=0;
		int nodeU=0,nodeV=0;//确定要添加的边
		while(i<a.length)//使用双循环来避免遗漏边
		{
			nodeU=(int)a[i];
			
			j=i+1;
			
			while(j<a.length)
			{
				nodeV=(int)a[j];
			    if(graph.edgeValueOrDefault(nodeU, nodeV, -1)!=-1)
			    {
			    	list.add(graph.edgeValueOrDefault(nodeU,nodeV, -1));
			    }
			    j++;
			}
		
			i++;
		}
		
	
		return list;

	}

	/**
	 * Lists all nodes with 4 or more edges
	 *
	 * @param graph the graph to query the edges from
	 * @return lists of all nodes that satisfy the condition
	 */
	static Collection<Integer> 
	findAllNodeWith4OrMoreEdges(ImmutableValueGraph<Integer, Integer> graph) 
	{
		
		
		Object[] a =null;//用来实现graph的toarray方法的
		a=new Object[graph.nodes().size()];
		graph.nodes().toArray(a);
		Collection<Integer> list = new ArrayList<>();
		int i=0,j=0,sum=0;
		int nodeU=0,nodeV=0;//确定要添加的边
		while(i<a.length)//使用双循环来避免遗漏边
		{
			nodeU=(int)a[i];
			
			j=0;
			sum=0;
			while(j<a.length)
			{
				nodeV=(int)a[j];
			    if(graph.edgeValueOrDefault(nodeU, nodeV, -1)!=-1)
			    {
			    	sum++;
			    }
			    j++;
			}
		
			if(sum>=4)
				list.add(nodeU);
		
			i++;
		}
		
	
		return list;
				
		
	}

	/**
	 * Lists all nodes with edges values that when summed, is > 20
	 * For example, a node with three connected edges: 1, 2, 3 has an edge sum of 6.
	 *
	 * @param graph the graph to query the edges from
	 * @return lists of all nodes that satisfy the condition
	 */
	static Collection<Integer> findAllNodesWithEdgeSumGreaterThan20
	(ImmutableValueGraph<Integer, Integer> graph) 
	{
		Object[] a =null;//用来实现graph的toarray方法的
		a=new Object[graph.nodes().size()];
		graph.nodes().toArray(a);
		Collection<Integer> list = new ArrayList<>();
		int i=0,j=0,sum=0;
		int nodeU=0,nodeV=0;//确定要添加的边
		while(i<a.length)//使用双循环来避免遗漏边
		{
			nodeU=(int)a[i];
			
			j=0;
			sum=0;
			while(j<a.length)
			{
				nodeV=(int)a[j];
			    if(graph.edgeValueOrDefault(nodeU, nodeV, -1)!=-1)
			    {
			    	sum+=graph.edgeValueOrDefault(nodeU, nodeV, -1);
			    }
			    j++;
			}
		
			if(sum>20)
				list.add(nodeU);
		
			i++;
		}
		
	
		return list;
	}


	/**
	 * Finds the shortest possible path that travels from the source to destination, factoring the
	 * edge distances.
	 * A path that allows you to travel from the source to the destination with the minimum total
	 * edge distances is the shortest path.
	 *
	 * @param graph the graph to compute the shortest path with
	 * @param source the starting position of the search, the resulting list should end with this
	 * value
	 * @param destination the end position of the search, the resulting list should end with this
	 * value
	 * @return a list of nodes that represent the shortest path from source to destination
	 */
	static List<Integer> shortestPathFromSourceToDestination(
			ImmutableValueGraph<Integer, Integer> graph,
			Integer source,
			Integer destination) 
	{
		
		Collection<Integer> list = new ArrayList<>();
		
		
		Object[] a =null;//用来实现graph的toarray方法的
		a=new Object[graph.nodes().size()];
		graph.nodes().toArray(a);
		
		
		
		int len=a.length;
		
		if(source>(int)a[len-1] || source<(int)a[0]|| destination>(int)a[len-1]||destination<(int)a[0])
		{
			System.out.println("输入的起点或终点不在图中，无法到达");
			return (List<Integer>) list;
		}
		int []qi=new int[len+2];//用来标志距离短点的集合
		int []jie=new int[len+2];//用来储存其他顶点的集合
		int []remind=new int[len+2];//记录路径的数组
		
		int i=0;
		
		for(i=0;i<a.length;i++)
		{
			jie[(int)a[i]]=graph.edgeValueOrDefault(source, (int)a[i], 65535);
			if(jie[(int)a[i]]!=65535)
				jie[(int)a[i]]++;//方便后面将起点插入在remind数组中
			
			qi[(int)a[i]]=65535;
			
			
		}
		for(i=0;i<a.length;i++)
		{
			remind[(int)a[i]]=graph.edgeValueOrDefault(source, (int)a[i], 65535);
		}
		
		qi[source]=0;
		jie[source]=-1;
	
		
		int min=0;
		int min_wei=source;//第一次把起点加入qi中
		int turn=0;
		
		int flag=1;
		while(flag==1)
		{
			
			for(i=0;i<a.length;i++)//第一次的时候先处理起点和他所连接点的
			{
				if(jie[(int)a[i]]==-1)
					continue;
				
					turn=graph.edgeValueOrDefault(min_wei,(int)a[i],65535);
					
					if(turn+min<jie[(int)a[i]])
					{
						remind[(int)a[i]]=min_wei;//记录是从哪个节点过来的
						
						jie[(int)a[i]]=turn+min;//关系sourc到点(int)a[i]的最小距离
						
					   
					}
				
			}
			
			min=65536;
			flag=0;
			for(i=0;i<a.length;i++)
			{
				if(min>jie[(int)a[i]]&&jie[(int)a[i]]!=-1)
				{
					min=jie[(int)a[i]];
					min_wei=(int)a[i];
					flag=1;
				}
			}
			if(flag==0)
				break;
			
			jie[min_wei]=-1;
			qi[min_wei]=min;//将jie数组中的最小值添加到qi中
			turn=0;
			
			
			
			
			
		}
		
		
		for(i=1;i<=len;i++)
		{
			if(i==destination)//找到终点的位置
				break;
		}
		
		
		
		
		int ji_lu=0;
		
		while(i!=source)
		{
			list.add(i);
			
			
			for(ji_lu=1;ji_lu<=len;ji_lu++)
			{
				if(ji_lu==remind[i])
					break;
			}
			if(ji_lu==len&&ji_lu!=remind[i])
			{
				System.out.println("无法到达");
				return (List<Integer>) list;
			}
			
			i=ji_lu;
			
		}
		list.add(i);//添加起点
		
			System.out.println("路程距离:"+" "+qi[(int)a[destination-1]]);
			
		
		Collections.reverse((List<?>) list);//由于是倒着的，所以用之前的那个方法把它倒回来
		return (List<Integer>) list;
		
	}

	// reads in a graph stored in plan text, not part of any question but feel free to study at how
	// a graph is constructed
	static ImmutableValueGraph<Integer, Integer> readGraph(String content) {
		List<String> lines = content.lines().collect(Collectors.toList());
		if (lines.isEmpty()) throw new IllegalArgumentException("No lines");
		int currentLine = 0;

		String[] topLine = lines.get(currentLine++).split(" ");
		int numberOfNodes = Integer.parseInt(topLine[0]);
		int numberOfEdges = Integer.parseInt(topLine[1]);

		Builder<Integer, Integer> builder = ValueGraphBuilder
				.undirected()
				.expectedNodeCount(numberOfNodes)
				.immutable();


		for (int i = 0; i < numberOfNodes; i++) {
			String line = lines.get(currentLine++);
			if (line.isEmpty()) continue;
			builder.addNode(Integer.parseInt(line));
		}

		for (int i = 0; i < numberOfEdges; i++) {
			String line = lines.get(currentLine++);
			if (line.isEmpty()) continue;

			String[] s = line.split(" ");
			if (s.length != 3) throw new IllegalArgumentException("Bad edge line:" + line);
			builder.putEdgeValue(Integer.parseInt(s[0]),
					Integer.parseInt(s[1]),
					Integer.parseInt(s[2]));
		}
		return builder.build();
	}


}
