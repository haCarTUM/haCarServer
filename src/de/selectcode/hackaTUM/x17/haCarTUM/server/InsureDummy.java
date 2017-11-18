package de.selectcode.hackaTUM.x17.haCarTUM.server;

public class InsureDummy extends InsuranceCompanyPolicy {
    @Override
    public int doesUserGetRefund(int customer, Object info) {
        return 0;
    }
}
