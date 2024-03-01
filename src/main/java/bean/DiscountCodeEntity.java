package bean;

public class DiscountCodeEntity {
    private String id;
    private String code;
    private Float percentageOff;
    private String dateStart;
    private String dateEnd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getPercentageOff() {
        return percentageOff;
    }

    public void setPercentageOff(Float percentageOff) {
        this.percentageOff = percentageOff;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

}
