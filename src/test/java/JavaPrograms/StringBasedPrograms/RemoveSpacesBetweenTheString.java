package JavaPrograms.StringBasedPrograms;

public class RemoveSpacesBetweenTheString {

	public static void main(String[] args) {
		String str="I am a sdet engineer";
		str=str.replaceAll(" ", "");
		System.out.print(str);
	}
}