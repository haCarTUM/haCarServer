package de.selectcode.hackaTUM.x17.haCarTUM.server;

public class InsureDummy implements InsuranceCompanyPolicy {
    @Override
    public int doesUserGetRefund(int customer, Object info) {
        return 0;
    }
}
