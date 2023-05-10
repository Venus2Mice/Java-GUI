package DTO;

import java.sql.Date;

public class Staff_DTO {
    private int id_staff;
    private String staff_name;
    private Date brith;
    private String phone;
    private String username;
    private String password;
    private String group_name;
    private boolean active;

    public Staff_DTO() {
    }

    public Staff_DTO(int id_staff, String staff_name, Date brith, String phone, String username, String password,
            String group_name, boolean active) {
        this.id_staff = id_staff;
        this.staff_name = staff_name;
        this.brith = brith;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.group_name = group_name;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
