package hello.jpql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private int age;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
