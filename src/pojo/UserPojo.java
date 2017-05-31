package Pojo;

public class UserPojo {
    private String uname;
    private String password;
    private String category;
private String modulename;
private String formname;
private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFormname() {
        return formname;
    }

   

    public void setFormname(String formname) {
        this.formname = formname;
    }
    public String getUname() {
        return uname;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }
    

    public void setCategory(String category) {
        this.category = category;
    }

    public UserPojo() {
    }
    
    public UserPojo(String modulename) {
        this.modulename=modulename;
    }

    public UserPojo(String uname, String password, String category, String modulename,String formname) {
        this.uname = uname;
        this.password = password;
        this.category = category;
        this.modulename=modulename;
        this.formname=formname;
    }
}
