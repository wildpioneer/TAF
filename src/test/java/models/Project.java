package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    @SerializedName(value = "suite_mode")
    private int typeOfProject;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    private User user;
}
