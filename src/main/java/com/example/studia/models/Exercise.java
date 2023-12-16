

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int duration;  // czas trwania w sekundach can be null

    public Exercise() {
        // domyślne wartości lub puste inicjalizacje
    }

    // Konstruktor z argumentami
    public Exercise(String name, String description, int sets, int reps, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

}