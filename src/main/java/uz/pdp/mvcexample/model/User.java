package uz.pdp.mvcexample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String phonenumber;
}
