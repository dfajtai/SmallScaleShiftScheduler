package com.ssss.smallScaleShiftScheduler.model;

import jakarta.persistence.*;


@Entity
@Data  // Generál gettereket, settereket, toString(), equals(), hashCode()
@NoArgsConstructor  // Üres konstruktor
@AllArgsConstructor  // Minden mezőt tartalmazó konstruktor
public class ShiftTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING) // Az enum neve (pl. "WORK_8H") kerül az adatbázisba
    private ShiftType shiftType;

    private LocalTime startTime;
    private LocalTime endTime;

    @Min(0)
    private int requiredEmployees;

    @ManyToMany
    @JoinTable(
            name = "shift_qualification",
            joinColumns = @JoinColumn(name = "shift_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> qualifiedEmployees = new HashSet<>();

}
