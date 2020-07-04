import java.util.Arrays;
import java.util.Scanner;

public class Enigmacode {

	public static String[] decideRing(int index){
		//�� ���� ������ �� �迭�� �� ���� �Է¹޾� �ش��ϴ� ���ڿ� �� ��ȯ�ϴ� �޼���
		String[] ring1 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring2 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring3 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring4 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring5 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring6 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String[] ring7 = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
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
			return(ring7); //������ 7 �̿��� ���� �� �޼��忡 ����X, �޼��� ���� �ȳ��� default�� ó��
		}
	}

	public static int koreanToNum(String n) { //�ѱ��� �Է¹����� �ε��� ��ȣ ��ȯ
		String[] standardRing = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		for (int i=0;i<24;i++)
		{
			if (n.contentEquals(standardRing[i]))
				return i;
		}
		System.out.println(n);
		return -1; //��ȯ�Ǹ� �������� �� ��ȯ - ���� for�� ������ ���� ���� �Ϸ�Ǿ�� ��
	}
	
	public static String numToKorean (int n)
	{
		//�ε����� �Է¹����� �ش��ϴ� �ѱ� ��ȯ
		String[] standardRing = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		
		return standardRing[n];
	}
	
	public static int reverseAddress (String[] ring, String n) {//�ѱ��� �Է¹����� ���� ���� �� �ε��� ��ȯ
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
		System.out.println("�ȳ��ϼ���, �ѱ��� ���ϱ׸��Դϴ�.");
		boolean keepgoing = true;
		
		while(keepgoing) {
			System.out.println("\n�����Ͻ� �۾��� �������ּ���.\n1. Encryption\n2. Decryption\n3. Quit"); //������ �۾� ����
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("������ ���� �� �� ����ϳ���?");
				int ringnum = sc.nextInt(); //����� ���� ���� �Է� �� ����
				System.out.print("���� ����� �� ��ȣ�� �Է����ּ���: ");
				int[] ringaddress = new int[ringnum];
				for (int i = 0; i<ringnum;i++)
				{
					ringaddress[i]=sc.nextInt(); //������ �� ������ �迭�� ������ (�ε��� ������� ���)
				}
				System.out.println("��ȣȭ�� ���ڸ� �ܸ��� �� �������� ������ �ۼ����ּ���.");
				String blank = sc.nextLine();
				String plainText = sc.nextLine();
				String[] encryptedText = new String[plainText.length()];
				int howmanyen = 0; //��ȣȭ�� ���� ���� ���� �� ȸ���ϱ� ���� ����
				int secondtolast = 0; //���������� �ι�° ���� ȸ���ϱ� ���� ����
				
				for (int i = 0; i < plainText.length(); i++)
				{
					String letter = plainText.substring(i,i+1); //���� �ϳ��� ó��
					for (int j = 0; j<ringnum;j++) //���� �ϳ� �� �� ��� ����
					{
						int inputletter = koreanToNum(letter);
						if (inputletter == -1)
						{
							System.out.println("����� �� �ִ� ���ڸ� ������ּ���! ([ex] ���߸����� �ܸ������� ����, ���� ��ȣ �� ���� ����)");
						}
						String[] thisring = Arrays.copyOf(decideRing(ringaddress[j]), 24); //�̹��� ����� ���� ���ڿ� �迭 �����ؿ���
						if (secondtolast == 0) {//���������� �ι�° �� ȸ������ �����ϴ� if��
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
					
					if(howmanyen%24==0 && howmanyen/24>0) {//���� ������ ���� ȸ�� ���� 24�� ������ ���������� �ι�° �� �̵� ĭ �� ++
						secondtolast++;
					}
					
				}
				
				for (int i = 0; i<plainText.length(); i++)
				{
					System.out.print(encryptedText[i]);
				}
			
			
			}//if �� ��
			else if (choice==2){
				System.out.println("������ ���� �� �� ����ϳ���?");
				int ringnum = sc.nextInt(); //����� ���� ���� �Է� �� ����
				System.out.print("���� ����� �� ��ȣ�� �Է����ּ���: ");
				int[] ringaddress = new int[ringnum];
				for (int i = 0; i<ringnum;i++)
				{
					ringaddress[i]=sc.nextInt(); //������ �� ������ �迭�� ������ (�ε��� ������� ���)
				}
				System.out.println("��ȣȭ�� ���ڸ� �ۼ����ּ���.");
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
								String outputletter = numToKorean((reverse-secondring-1+24)%24); //��� 24�� ���ϴ� ������ ������ ���� indexoutofrange ������ ���ϱ� ���ؼ�..
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
				
			}//else if �� ��
			else if(choice==3){
				keepgoing = false;
			}
			else {
				System.out.println("�־��� �ɼ� (1,2,3) �� ������ �۾��� ������ �ּ���.");
			}
		}
		
		sc.close();
	}

}
