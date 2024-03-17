package ru.flanker.documentsservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.flanker.documentsservice.domain.valueobject.TimeInfo;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "users")
public class User {
    /*
  identity:
  newId = select nextval(sequence_name);
  newId -> entity

  sequence:
  newId = select nextval(sequence_name, allocationSize= >1) -> ALLOCATION айдишников
  allocation раз добавить новую сущность без запроса максимального ида из базы данных
   */
    @Id
    @SequenceGenerator(name = "users_id_sequence", sequenceName = "users_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_sequence")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private String password;

    @Embedded
    private TimeInfo timeInfo;

    @ManyToMany
    @JoinTable(
            name = "users_documents",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Document> documents = new ArrayList<>();
}
