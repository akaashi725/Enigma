import java.util.Arrays;
import java.util.Scanner;

public class Enigmacode {

	public static String[] decideRing(int index){
		//링 조합 순서가 들어간 배열의 각 값을 입력받아 해당하는 문자열 링 반환하는 메서드
		String[] ring1 = {"ㅊ","ㄴ","ㅌ","ㅈ","ㄷ","ㅍ","ㅎ","ㄹ","ㄱ","ㅇ","ㅕ","ㅠ","ㅏ","ㅑ","ㅜ","ㅡ","ㅁ","ㅅ","ㅣ","ㅂ","ㅓ","ㅗ","ㅛ","ㅋ"};
		String[] ring2 = {"ㅑ","ㄴ","ㅁ","ㅏ","ㅎ","ㅈ","ㅌ","ㄱ","ㅓ","ㅇ","ㅕ","ㅛ","ㄹ","ㅣ","ㅅ","ㄷ","ㅊ","ㅗ","ㅜ","ㅂ","ㅋ","ㅡ","ㅍ","ㅠ"};
		String[] ring3 = {"ㅎ","ㅏ","ㄹ","ㅁ","ㅑ","ㅛ","ㅊ","ㅜ","ㅂ","ㅓ","ㄷ","ㅡ","ㅠ","ㄴ","ㅗ","ㅅ","ㅍ","ㅣ","ㅈ","ㄱ","ㅇ","ㅌ","ㅋ","ㅕ"};
		String[] ring4 = {"ㅓ","ㅅ","ㅂ","ㅜ","ㅇ","ㅁ","ㅑ","ㅗ","ㅈ","ㄹ","ㅕ","ㅊ","ㅏ","ㄷ","ㅎ","ㅋ","ㅠ","ㄴ","ㅣ","ㅌ","ㅡ","ㅛ","ㄱ","ㅍ"};
		String[] ring5 = {"ㅛ","ㄴ","ㅎ","ㅗ","ㅊ","ㄱ","ㅅ","ㅂ","ㅕ","ㅓ","ㅍ","ㅣ","ㄷ","ㅑ","ㅁ","ㅇ","ㅜ","ㅌ","ㅈ","ㅋ","ㅠ","ㅏ","ㄹ","ㅡ"};
		String[] ring6 = {"ㅅ","ㅌ","ㅗ","ㄴ","ㅍ","ㄷ","ㅕ","ㄱ","ㅎ","ㅇ","ㅏ","ㅛ","ㄹ","ㅠ","ㅋ","ㅑ","ㅁ","ㅈ","ㅜ","ㅂ","ㅓ","ㅡ","ㅣ","ㅊ"};
		String[] ring7 = {"ㅈ","ㅁ","ㅗ","ㄹ","ㅏ","ㅎ","ㅛ","ㅇ","ㅣ","ㅍ","ㅅ","ㄷ","ㅑ","ㅂ","ㄴ","ㅕ","ㅋ","ㅓ","ㅊ","ㅜ","ㅌ","ㅡ","ㅠ","ㄱ"};
		switch(index)
		{
		case 1:
			return(ring1);
		case 2:
			return(ring2);
		case 3:
			return(ring3);
		case 4:
			return(ring4);
		case 5:
			return(ring5);
		case 6:
			return(ring6);
		default:
			return(ring7); //어차피 7 이외의 값은 이 메서드에 진입X, 메서드 에러 안나게 default로 처리
		}
	}

	public static int koreanToNum(String n) { //한글을 입력받으면 인덱스 번호 반환
		String[] standardRing = {"ㄱ","ㄴ","ㄷ","ㄹ","ㅁ","ㅂ","ㅅ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㅏ","ㅑ","ㅓ","ㅕ","ㅗ","ㅛ","ㅜ","ㅠ","ㅡ","ㅣ"};
		for (int i=0;i<24;i++)
		{
			if (n.contentEquals(standardRing[i]))
				return i;
		}
		System.out.println(n);
		return -1; //반환되면 에러나는 값 반환 - 원래 for문 나오기 전에 리턴 완료되어야 함
	}
	
	public static String numToKorean (int n)
	{
		//인덱스를 입력받으면 해당하는 한글 반환
		String[] standardRing = {"ㄱ","ㄴ","ㄷ","ㄹ","ㅁ","ㅂ","ㅅ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㅏ","ㅑ","ㅓ","ㅕ","ㅗ","ㅛ","ㅜ","ㅠ","ㅡ","ㅣ"};
		
		return standardRing[n];
	}
	
