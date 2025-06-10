package com.ssss.smallScaleShiftScheduler.model;

import jakarta.persistence.*;


@Entity
@Data  // Generál gettereket, settereket, toString(), equals(), hashCode()
@NoArgsConstructor  // Üres konstruktor
@AllArgsConstructor  // Minden mezőt tartalmazó konstruktor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable=false, length = 100)
    private String name;

    @Column(unique = true, nullable=false, name = "short_name", length = 50)
    private String shortName;

    @Column(unique = true, nullable = false, length = 5)  // Egyedi érték
    private String monogram;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "internal_phone", nullable = false, length = 20)
    private String internalPhoneNumber;

    @Column(nullable = false, unique = true)  // Kötelező és egyedi
    private String email;

    @Column(nullable = false)
    private boolean active = true;

    public  Employee(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id != null && id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}