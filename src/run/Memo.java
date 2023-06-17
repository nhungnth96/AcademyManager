package run;

import config.InputMethods;
import model.Classs;
import model.Student;
import model.Teacher;

public class Memo {
    public static void main(String[] args) {

        public static void createTeacher() {
                System.out.println("Nhập thông tin giảng viên: ");
                Student newTeacher = new Student();
                int newId = teacherController.getNewId();
                newTeacher.setUserId(newId);
                System.out.println("ID: " + newId);
                newTeacher.inputStudent(classsController.getClassList(), subjectController.getSubjectList());
                teacherController.save(newTeacher);

        }
        public static void displayTeacherList() {
            if (teacherController.getSize() == 0) {
                System.out.println("Danh sách giảng viên trống");
            }
            for (Teacher teacher : teacherController.getTeacherList()) {
                if (teacher != null) {
                    teacher.display();
                }
            }
        }
        public static void displayTeacherListByClass() {
            System.out.println("Danh sách lớp học: ");
            for (Classs classs : classsController.getClassList()) {
                if (classs != null) {
                    System.out.println(classs);
                }
            }
            System.out.println("Nhập lớp học bạn muốn xem danh sách giảng viên: ");
            String choosenClass = InputMethods.getString();
            for (Classs classs : classsController.getClassList()) {
                if (classs != null && classs.getClassName().equals(choosenClass)) {
                    for (Teacher teacher : teacherController.getTeacherList()) {
                        if (teacher != null && teacher.getClasss().getClassName().equals(choosenClass)) {
                            teacher                        }
                    }
                } else {
                    System.err.println("Không tồn tại lớp học này");
                }
            }
        }
}        public static void displayTeacherById() {
        System.out.println("Nhập ID giảng viên: ");
        int choosenId = InputMethods.getPositiveInteger();
        if (teacherController.getSize() == 0) {
            System.out.println("Danh sách giảng viên trống!!!");
        }
        for (Teacher teacher : teacherController.getTeacherList()) {
            if (teacher != null && teacher.getUserId() == choosenId) {
                teacher.display();
            }
        }
        System.out.println("1. Sửa thông tin giảng viên");
        System.out.println("2. Xóa thông tin giảng viên");
        System.out.println("3. Quay lại");
        int bonusChoice = InputMethods.getInteger();
        switch (bonusChoice) {
            case 1:
                Student editTeacher = teacherController.findById(choosenId);
                editTeacher.inputStudent(classsController.getClassList(), subjectController.getSubjectList());
                teacherController.save(editTeacher);
                break;
            case 2:
                teacherController.delete(choosenId);
                break;
            case 3:
                break;
        }
    }
    public static void searchTeacherByName(){
        System.out.println("Nhập từ khóa tìm kiếm giảng viên:");
        String keyword = InputMethods.getString();
        Teacher[] result = new Teacher[1000];
        int i = 0;
        for (Teacher teacher:teacherController.getTeacherList()){
            if(teacher!=null&&teacher.getFullname().contains(keyword)){
                result[i]=teacher;
                i++;
            }
        }
        for (Teacher teacher:result){
            if(teacher!=null){
                teacher.display();
            }
        }
    }
