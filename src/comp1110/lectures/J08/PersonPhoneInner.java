package comp1110.lectures.J08;

public class PersonPhoneInner {
    public class CellPhone{
        String brand;

        public CellPhone(String brand) {
            this.brand = brand;
        }

        @Override
        public String toString(){
            return brand + " of great quality making " + Personname + "'s life easier" ;
        }
    }

    public String Personname;
    public CellPhone cellphone;

    public PersonPhoneInner(String personname, String cellphoneBrand ) {
        this.Personname = personname;
        this.cellphone = new CellPhone(cellphoneBrand);
    }

    public String toString(){
        return Personname + "has cellphone " + cellphone.toString();
    }

}
