package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.model.AppelModel;

public interface AppelService {

    AppelModel createFixedAppel();

    AppelModel getAppel(String id);

}
