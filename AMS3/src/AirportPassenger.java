public class AirportPassenger {
    private String name;
    private String surname;
    private int luggageCount;
    private int birthYear;
    private int id;

    public AirportPassenger(String name, String surname, int luggageCount, int birthYear){
        this.name = name;
        this.surname = surname;
        this.luggageCount = luggageCount;
        this.birthYear = birthYear;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setLuggageCount(int luggageCount){
        this.luggageCount = luggageCount;
    }
    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }


    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getLuggageCount(){
        return luggageCount;
    }
    public int getBirthYear(){
        return birthYear;
    }

    public String toString(){
        return name + " " + surname + " " + birthYear;
    }

}
