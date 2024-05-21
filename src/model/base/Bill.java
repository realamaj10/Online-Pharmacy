package model.base;

public class Bill {
        private String bid;
	private String prodName;
	private String quantity;
	private String pharma;
	private String rd;

    public Bill(String bid, String prodName, String quantity, String pharma, String rd) {
        this.bid = bid;
        this.prodName = prodName;
        this.quantity = quantity;
        this.pharma = pharma;
        this.rd = rd;
    }

    public Bill() {
        super();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPharma() {
        return pharma;
    }

    public void setPharma(String pharma) {
        this.pharma = pharma;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    @Override
    public String toString() {
        return "Bill: " + "bid=" + bid + ", \n"
                + "prodName=" + prodName + ", \n"
                + "quantity=" + quantity + ", \n "
                + "pharma=" + pharma + ",\n"
                + " rd=" + rd;
    }

  
        
}
