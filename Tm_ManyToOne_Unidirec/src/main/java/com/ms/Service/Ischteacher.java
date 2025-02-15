package com.ms.Service;

import com.ms.Entity.School;
import com.ms.Entity.Teachers;

public interface Ischteacher {

    public String savedatausingParent(School school);

    public String savedatausingChild(Teachers teachers);
}
