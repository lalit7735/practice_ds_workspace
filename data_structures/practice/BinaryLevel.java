import java.util.ArrayList;
import java.util.Scanner;


public class BinaryLevel {

	public static void main(String[] args) {
		int personCounter=0;
		Scanner sc=new  Scanner(System.in);
		System.out.println("Enter number of person to register");
		personCounter = sc.nextInt();
		ArrayList<User> userBinaryTree=new ArrayList<User>();
		User rootUser=new User();
		rootUser.setSponserId(1000);
		rootUser.setUserId(1000);
		userBinaryTree.add(rootUser);
		int sidIndex=0;
		int regCounter=0;
		for(int i=1;i<=personCounter;i++){
			User user=new User();
			user.setUserId(1000+i);
			user.setSponserId(userBinaryTree.get(sidIndex).getUserId());
			userBinaryTree.add(user);
			regCounter++;
			System.out.println(" new user registerd under sponser :"+userBinaryTree.get(sidIndex).getUserId()+" with user id:"+user.getUserId());
			if(regCounter==2){
				System.out.println(" user added to right of "+userBinaryTree.get(sidIndex).getUserId());
				regCounter=0;
				++sidIndex;
			}else{
				System.out.println(" user added to left of "+userBinaryTree.get(sidIndex).getUserId());
			}
		}
	}
}
