public class MVCPatternExample {

    // Step 2: Model Class
    static class Student {

        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 3: View Class
    static class StudentView {

        public void displayStudentDetails(String name,
                                          int id,
                                          String grade) {

            System.out.println("Student Details");
            System.out.println("Name : " + name);
            System.out.println("ID   : " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Step 4: Controller Class
    static class StudentController {

        private Student model;
        private StudentView view;

        public StudentController(Student model,
                                 StudentView view) {

            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(
                    model.getName(),
                    model.getId(),
                    model.getGrade()
            );
        }
    }

    // Step 5: Test MVC Pattern
    public static void main(String[] args) {

        Student student =
                new Student("Aadira", 101, "A");

        StudentView view =
                new StudentView();

        StudentController controller =
                new StudentController(student, view);

        System.out.println("Initial Details:");
        controller.updateView();

        System.out.println();

        controller.setStudentName("Raj");
        controller.setStudentGrade("A+");

        System.out.println("Updated Details:");
        controller.updateView();
    }
}