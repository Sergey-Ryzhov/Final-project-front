package demoqatest.data;

import lombok.Data;

@Data
public class InvalidData {
    private final String inputRedColor = "rgb(220, 53, 69)";
    private final String buttonRedColor = "rgba(220, 53, 69, 1)";
    private final String email = "Почта";
    private final String telephoneNumber = "Телефон";

}
