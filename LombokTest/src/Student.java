import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//these commments gives us useful functions in compile time 
//functions made in Student.class after javac
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    Integer sid;
    String name;
    String gender;
}
