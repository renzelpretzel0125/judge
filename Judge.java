import java.util.Arrays;

public class Judge{

	public int findJudge(int N, int[][]trust){//N is the number of people in town, while trust is the double array of trust between individuals

		int[]trusting = new int[N+1];//person who is trusting
		int[]trusted = new int[N+1];//person who is trusted

		for(int i = 0; i<trust.length; i++){
			
			int a = trust[i][0];//the person trusting decrements
			trusting[a]--;
			int b = trust[i][1];//person being trusted increments
			trusted[b]++;

		}
		int numJudges = 0;//number of judges
		int judgeInd = -1;//will return the judge index unless there is no judges
		for(int j = 1; j < N+1 ;j++){
			if(trusted[j]==N-1 && trusting[j]==0){//if j person is trusted by everyone in town besides theirself and trust no one, j is judge
				judgeInd = j;
				numJudges++;//increments the number of judges by one
			}
			if(numJudges > 1 || N > 1000 || 1>N){//if town has more than one judge or there are more than 1000 or less than 1 people then return -1 as there can't be more than one judge
				return -1;
			}
		}
		return judgeInd;
	}

	public static void main(String[]args){
		Judge j = new Judge();

		int[][]ex1={{1,2}};
		int[][]ex2={{1,3},{2,3}};
		int[][]ex3={{1,3},{2,3},{3,1}};
		int[][]ex4={{1,2},{2,3}};
		int[][]ex5={{1,3},{1,4},{2,3},{2,4},{4,3}};

		System.out.println(j.findJudge(2,ex1));
		System.out.println(j.findJudge(3,ex2));
		System.out.println(j.findJudge(3,ex3));
		System.out.println(j.findJudge(3,ex4));
		System.out.println(j.findJudge(4,ex5));
	}
}