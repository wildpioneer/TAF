package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Expose
    private String name;
    private String surname;
    @Expose
    private String email;
    @Expose
    @SerializedName(value = "is_active")
    private boolean isActive;
    private int age;
    @Expose
    private int id;
    @Expose
    private int role_id;
    @Expose
    private String role;

    private String username;
    private String password;
    private String address;
}
