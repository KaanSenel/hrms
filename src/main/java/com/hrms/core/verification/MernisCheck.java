package com.hrms.core.verification;

import com.hrms.entities.concretes.JobSeeker;
import mernis.ADAKPSPublicSoap;

public class MernisCheck {

    public static boolean mernisCheck(JobSeeker jobSeeker) throws Exception {

        /*
        ADAKPSPublicSoap client=new ADAKPSPublicSoap();

        return client.TCKimlikNoDogrula(Long.getLong(jobSeeker.getIdentityNumber()),
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getYearOfBirth());

         */

       return true;
    }
}
