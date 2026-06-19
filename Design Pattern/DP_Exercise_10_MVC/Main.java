public class Main {
    public static void main(String[] args) {
        Student model = new Student("John Doe", "S12345", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
