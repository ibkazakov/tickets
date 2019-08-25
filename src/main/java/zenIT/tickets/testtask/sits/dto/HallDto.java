package zenIT.tickets.testtask.sits.dto;

public class HallDto {
    private Long id;

    private String name;

    private String city;

    private Integer sitsNumber;


    public HallDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Integer getSitsNumber() {
        return sitsNumber;
    }

    public void setSitsNumber(Integer sitsNumber) {
        this.sitsNumber = sitsNumber;
    }
}
