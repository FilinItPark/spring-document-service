package ru.flanker.documentsservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import ru.flanker.documentsservice.domain.valueobject.TimeInfo;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "applications")
public class Application {

    @Id
    @SequenceGenerator(name = "applications_id_sequence", sequenceName = "applications_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applications_id_sequence")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String description;

    @Embedded
    private TimeInfo timeInfo;
}
