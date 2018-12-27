package medic.esy.es.manager.model;

public class staff {


   private String staffName,staffGender,staffHomePhone,staffWorkPhone,staffAddress,staffCellPhone;

   public staff(){

   }


    public staff(String staffName, String staffGender, String staffHomePhone, String staffAddress) {

        this.staffName = staffName;
        this.staffGender = staffGender;
        this.staffHomePhone = staffHomePhone;
        this.staffAddress = staffAddress;
    }

    public String getStaffCellPhone() {
        return staffCellPhone;
    }

    public void setStaffCellPhone(String staffCellPhone) {
        this.staffCellPhone = staffCellPhone;
    }

    public String getStaffWorkPhone() {
        return staffWorkPhone;
    }

    public void setStaffWorkPhone(String staffWorkPhone) {
        this.staffWorkPhone = staffWorkPhone;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }
}
