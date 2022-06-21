package sample.study.stt.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Name {
    @Id
    @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String name;

    public Name(String arg){
        this.name = arg;
    }
}
