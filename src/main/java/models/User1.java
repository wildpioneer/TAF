package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class User1 {
    private String name;
    @EqualsAndHashCode.Exclude
    private int id;
    private String email;
    @SerializedName(value = "is_active")
    private boolean isActive;
    private int role_id;
    private String role;
}
