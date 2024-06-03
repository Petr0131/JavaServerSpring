package org.example.studentattendancespring.model.dto;
import org.example.studentattendancespring.entity.GroupEntity;

public class Group {
    private  Long id;
    private  String groupName;

    public static Group toModel(GroupEntity group){
        Group model = new Group();
        model.setGroupName(group.getName());
        model.setId(group.getId());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
