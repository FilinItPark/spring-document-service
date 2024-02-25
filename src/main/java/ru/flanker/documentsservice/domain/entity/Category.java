package ru.flanker.documentsservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.flanker.documentsservice.domain.valueobject.TimeInfo;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @SequenceGenerator(
            name = "categories_id_sequence",
            sequenceName = "categories_id_seq"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Embedded
    private TimeInfo timeInfo;
}
