package gov.irs;

public interface IRS {
    public void register(TaxPayer payer);
    public void collectTaxes();

//    static factory method for the IRSEnum.INSTANCE
    public static IRS getInstance(){
        return IRSEnum.getInstance();
    }
}
