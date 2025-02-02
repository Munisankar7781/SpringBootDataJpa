package com.ms.Service;

import com.ms.Entity.Payments;
import com.ms.Repository.QueryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class queryServiceImpl implements Iquery {

    @Autowired
    private QueryRepo queryRepo;

    @Override
    public List<Payments> allPaymentsInfo() {
        List<Payments> list = queryRepo.allPaymentsInformation();
        return list;
    }

    @Override
    public List<Payments> statusInfo(String status) {
        List<Payments> list = queryRepo.status(status);
        return list;
    }

    @Override
    public List<Payments> bankAndStatusInfo(List<String> bankAndStatus, String bankName) {
        List<Payments> list = queryRepo.bankStatus(bankAndStatus, bankName);
        return list;
    }

    @Override
    public List<Object[]> bankAndBankInfo(Float minAmount, Float maxAmount) {
        List<Object[]> list = queryRepo.searchAmount(minAmount, maxAmount);
        return list;
    }

    @Override
    public List<Object[]> maximumAmount() {
        return queryRepo.maximumAmount();
    }

    @Override
    @Transactional
    public Integer updatemobileNo(String mobileNo, String payorname) {
        return queryRepo.updatemobileNumber(mobileNo, payorname);
    }

    @Override
    @Transactional
    public Integer deletepayor(String payorname) {
        return queryRepo.deleteByPayorname(payorname);
    }
}
