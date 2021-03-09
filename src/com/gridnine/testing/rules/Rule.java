package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface Rule {
    public boolean isValid(Flight flight);
}
