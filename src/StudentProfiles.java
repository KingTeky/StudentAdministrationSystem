public class StudentProfiles {
    private String name;
    private String id;

    /**
     * Constructor to create a new student.
     * @param name the name of the student
     * @param id the ID of the student
     */
    public StudentProfiles(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Gets the name of the student.
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the student.
     * @return the ID of the student
     */
    public String getId() {
        return id;
    }
}
