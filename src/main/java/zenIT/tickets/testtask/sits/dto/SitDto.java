package zenIT.tickets.testtask.sits.dto;

public class SitDto {
    private Long id;
    private Integer range;
    private Integer rangeSit;

    public SitDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getRangeSit() {
        return rangeSit;
    }

    public void setRangeSit(Integer rangeSit) {
        this.rangeSit = rangeSit;
    }
}