	public static int reverseAddress (String[] ring, String n) {//한글을 입력받으면 링에 따라 그 인덱스 반환
		for (int i = 0; i<ring.length;i++)
		{
			if (n.contentEquals(ring[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("안녕하세요, 한글판 에니그마입니다.");
		boolean keepgoing = true;
		
		while(keepgoing) {
			System.out.println("\n실행하실 작업을 선택해주세요.\n1. Encryption\n2. Decryption\n3. Quit"); //수행할 작업 선택
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("오늘은 링을 몇 개 사용하나요?");
				int ringnum = sc.nextInt(); //사용할 링의 개수 입력 및 저장
				System.out.print("오늘 사용할 링 번호를 입력해주세요: ");
				int[] ringaddress = new int[ringnum];
				for (int i = 0; i<ringnum;i++)
				{
					ringaddress[i]=sc.nextInt(); //당일의 링 순서를 배열로 저장함 (인덱스 순서대로 사용)
				}
				System.out.println("암호화할 글자를 단모음 및 자음으로 분해해 작성해주세요.");
				String blank = sc.nextLine();
				String plainText = sc.nextLine();
				String[] encryptedText = new String[plainText.length()];
				int howmanyen = 0; //암호화한 문자 수에 따라 링 회전하기 위한 변수
				int secondtolast = 0; //마지막에서 두번째 링을 회전하기 위한 변수
				
				for (int i = 0; i < plainText.length(); i++)
				{
					String letter = plainText.substring(i,i+1); //글자 하나씩 처리
					for (int j = 0; j<ringnum;j++) //글자 하나 당 링 모두 돌기
					{
						int inputletter = koreanToNum(letter);
						if (inputletter == -1)
						{
							System.out.println("사용할 수 있는 글자만 사용해주세요! ([ex] 이중모음은 단모음으로 분해, 문장 부호 및 띄어쓰기 무시)");
						}
						String[] thisring = Arrays.copyOf(decideRing(ringaddress[j]), 24); //이번에 사용할 링의 문자열 배열 복사해오기
						if (secondtolast == 0) {//마지막에서 두번째 링 회전할지 결정하는 if문
							if (j<ringnum-1)
							{
								letter = thisring[inputletter];
							}
							else {
								letter = thisring[(inputletter+howmanyen)%24];
							}
						}
						else {
							if (j<ringnum-2) {
								letter = thisring[inputletter];
							}
							else if (j==ringnum-2)
							{
								letter = thisring[(inputletter+secondtolast)%24];
							}
							else {
								letter = thisring[(inputletter+howmanyen)%24];
							}
						}
					}
					encryptedText[i]=letter;
					howmanyen++;
					
					if(howmanyen%24==0 && howmanyen/24>0) {//만약 마지막 링의 회전 수가 24의 배수라면 마지막에서 두번째 링 이동 칸 수 ++
						secondtolast++;
					}
					
				}
				
				for (int i = 0; i<plainText.length(); i++)
				{
					System.out.print(encryptedText[i]);
				}
			
			
			}//if 문 끝
			else if (choice==2){
				System.out.println("오늘은 링을 몇 개 사용하나요?");
				int ringnum = sc.nextInt(); //사용할 링의 개수 입력 및 저장
				System.out.print("오늘 사용할 링 번호를 입력해주세요: ");
				int[] ringaddress = new int[ringnum];
				for (int i = 0; i<ringnum;i++)
				{
					ringaddress[i]=sc.nextInt(); //당일의 링 순서를 배열로 저장함 (인덱스 순서대로 사용)
				}
				System.out.println("복호화할 글자를 작성해주세요.");
				String blank = sc.nextLine();
				String encryptedText = sc.nextLine();
				String[] decryptedText = new String[encryptedText.length()];
				int howmanyde = 0;
				int secondring = 0;
				
				for (int i = 0; i<encryptedText.length();i++)
				{
					String letter = encryptedText.substring(i,i+1);
					
					for (int j = 0;j<ringnum;j++)
					{
						String[] thisring = Arrays.copyOf(decideRing(ringaddress[(ringnum-1-j)]), 24);
						int reverse = reverseAddress(thisring, letter);
						if(j==0) {
							if (secondring == 0 || j!=encryptedText.length()-2) {
								String outputletter = numToKorean((reverse-howmanyde+24)%24);
								letter = outputletter;
							}
							else {
								String outputletter = numToKorean((reverse-secondring-1+24)%24); //계속 24를 더하는 이유는 음수가 나와 indexoutofrange 에러를 피하기 위해서..
								letter = outputletter;
							}
						}
						else {
							String outputletter = numToKorean((reverse+24)%24);
							letter = outputletter;
						}
					}
					
					decryptedText[i]=letter;
					howmanyde++;
					
				}
				
				for (int i = 0; i<encryptedText.length(); i++)
				{
					System.out.print(decryptedText[i]);
				}
				
			}//else if 문 끝
			else if(choice==3){
				keepgoing = false;
			}
			else {
				System.out.println("주어진 옵션 (1,2,3) 중 실행할 작업을 선택해 주세요.");
			}
		}
		
		sc.close();
	}

}
