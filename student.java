package Practice;

public class student {
    String studentID;
    String studentName;
    String Address;
    String phone;
    public student(){
        this.studentID = "";
        this.studentName = "";
        this.Address = "";
        this.phone = "";
    }
    public student(String studentID,String studentName,String address,String phone){
        this.studentID = studentID;
        this.studentName = studentName;
        this.Address = address;
        this.phone = phone;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
