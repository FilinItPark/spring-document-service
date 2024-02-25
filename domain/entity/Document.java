package ru.flanker.documentsservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "documents")
public class Document {
    @Id
    @SequenceGenerator(name = "documents_id_sequence", sequenceName = "documents_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documents_id_sequence")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    private Category category;
}
