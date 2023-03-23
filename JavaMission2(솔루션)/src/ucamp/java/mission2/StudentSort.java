package ucamp.java.mission2;


public class StudentSort {
	private static Student[] studentArr;	//4바이트
	
	public static void main(String[] args) {
		createStudentInfoFromInput();
		
		printStudentInfo("[입력된 학생정보]");

		SortStudentInfoByAgeDesc();
		printStudentInfo("[나이 내림차순 정렬결과]");
		
		SortStudentInfoByName();
		printStudentInfo("[이름 오름차순 정렬결과]");
		
		while(SearchStudentByName());
		
		System.out.println("\n#프로그램을 종료합니다.");
	}
	
	private static void createStudentInfoFromInput()
	{
		int numOfStudent;	//등록된 학생 수
		
		System.out.print(">> 등록할 학생 수를 입력하세요: ");
		numOfStudent = Utility.inputNumber();
		
		studentArr = new Student[numOfStudent];	//학생 객체를 저장할 배열을 생성
		
		for (int i = 0; i < studentArr.length; i++) {
			Student student = new Student();
			
			System.out.println("[" + (i + 1) + "번째 학생정보 입력]");
			System.out.print("학번: ");
			student.studentNo = Utility.inputString();
			
			//제공되는 메서드를 활용하여 키 입력된 값으로 나머지 필드들(이름, 나이, 전화번호)을 초기화
			System.out.print("이름: ");
			student.name = Utility.inputString();
			
			System.out.print("나이: ");
			student.age = Utility.inputNumber();
			
			System.out.print("전화번호: ");
			student.phoneNo = Utility.inputString();
			
			studentArr[i] = student;
			
			System.out.println();
		}
		
		System.out.println();
	}

	private static void printStudentInfo(String title)
	{
		System.out.println(title);
		System.out.println("--------------------------------------------");
		System.out.println("학번\t이름\t나이\t전화번호");
		System.out.println("--------------------------------------------");
		
		for(Student student : studentArr) {
			System.out.print(student.studentNo + "\t");
			System.out.print(student.name + "\t");
			System.out.print(student.age + "\t");
			System.out.println(student.phoneNo);
		}
		
//		for(int i = 0; i < studentArr.length; i++) {
//			System.out.print(studentArr[i].studentNo + "\t");
//			System.out.print(studentArr[i].name + "\t");
//			System.out.print(studentArr[i].age + "\t");
//			System.out.println(studentArr[i].phoneNo);
//		}
		
		System.out.println("--------------------------------------------");
		System.out.println();
	}
	
	private static void SortStudentInfoByName() {
		for(int i = 0; i < studentArr.length - 1; i++) {
			for(int j = i + 1; j < studentArr.length; j++) {
				if (studentArr[i].name.compareTo(studentArr[j].name) > 0) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}
	
	private static void SortStudentInfoByAgeDesc() {
		for(int i = 0; i < studentArr.length - 1; i++) {
			for(int j = i + 1; j < studentArr.length; j++) {
				if (studentArr[i].age < studentArr[j].age) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}
	
	private static boolean SearchStudentByName() {
		System.out.print(">> 검색할 학생의 학번을 입력하세요(프로그램 종료: q): ");
		String studentNo = Utility.inputString();
		
		if (studentNo.equals("q"))
			return false;
		
		for(int i = 0; i < studentArr.length; i++) {
			if (studentArr[i].studentNo.equals(studentNo)) {
				System.out.println("--------------");
				System.out.println("이름: " + studentArr[i].name);
				System.out.println("나이: " + studentArr[i].age);
				System.out.println("전화번호: " + studentArr[i].phoneNo);
				System.out.println("--------------");
				
				return true;
			}
		}
		
		for(Student s : studentArr) {
			if (s.studentNo.equals(studentNo)) {
				System.out.println("--------------");
				System.out.println("이름: " + s.name);
				System.out.println("나이: " + s.age);
				System.out.println("전화번호: " + s.phoneNo);
				System.out.println("--------------");
				
				return true;
			}
		}
		//배열을 탐색하여 학번에 해당하는 학생정보가 존재하는 경우(equals() 메서드로 문자열 비교) 
		//학생정보(이름, 나이, 전화번호)를 출력하고 true를 반환
		//입력한 학번에 해당하는 학생정보가 존재하지 않는 경우, 메세지 출력 후 true 반환 
		
		System.out.println("#학번이 " + studentNo + "인 학생은 존재하지 않습니다.");
		
		return true;
	}
}
