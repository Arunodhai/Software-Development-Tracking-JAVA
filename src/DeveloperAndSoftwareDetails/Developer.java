package DeveloperAndSoftwareDetails;

public class Developer {

    private String name,id,currentlyworkingsoftware,finishedsoftwares;


    public Developer() {}

    public Developer(String name, String currentlyworkingsoftware, String finishedsoftwares) {
        super();
        this.name = name;
        this.currentlyworkingsoftware = currentlyworkingsoftware;
        this.finishedsoftwares = finishedsoftwares;
    }

    public Developer(String id, String name, String currentlyworkingsoftware, String finishedsoftwares) {
        super();
        this.id = id;
        this.name = name;
        this.currentlyworkingsoftware = currentlyworkingsoftware;
        this.finishedsoftwares = finishedsoftwares;
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = String.valueOf(id);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCurrentlyWorkingSoftware() {
        return currentlyworkingsoftware;
    }
    public void setCurrentlyWorkingSoftware(String currentlyworkingsoftware) {
        this.currentlyworkingsoftware = currentlyworkingsoftware;
    }
    public String getFinishedSoftwares() {
        return finishedsoftwares;
    }
    public void setFinishedSoftwares(String finishedsoftwares) {
        this.finishedsoftwares = finishedsoftwares;
    }

}