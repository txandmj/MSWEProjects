public class Student {
    private String studentNum = null;
    private String name = null;
    private String home = null;
    private String program = null;
    private String year = null;
    public Student(String studentNum, String name, String home, String program, String year) {
        this.studentNum = studentNum.trim();
        this.name = name.trim();
        this.home = home.trim();
        this.program = program.trim();
        this.year = year.trim();
    }
    public void setStudentNum(String studentNum) {
        if(studentNum.length() != 7) {
            System.out.println("Invalid input: the length of student number must be 7!");
            return;
        }
        this.studentNum = studentNum;
    }
    public String getStudentNum() {
        return studentNum;
    }
    public void setName(String name) {
        if(name.length() > 25 || name.length() == 0) {
            System.out.println("Invalid input: the length of last name should between [1, 25]");
            return;
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setHome(String home) {
        if(home.length() != 4) {
            System.out.println("Invalid input: the length of home must be 4!");
            return;
        }
        this.home = home;
    }
    public String home() {
        return home;
    }
    public void setProgram(String program) {
        if(program.length() > 4 || program.length() == 0) {
            System.out.println("Invalid input: the length of program should between [1,4]");
            return;
        }
        this.program = program;
    }
    public String getProgram() {
        return program;
    }
    public void setYear(String year) {
        if(Integer.parseInt(year) < 1 || Integer.parseInt(year) > 9) {
            System.out.println("Invalid input: please input the number");
            return;
        }
        this.year = year;
    }
    public char getYear(char year) {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum='" + studentNum + '\'' +
                ", name='" + name + '\'' +
                ", home='" + home + '\'' +
                ", program='" + program + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
