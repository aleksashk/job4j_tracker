package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
        } else {
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen targetCitizen = null;
        for (String passportNumber : citizens.keySet()) {
            Citizen citizen = citizens.get(passportNumber);
            if (passport.equals(passportNumber)) {
                targetCitizen = citizen;
            }
        }
        return targetCitizen;
    }
}