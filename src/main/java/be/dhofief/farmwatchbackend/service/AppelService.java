package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.commons.SystemException;
import be.dhofief.farmwatchbackend.commons.ValidationException;
import be.dhofief.farmwatchbackend.model.AppelModel;

public interface AppelService {

    AppelModel createFixedAppel();

    AppelModel getAppel(String id);

    AppelModel createAppel(AppelModel appelModel) throws ValidationException, SystemException;

}
