package com.ms.Service;

import com.ms.Entity.Payments;

import java.util.List;

public interface Iquery {

    public List<Payments> allPaymentsInfo();

    public List<Payments> statusInfo(String status);

    public List<Payments> bankAndStatusInfo(List<String> bankAndStatus, String bankName);

    public List<Object[]> bankAndBankInfo(Float minAmount, Float maxAmount);

    public List<Object[]> maximumAmount();

    public Integer updatemobileNo(String mobileNo,String payorname);

    public Integer deletepayor(String payorname);

}
