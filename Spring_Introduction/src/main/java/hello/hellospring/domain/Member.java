package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

//    database가 알아서 생성해주는 타입 = IDENTITY
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    database의 column name과 같지 않을 경우 아래 어노테이션 작성
    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
